FROM openjdk:11-jre-slim
ADD  calculator-1.0-SNAPSHOT.jar calculator.jar
ENTRYPOINT ["java","-jar","calculator.jar"]