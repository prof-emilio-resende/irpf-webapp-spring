FROM openjdk:11-jre-slim

COPY target/irpfCalculator-0.0.1-SNAPSHOT.jar ./app/irpfCalculator.jar

WORKDIR ./app
RUN ls -l

ENTRYPOINT ["java","-jar","irpfCalculator.jar"]