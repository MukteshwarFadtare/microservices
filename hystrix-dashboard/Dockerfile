FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} hystrix-dashboard-service.jar
ENTRYPOINT ["java","-jar","/hystrix-dashboard-service.jar"]
EXPOSE 9295