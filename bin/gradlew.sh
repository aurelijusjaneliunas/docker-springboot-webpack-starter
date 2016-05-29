#!/bin/bash

#install gradle wrapper
source bin/env.sh

dcdev run --rm springboot ./bin/install_gradlew.sh $@
