# Use official OpenJDK image
FROM eclipse-temurin:21

# Set working directory
WORKDIR /app

# Copy JAR file into container
COPY target/github-actions-sample-app-0.0.1-SNAPSHOT.jar spring-app.jar

# Expose port
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java","-jar","spring-app.jar"]