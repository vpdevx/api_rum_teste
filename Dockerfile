# Etapa de construção (Build Stage)
FROM maven:3.8.7-eclipse-temurin-17 AS build

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

COPY pom.xml ./

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar /app/application.jar

RUN curl -Lo dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'

EXPOSE 8080

ENTRYPOINT ["java", "-javaagent:/app/dd-java-agent.jar", "-jar", "/app/application.jar"]
