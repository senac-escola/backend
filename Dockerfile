FROM maven:3.9.5-eclipse-temurin-21-alpine as build

LABEL authors="Amanda Martins Xavier <hi@amandamartins.dev>"
LABEL version="1.0.0"
LABEL description="Imagem Docker do backend da aplicação web Escola."

WORKDIR /app

ARG SPRING_PROFILES_ACTIVE

ARG DB_CONNECTION_STRING

ARG DB_USER

ARG DB_PASSWORD

COPY src src

COPY pom.xml pom.xml

RUN mvn clean package

FROM eclipse-temurin:21-jre-alpine

ARG SPRING_PROFILES_ACTIVE

ARG DB_CONNECTION_STRING

ARG DB_USER

ARG DB_PASSWORD

COPY --from=build /app/target/*.jar /usr/share/app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/usr/share/app.jar"]