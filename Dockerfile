FROM openjdk:21-jdk-slim

# Copia o JAR gerado pelo Maven
COPY target/shoppinglist-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java","-jar","/app.jar"]
