FROM openjdk:17-jdk-alpine
WORKDIR /app

#COPY pom.xml .
#COPY src ./src

# Executar o build da aplicação (mvn clean install)
#RUN mvn clean install

COPY target/*.jar /app/app.jar
EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]