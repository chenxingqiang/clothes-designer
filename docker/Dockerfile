# Use an official OpenJDK runtime as a parent image
FROM openjdk:8-jdk

# Set the working directory in the container
WORKDIR /usr/src/app

# Argument to pass in the clothesdesigner version at build time
ARG clothesdesigner_VERSION

# Install necessary packages, including MySQL client
RUN apt-get update && \
    apt-get install -y default-mysql-client unzip && \
    rm -rf /var/lib/apt/lists/*

# Install the vim editor.
RUN apt-get update && \
    apt-get install -y vim && \
    rm -rf /var/lib/apt/lists/*

# Update the package list and install iputils-ping.
RUN apt-get update && apt-get install -y iputils-ping

# 更新包列表并安装 dnsutils 包
RUN apt-get update && apt-get install -y dnsutils

# Copy the clothesdesigner standalone zip file into the container
COPY assembly/build/clothesdesigner-standalone-${clothesdesigner_VERSION}.zip .

# Unzip the clothesdesigner standalone zip
RUN unzip clothesdesigner-standalone-${clothesdesigner_VERSION}.zip && \
    rm clothesdesigner-standalone-${clothesdesigner_VERSION}.zip

# Create a symbolic link to the clothesdesigner installation directory
RUN ln -s /usr/src/app/clothesdesigner-standalone-${clothesdesigner_VERSION} /usr/src/app/clothesdesigner-standalone-latest

# Set the working directory to the clothesdesigner installation directory
WORKDIR /usr/src/app/clothesdesigner-standalone-${clothesdesigner_VERSION}

# Expose the default port
EXPOSE 9080
# Command to run the clothesdesigner daemon
RUN chmod +x bin/clothesdesigner-daemon.sh
CMD ["bash", "-c", "bin/clothesdesigner-daemon.sh restart standalone prd && tail -f /dev/null"]