FROM ibm-semeru-runtimes:open-11-jre-focal

# Exponer el puerto en el que se ejecuta la aplicación
EXPOSE 8080

# Copiar el archivo JAR generado al contenedor
ADD ./target/*.jar ./app.jar

# Comando para ejecutar la aplicación
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]


