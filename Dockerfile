FROM openjdk:11-jre-slim
ADD  /home/me/IdeaProjects/calculator/target/calculator-1.0-SNAPSHOT.jar calculator.jar
ENTRYPOINT ["java","-jar","calculator.jar"]