#!/usr/bin/env bash
mvn clean package
docker-compose up -d --build
docker logs -f survey_authoring-service_1
