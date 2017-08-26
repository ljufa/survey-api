FROM java:8-jre
MAINTAINER Dragan Ljubojevic <dragan.ljubojevic@gmail.com>
ADD ./target/polldefinition-service.jar /app/
CMD [ "java", "-Xmx512m", "-jar", "/app/polldefinition-service.jar"]

EXPOSE 7878