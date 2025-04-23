FROM openjdk:21
VOLUME /tmp
COPY target/user-service.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]