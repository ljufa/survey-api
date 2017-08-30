FROM java:8-jre
MAINTAINER Dragan Ljubojevic <dragan.ljubojevic@gmail.com>
ADD ./target/resultcapture-service.jar /app/
CMD [ "java", "-Xmx512m", "-jar", "/app/resultcapture-service.jar"]

EXPOSE 7979