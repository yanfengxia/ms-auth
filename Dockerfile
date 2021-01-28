FROM openjdk:11-slim
MAINTAINER xiayanfeng
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
#ADD elastic-apm-agent.jar agent.jar
ENTRYPOINT [ "java", "-jar", "/app.jar", "${JAVA_OPTS}" ]