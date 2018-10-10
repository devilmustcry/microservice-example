FROM maven:3.5.4-jdk-8-alpine as compile
COPY . /home/source/java
WORKDIR /home/source/java
RUN mvn package

FROM openjdk:8-jre-alpine
WORKDIR /home/application/java
COPY --from=compile "/home/source/java/target/zuul-service-0.0.1-SNAPSHOT.jar" .
COPY zuul-service.sh zuul-service.sh
RUN chmod 755 zuul-service.sh
EXPOSE 9999
# ENTRYPOINT [ "java", "-jar", "/home/application/java/zuul-service-0.0.1-SNAPSHOT.jar" ]