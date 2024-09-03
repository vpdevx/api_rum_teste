# Etapa de construção (Build Stage)
FROM maven:3.8.7-eclipse-temurin-17 AS build

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo pom.xml para o diretório de trabalho
COPY pom.xml ./

# Baixa todas as dependências do Maven para que estejam disponíveis offline
RUN mvn dependency:go-offline

# Copia o código-fonte da aplicação para o diretório de trabalho
COPY src ./src

# Compila o código e gera o pacote sem executar os testes
RUN mvn clean package -DskipTests

# Etapa final (Runtime Stage)
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR gerado na etapa de build para o diretório de trabalho da etapa final
COPY --from=build /app/target/*.jar /app/application.jar

# Instala o curl para baixar o agente Java do Datadog
RUN apt-get update && apt-get install -y curl && apt-get clean

# Baixa o Datadog Java Tracer
RUN curl -Lo dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'

# Expõe a porta 8080
EXPOSE 8080

# Define o comando de entrada para iniciar a aplicação com o agente Datadog
ENTRYPOINT ["java", "-javaagent:/app/dd-java-agent.jar", "-jar", "/app/application.jar"]
