FROM java:8-jdk-alpine
ADD target/newsmediator-service-0.0.1-SNAPSHOT.war app.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "newsmediator-service-0.0.1-SNAPSHOT.war"]