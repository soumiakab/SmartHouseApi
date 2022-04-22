FROM openjdk:11
EXPOSE 8080
ADD target/smartHouse.jar smartHouse.jar
ENTRYPOINT ["java","-jar","/smartHouse.jar"]