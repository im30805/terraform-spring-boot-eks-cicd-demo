#FROM openjdk:17
FROM amazoncorretto:17.0.10-al2-native-jdk
ADD target/demo-0.0.1-SNAPSHOT.jar  demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]