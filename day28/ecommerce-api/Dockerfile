#Layer 1: Base OS Layer
FROM openjdk:25-jdk-slim

#Layer 2: Set the working directory
WORKDIR /app

#Layer 3: Copy the jar file into the container
COPY target/ecommerce-app.jar app.jar

#Layer 4: Expose the port
EXPOSE 8080

#Layer 5: Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]