FROM java:8-jre
MAINTAINER Dragan Ljubojevic <dragan.ljubojevic@gmail.com>
ADD ./target/authoring-service.jar /app/
CMD [ "java", "-Xmx512m", "-jar", "/app/authoring-service.jar"]

EXPOSE 7878