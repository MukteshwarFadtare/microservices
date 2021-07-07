FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} proxy-gateway-service.jar
ENTRYPOINT ["java","-jar","/proxy-gateway-service.jar"]
EXPOSE 9191