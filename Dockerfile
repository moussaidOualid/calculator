FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/me/IdeaProjects/calculator/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/me/IdeaProjects/calculator/target/calculator-1.0-SNAPSHOT.jar /usr/local/lib/calculator.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/calculator.jar"]