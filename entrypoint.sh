#!/bin/bash

mvn clean install && \
mvn liquibase:update && \
mv target/*.jar app.jar && \
java -jar app.jar
