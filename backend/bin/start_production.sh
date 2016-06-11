#!/bin/bash

#Run application in prod mode
ls -an /
gradle build && java -Djava.security.egd=file:/dev/./urandom -jar build/libs/backend-1.0.0.jar
