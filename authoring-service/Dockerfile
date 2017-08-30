FROM java:8-jre
MAINTAINER Dragan Ljubojevic <dragan.ljubojevic@gmail.com>
ADD ./target/authoring-service.jar /app/
CMD [ "java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=7879 -Xmx512m", "-jar", "/app/authoring-service.jar"]

EXPOSE 7878 7879