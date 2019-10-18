# Start with a base image containing Java runtime
FROM java:8-jdk-alpine

# Add Maintainer Info
MAINTAINER Naresh Saini <naresh.saini@ikea.com>

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/dummyinvokedapi-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} dummyinvokedapi.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/dummyinvokedapi.jar"]