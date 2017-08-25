FROM java:8-jre
MAINTAINER Dragan Ljubojevic <dragan.ljubojevic@gmail.com>

ADD ./target/survey-gateway.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/survey-gateway.jar"]

EXPOSE 4000