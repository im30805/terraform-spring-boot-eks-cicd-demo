#FROM openjdk:17
FROM openjdk:17-jdk-slim
ADD target/demo-0.0.1-SNAPSHOT.jar  demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]