#!/usr/bin/env bash
args=("$@")
if test "$#" -eq 1; then
    mvn clean package -pl ${args[0]}
    docker-compose up -d --no-deps --build ${args[0]}
    docker-compose logs -f ${args[0]}
else
    mvn clean package
    docker-compose up -d --build
fi
