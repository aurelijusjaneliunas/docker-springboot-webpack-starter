#!/bin/bash

./gradlew clean
nohup ./gradlew build -continuous &
nohup ./gradlew bootRun &

for (( ; ; ))
do
   echo "Pres CTRL+C to stop..."
   sleep 100
   if (disaster-condition)
   then
	   break
   fi
done
