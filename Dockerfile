# Etapa de construção (Build Stage)
FROM maven:3.8.7-eclipse-temurin-17 AS build

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo pom.xml e as dependências para o contêiner
COPY pom.xml ./

# Baixe todas as dependências de maven (esta etapa é separada para aproveitar o cache do Docker)
RUN mvn dependency:go-offline

# Copie o código-fonte para o contêiner
COPY src ./src

# Compile o código e empacote-o como um arquivo .jar
RUN mvn clean package -DskipTests

# Etapa de execução (Runtime Stage)
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho para a aplicação
WORKDIR /app

# Copie o arquivo .jar gerado da etapa de build para o contêiner final
COPY --from=build /app/target/*.jar /app/application.jar

# Exponha a porta em que a aplicação vai rodar
EXPOSE 8080

# Use o comando ENTRYPOINT para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app/application.jar"]
