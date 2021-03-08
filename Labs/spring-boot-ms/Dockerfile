FROM ubuntu
RUN apt-get -y update
RUN apt-get -y install openjdk-8-jdk wget
RUN mkdir /opt/tomcat
#COPY /edudca/images/code/tomcat-8.5.37.tar.gz /learndevops/Labs/spring-boot-ms/
ADD tomcat-8.5.37.tar.gz /tmp
RUN mv /tmp/apache-tomcat-8.5.37/* /opt/tomcat
COPY SampleWebApp.war /opt/tomcat/webapps
EXPOSE 8080
CMD ["/opt/tomcat/bin/catalina.sh","run"]
