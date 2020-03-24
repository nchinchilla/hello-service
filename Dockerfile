FROM openjdk:8-jdk-alpine
COPY ./target/hello-services-1.0-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
CMD ["java", "-jar", "hello-services-1.0-SNAPSHOT.jar"]
