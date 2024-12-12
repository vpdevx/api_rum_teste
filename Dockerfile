FROM maven:3.8.7-eclipse-temurin-17-alpine AS build

WORKDIR /app

COPY pom.xml ./

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar /app/application.jar

RUN apk --no-cache add curl

# RUN curl -Lo dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'

RUN curl -Lo dd-java-agent.jar 'https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar'

EXPOSE 8080

ENTRYPOINT ["java", "-javaagent:/app/opentelemetry-javaagent.jar", "-jar", "/app/application.jar"]
