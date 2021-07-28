FROM openjdk:8-jdk-alpine

EXPOSE 8080

WORKDIR /app

COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

ENTRYPOINT [ "java", "-jar", "demo.jar" ]

