FROM openjdk:21
LABEL authors="azmat"
VOLUME /tmp
COPY target/organization-service.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/app.jar"]