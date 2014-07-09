#!/bin/bash

# dead simple script to create an empty project

if [ "$1" = "" ]
then
 echo "Usage: $0 <name of the project to create>"
 exit
fi
PROJECT=$1

mkdir -p ${PROJECT}/src/main/java
mkdir -p ${PROJECT}/src/main/groovy
mkdir -p ${PROJECT}/src/main/resources
mkdir -p ${PROJECT}/src/main/filters
mkdir -p ${PROJECT}/src/main/config
mkdir -p ${PROJECT}/src/main/scripts
mkdir -p ${PROJECT}/src/main/webapp
mkdir -p ${PROJECT}/src/test/java
mkdir -p ${PROJECT}/src/test/groovy
mkdir -p ${PROJECT}/src/test/resources
mkdir -p ${PROJECT}/src/test/filters
mkdir -p ${PROJECT}/src/assembly
touch ${PROJECT}/LICENSE.txt
touch ${PROJECT}/NOTICE.txt
touch ${PROJECT}/README.md
touch ${PROJECT}/.gitignore
touch ${PROJECT}/build.gradle
touch ${PROJECT}/gradle.properties
touch ${PROJECT}/settings.gradle
