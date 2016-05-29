#!/bin/bash

#compile frontend production build to frontend/dist

source bin/env.sh

dcdev build
dcdev run --rm frontend npm run-script build
