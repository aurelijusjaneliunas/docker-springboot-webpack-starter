#!/bin/bash
./bin/install_gradlew.sh

./gradlew build && java -Djava.security.egd=file:/dev/./urandom -jar build/libs/backend-1.0.0.jar
