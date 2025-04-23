FROM openjdk:21
LABEL authors="azmat"
VOLUME /tmp
COPY target/site-service.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]