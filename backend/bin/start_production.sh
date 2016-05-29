#!/bin/bash

#Install gradle wrapper
./bin/install_gradlew.sh

#Run application in prod mode
./gradlew build && java -Djava.security.egd=file:/dev/./urandom -jar build/libs/backend-1.0.0.jar
