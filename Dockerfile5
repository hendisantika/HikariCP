#FROM eclipse-temurin:21-jre-alpine
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
 
## create a nonroot user and group 
RUN addgroup -S spring && adduser -S spring -G spring 
 
## copy the spring jar 
COPY target/*.jar /opt/myApp.jar 
 
## set the nonroot user as the default user 
USER spring:spring 
 
## set the working directory 
WORKDIR /opt 
 
ENTRYPOINT ["java", "-jar", "myApp.jar"] 
 
## expose the port to the external world 
EXPOSE 9000
