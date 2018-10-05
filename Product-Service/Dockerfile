FROM maven:3.5.4-jdk-8-alpine as compile
COPY . /home/source/java
WORKDIR /home/source/java
RUN mvn package 

FROM openjdk:8-jre-alpine
WORKDIR /home/application/java
COPY --from=compile "/home/source/java/target/Product-Service-0.0.1-SNAPSHOT.jar" .
EXPOSE 8000
ENTRYPOINT [ "java", "-jar", "/home/application/java/Product-Service-0.0.1-SNAPSHOT.jar" ]