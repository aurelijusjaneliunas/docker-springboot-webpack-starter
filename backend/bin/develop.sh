#!/bin/bash

#Install gradle wrapper
./bin/install_gradlew.sh

#Enable spring boot and live reaload
./gradlew clean
nohup ./gradlew build -continuous &
nohup ./gradlew bootRun                                                                                                                                                                                                                                                                                                                                                                         bootRun &

#Lock the application
for (( ; ; ))
do
   echo "Pres CTRL+C to stop..."
   sleep 100
   if (disaster-condition)
   then
	   break
   fi
done
