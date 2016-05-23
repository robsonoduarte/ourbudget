FROM java:jre-alpine
MAINTAINER robsonoduarte



ADD target/ourbudget-api-0.1.0-SNAPSHOT-jar-with-dependencies.jar /ourbudget-api-0.1.0-SNAPSHOT-jar-with-dependencies.jar

CMD ["java", "-jar", "ourbudget-api-0.1.0-SNAPSHOT-jar-with-dependencies.jar"]



#docker run  --name ourbudget-api -p 8080:8080  ourbudget-api