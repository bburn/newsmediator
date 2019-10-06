FROM java:8-jdk-alpine
ADD target/newsmediator-0.0.1-SNAPSHOT.war app.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "newsmediator-0.0.1-SNAPSHOT.war"]