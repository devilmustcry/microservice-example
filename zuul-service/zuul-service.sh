#!/bin/sh
while ! nc -z config-service 8585 ; do
    echo "Waiting for the Config Server"
    sleep 3
done
while ! nc -z eureka-service 8888 ; do
    echo "Waiting for the Eureka Server"
    sleep 3
done
java -jar ./zuul-service-0.0.1-SNAPSHOT.jar