FROM java:8-jre
MAINTAINER Dragan Ljubojevic <dragan.ljubojevic@gmail.com>

ADD ./target/survey-registry.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/survey-registry.jar"]

EXPOSE 8761