FROM openjdk:21
LABEL maintainer="ironhackers"
ADD target/PPGDiagnose.jar PPGDiagnose.jar
ENTRYPOINT ["java","-jar","PPGDiagnose.jar"]