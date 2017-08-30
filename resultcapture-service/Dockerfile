FROM java:8-jre
MAINTAINER Dragan Ljubojevic <dragan.ljubojevic@gmail.com>
ADD ./target/resultcapture-service.jar /app/
CMD [ "java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=7980 -Xmx512m", "-jar", "/app/resultcapture-service.jar"]

EXPOSE 7979 7980