FROM openjdk:21-ea-1-jdk-slim

WORKDIR /app

COPY target/email-0.0.1-SNAPSHOT.jar /app/email.jar

EXPOSE 8082

CMD ["java", "-jar", "/app/email.jar"]