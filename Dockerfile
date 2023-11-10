FROM eclipse-temurin:21-jdk-alpine

LABEL authors="Amanda Martins Xavier <hi@amandamartins.dev>"
LABEL version="1.0.0"
LABEL description="Imagem Docker do backend da aplicação web Escola."

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]