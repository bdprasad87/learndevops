FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/naming-server.jar
WORKDIR /opt/app
COPY ${JAR_FILE} naming-server-app.jar
ENTRYPOINT ["java","-jar","naming-server-app.jar"]