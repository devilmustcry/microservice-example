FROM maven:3.5.4-jdk-8-alpine as compile
COPY . /home/source/java
WORKDIR /home/source/java
RUN mvn package

FROM openjdk:8-jre-alpine
WORKDIR /home/application/java
COPY --from=compile "/home/source/java/target/pricing-service-0.0.1-SNAPSHOT.jar" .
COPY pricing-service.sh .
RUN chmod 755 pricing-service.sh
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/home/application/java/pricing-service-0.0.1-SNAPSHOT.jar" ]
# ENTRYPOINT [ "java", "-Dspring.profiles.active=dev", "-jar", "/home/application/java/pricing-service-0.0.1-SNAPSHOT.jar" ]
