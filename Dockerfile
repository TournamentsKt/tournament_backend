FROM eclipse-temurin:21-jdk-alpine
LABEL authors="Emery Tanghanwaye"

COPY build/libs/tournaments*.jar tournaments.jar

ENTRYPOINT ["java", "-jar", "/tournaments.jar"]