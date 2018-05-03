# Charter Enterprise MOTD Sample Project
A small project to allow users to view and publish a Message of the Day.

## Prerequisites
* Java 1.8
* Maven
* cURL
* Docker

## Getting Started
* To compile
```mvn clean package```

* To run
```mvn spring-boot:run```

* To see the message:
```curl localhost:8080```

* To set the message:
```curl -X PUT -d 'SAMPLE MESSAGE OF THE DAY' localhost:8080```
 **Note:** The webservice will return a 400 error if you try to set the message to be empty, because that would be a dull message of the day!

## Deployment
This has been [deployed](http://35.231.44.200:8080) using Docker on Google Cloud Platform. Either build the jar file locally on the server to deploy, or transfer the jar file and [Dockerfile](Dockerfile) to the server (by default, the built jar file is located at /target/motd-code-sample-1.0-SNAPSHOT.jar). Navigate to the directory containing the jar file and the Dockerfile.

* To build the Docker image:
```docker build --tag=motd-server --build-arg JAR_FILE=motd-code-sample-1.0-SNAPSHOT.jar .```

* To run the Docker image:
```sudo docker run --publish=8080:8080 -d motd-server```