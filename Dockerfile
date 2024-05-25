FROM openjdk:21-jdk
EXPOSE 8081
WORKDIR /app

# Copy the JAR file directly to the container
ARG SOURCE_JAR_FILE=target/*.jar
COPY ${SOURCE_JAR_FILE} minispace-powiadomienia-1.0.0.jar

# Use the correct entrypoint
ENTRYPOINT ["java", "-jar", "/app/minispace-powiadomienia-1.0.0.jar"]