FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app

# Copiar archivos de Maven
COPY pom.xml .
COPY src ./src

# Instalar Maven y construir
RUN apk add --no-cache maven && \
    mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiar el JAR compilado
COPY --from=build /app/target/*.jar app.jar

# Exponer puerto
EXPOSE 8084

# Variables de entorno por defecto
ENV SPRING_PROFILES_ACTIVE=prod
ENV PORT=8084

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]