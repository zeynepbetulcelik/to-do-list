FROM openjdk:8-jdk-alpine
MAINTAINER zeynepbetul
COPY target/todolist-0.0.1-SNAPSHOT.jar todolist-1.0.0.jar
ENTRYPOINT ["java","-jar","/todolist-1.0.0.jar"]
EXPOSE 8580
