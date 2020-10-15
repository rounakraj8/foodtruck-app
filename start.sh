#!/bin/bash

# Build the App
~/Downloads/apache-maven-3.6.3/bin/mvn clean install

# Run the App
java -jar target/foodtruck-app-1.0-SNAPSHOT.jar
