FROM alpine:latest
RUN apk add --no-cache openjdk8
ARG JAR_FILE
COPY ${JAR_FILE} motd-app.jar
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/motd-app.jar"]
VOLUME /tmp
EXPOSE 8080