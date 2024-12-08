# Usar una imagen base de Java
FROM openjdk:17-jdk-slim

# Crear el directorio de la app
WORKDIR /app

# Copiar el archivo JAR generado
COPY target/shipment-tracker-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Ejecutar la app
CMD ["java", "-jar", "app.jar"]
