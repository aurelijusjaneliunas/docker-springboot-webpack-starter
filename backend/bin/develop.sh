#!/bin/bash

./bin/gradle_clean.sh

#Enable spring boot and live reaload
nohup ./bin/gradle_watch.sh &
nohup ./bin/gradle_boot.sh &                                                                                                                                                                                                                                                                                                                                                                       bootRun &

#Lock the application
./bin/enldess_loop.sh