From openjdk:17
ADD target/Flights-docker.jar Flights-docker.jar
ENTRYPOINT ["java","-jar","Flights-docker.jar"]