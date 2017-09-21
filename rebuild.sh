#!/usr/bin/env bash
args=("$@")
if test "$#" -eq 1; then
    ./mvnw clean package -pl ${args[0]} -DskipTests=true
    docker-compose up -d --no-deps --build ${args[0]}
fi
if test "$#" -eq 2; then
    ./mvnw clean package -pl ${args[0]} -DskipTests=true
    docker-compose -f docker-compose.yml -f docker-compose.debug.yml up -d --no-deps --build ${args[0]}
fi
if test "$#" -eq 0; then
    ./mvnw clean package
    docker-compose up -d --build
fi
