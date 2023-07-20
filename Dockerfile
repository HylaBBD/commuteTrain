FROM eclipse-temurin:17-jdk-jammy

COPY backend/target/backend-0.0.1-SNAPSHOT.jar backend-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/backend-0.0.1-SNAPSHOT.jar"]