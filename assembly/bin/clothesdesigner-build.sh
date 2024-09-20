#!/usr/bin/env bash

sbinDir=$(cd "$(dirname "$0")"; pwd)
chmod +x $sbinDir/clothesdesigner-common.sh
source $sbinDir/clothesdesigner-common.sh
cd $projectDir
MVN_VERSION=$(mvn help:evaluate -Dexpression=project.version | grep -e '^[^\[]')

cd $baseDir
service=$1
if [ -z "$service"  ]; then
  service=${STANDALONE_SERVICE}
fi

function buildJavaService {
  model_name=$1
  echo "starting building clothesdesigner-${model_name} service"
  mvn -f $projectDir clean package -DskipTests
  if [ $? -ne 0 ]; then
      echo "Failed to build backend Java modules."
      exit 1
  fi
  cp $projectDir/launchers/${model_name}/target/*.tar.gz ${buildDir}/
  echo "finished building clothesdesigner-${model_name} service"
}

function buildWebapp {
  echo "starting building clothesdesigner webapp"
  chmod +x $projectDir/webapp/start-fe-prod.sh
  cd $projectDir/webapp
  sh ./start-fe-prod.sh
  cp -fr  ./clothesdesigner-webapp.tar.gz ${buildDir}/
  # check build result
  if [ $? -ne 0 ]; then
      echo "Failed to build frontend webapp."
      exit 1
  fi
  echo "finished building clothesdesigner webapp"
}

function packageRelease {
  model_name=$1
  release_dir=clothesdesigner-${model_name}-${MVN_VERSION}
  service_name=launchers-${model_name}-${MVN_VERSION}
  echo "starting packaging clothesdesigner release"
  cd $buildDir
  [ -d "$release_dir" ] && rm -rf "$release_dir"
  [ -f "$release_dir.zip" ] && rm -f "$release_dir.zip"
  mkdir $release_dir
  # package webapp
  tar xvf clothesdesigner-webapp.tar.gz
  mv clothesdesigner-webapp webapp
  json='{"env": "''"}'
  echo $json > webapp/clothesdesigner.config.json
  mv webapp $release_dir/
  # package java service
  tar xvf $service_name-bin.tar.gz
  mv $service_name/* $release_dir/
  # generate zip file
  zip -r $release_dir.zip $release_dir
  # delete intermediate files
  rm clothesdesigner-webapp.tar.gz $service_name-bin.tar.gz
  rm -rf webapp $service_name $release_dir
  echo "finished packaging clothesdesigner release"
}

#1. build backend services
if [ "$service" == "webapp" ]; then
  buildWebapp
  target_path=$projectDir/launchers/$STANDALONE_SERVICE/target/classes
  tar xvf $projectDir/webapp/clothesdesigner-webapp.tar.gz -C $target_path
  rm -rf $target_path/webapp
  mv $target_path/clothesdesigner-webapp $target_path/webapp
else
  buildJavaService $service
  buildWebapp
  packageRelease $service
fi