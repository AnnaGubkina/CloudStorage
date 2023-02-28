FROM openjdk:17-alpine
EXPOSE 8091
ENV TZ Europe/Moscow
ADD target/CloudService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]