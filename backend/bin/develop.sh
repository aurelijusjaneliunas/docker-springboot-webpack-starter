#!/bin/bash

#Enable spring boot and live reaload
gradle clean
nohup gradle build -continuous &
nohup gradle bootRun &                                                                                                                                                                                                                                                                                                                                                                       bootRun &

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
