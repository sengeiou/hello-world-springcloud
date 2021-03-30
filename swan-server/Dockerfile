FROM openjdk:8-alpine

MAINTAINER 1719341471@qq.com

WORKDIR /usr/local/src

CMD ["java","-jar","app.jar"]

EXPOSE 40000

ENV APP_SERVER swan-server
ENV APP_PORT 40000
ENV APP_VERSION 1.0.0

COPY /usr/local/src/swan-server-0.0.1-SNAPSHOT.jar app.jar

