# Use Amazon Corretto JDK 17 as the parent image
FROM amazoncorretto:17

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file into the container at /app
COPY target/restapi-0.0.1-SNAPSHOT.jar /app/restapi.jar

# Make port 8081 available to the world outside this container (8081 in order to be able to still use 8080 for local builds)
EXPOSE 8081

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/restapi.jar"]