FROM eclipse-temurin:17-jdk-jammy

EXPOSE 8081

COPY target/backend-0.0.1-SNAPSHOT.jar backend-0.0.1-SNAPSHOT.jar
ADD public/ public/

ENTRYPOINT ["java","-jar","/backend-0.0.1-SNAPSHOT.jar","-Dspring.profiles.active=prod"]
