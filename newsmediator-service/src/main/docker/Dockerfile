FROM openjdk:8
VOLUME /tmp
COPY newsmediator-service-0.0.1-SNAPSHOT.jar /usr/local/app.jar
RUN sh -c 'touch /usr/local/app.jar'
ENTRYPOINT [ "sh", "-c", "java -Djava.security.edg=file:/dev/./urandom -jar /usr/local/tomcat/webapps/app.jar" ]