FROM openjdk:8
EXPOSE 8080
ADD target/*.jar test.jar
ADD serviceAccountKey.json serviceAccountKey.json
ENTRYPOINT ["java", "-jar", "/test.jar"]

