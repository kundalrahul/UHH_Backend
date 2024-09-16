# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the application's JAR file to the container
COPY target/appointment-tracker-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Cloud Run will use (default: 8080)
EXPOSE 8080

# Run the JAR file and set the server port from the PORT environment variable
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT:-8080}"]
