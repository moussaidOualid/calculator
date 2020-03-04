FROM openjdk:11-jre-slim
COPY --from=build /home/me/IdeaProjects/calculator/target/calculator-1.0-SNAPSHOT.jar /usr/local/lib/calculator.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/calculator.jar"]