#!/bin/bash

./gradlew.sh clean
nohup ./gradlew.sh build -continuous &
nohup ./gradlew.sh bootRun &

for (( ; ; ))
do
   echo "Pres CTRL+C to stop..."
   sleep 100
   if (disaster-condition)
   then
	   break
   fi
done
