FROM tomcat:9-jdk8
VOLUME /tmp
COPY newsmediator-service-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/app.war
RUN sh -c 'touch /usr/local/tomcat/webapps/app.war'
ENTRYPOINT [ "sh", "-c", "java -Djava.security.edg=file:/dev/./urandom -jar /usr/local/tomcat/webapps/app.war" ]