#!/usr/bin/bash

docker build -t galdovich95/spring-boot-app:1.0.0 .
docker login
docker push galdovich95/spring-boot-app:1.0.0
