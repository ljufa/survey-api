#!/usr/bin/env bash
mvn clean package
docker-compose down
docker-compose build
docker-compose up -d
docker logs -f survey_polldefinition-service_1