# Stage 1: Build the application
FROM openjdk:17-jdk-slim-buster AS builder

# Install binutils and any other build dependencies
RUN apt-get update && apt-get install -y binutils

# Set the working directory in the builder stage
WORKDIR /app

# Copy your Spring Boot application source code into the container
COPY . .

# Build your Spring Boot application (replace with your actual build command)
RUN ./mvnw clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17-jdk-slim

# Copy the compiled JAR file from the builder stage to the final image
COPY --from=builder /app/target/app-exchange-rate-*-SNAPSHOT.jar app-exchange-rate.jar

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "app-exchange-rate.jar"]