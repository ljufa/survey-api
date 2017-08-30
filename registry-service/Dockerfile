FROM java:8-jre
MAINTAINER Dragan Ljubojevic <dragan.ljubojevic@gmail.com>
ADD ./target/registry-service.jar /app/
ARG java_opts
ENV JAVA_OPTS $java_opts
CMD ["sh", "-c", "java -jar $JAVA_OPTS /app/registry-service.jar"]

EXPOSE 8761