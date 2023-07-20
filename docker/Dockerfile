# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine

# Copy war file
COPY target/*.jar /run.jar

# run the app
CMD ["/usr/bin/java", "-jar", "/run.jar"]