#!/usr/bin/env bash

# Function to execute the build script
execute_build_script() {
  echo "Executing build script: assembly/bin/clothesdesigner-build.sh"
  assembly/bin/clothesdesigner-build.sh
}

# Function to build the Docker image
build_docker_image() {
  local version=$1
  echo "Building Docker image: clothesdesigner:$version"
  docker build --no-cache --build-arg clothesdesigner_VERSION=$version -t xingqiangchen/clothesdesigner:$version -f docker/Dockerfile .
  if [ $? -ne 0 ]; then
    echo "Docker build failed. Exiting."
    exit 1
  fi
  echo "Docker image clothesdesigner:$version built successfully."
}

# Main script execution
VERSION=$1
if [ -z "$VERSION" ]; then
  echo "Usage: $0 <version>"
  exit 1
fi

execute_build_script
build_docker_image $VERSION