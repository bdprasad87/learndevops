FROM ubuntu
RUN apt-get -y  update
RUN apt-get -y install openjdk-8-jdk wget
#RUN apt-get -y install maven
#RUN mvn clean install
ARG JAR_FILE=target/naming-server.jar
COPY ${JAR_FILE} naming-server-app.jar
ENTRYPOINT ["java","-jar","naming-server-app.jar"]
