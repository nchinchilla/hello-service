Getting Started

API Rest for receive and show messages built on Java. It provides two endpoints:

One to insert a new message. The message only can contain 120 characters;
One to return a message by id.

Reference Documentation

API Rest
The API documentation can be found here
http://localhost:8080/swagger-ui.html#/hello-controller/getMessageUsingGET

The following examples illustrate how to use the defined endpoints:

Request on getMessage endpoint:
curl -X GET "http://localhost:8080/intraway/messages/{idMessage}" -H "accept: */*"

Request on saveMessage endpoint:
curl -X POST "http://localhost:8080/intraway/messages" -H "accept: */*" -H "Content-Type: application/json" -d "{\"text\": \"Nahuel\" }"

Tests
A set of unit and integration tests can be found under /src/test/java

Use 'mvn test' for execute the unit tests

$ mvn test


Running the API
There is two alternatives, both depend maven.
    
From Spring Boot Maven plugin
$ mvn spring-boot:run

From Java (it requires Spring Boot Maven plugin to create an executable jar)
$ java -jar target/hello-services-1.0-SNAPSHOT.jar

From Docker Desktop
1. Build an image
docker build -t proj:hello-services
2. run container
docker run -p 8080:8080 proj:hello-services


