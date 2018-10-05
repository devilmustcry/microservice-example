FROM maven:3.5.4-jdk-8-alpine as compile
COPY . /home/source/java
WORKDIR /home/source/java
# USER root
# RUN chown -R maven /home/source/java
# USER maven
RUN mvn package

FROM openjdk:8-jre-alpine
WORKDIR /home/application/java
COPY --from=compile "/home/source/java/target/Configuration-Service-0.0.1-SNAPSHOT.jar" .
EXPOSE 8585
ENTRYPOINT [ "java", "-jar", "/home/application/java/Configuration-Service-0.0.1-SNAPSHOT.jar" ]