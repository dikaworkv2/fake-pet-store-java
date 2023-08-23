# Use the official OpenJDK image as the base image
FROM openjdk:15-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory to the container's working directory
COPY target/your-spring-boot-app.jar app.jar

# Expose the port your Spring Boot app is listening on
EXPOSE 8080

# Specify the command to run when the container starts
CMD ["java", "-jar", "app.jar"]
