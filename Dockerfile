FROM openjdk:19-ea-11-jdk-bullseye

WORKDIR /pet-app
COPY build/libs/fakepetstore-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app is listening on
EXPOSE 4417

# Specify the command to run when the container starts
CMD ["java", "-jar", "app.jar"]
