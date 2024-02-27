FROM openjdk:21
ARG JAR_FILE=./build/libs/spring-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# docker build -t springboot .
# docker run -d -p 5000:8080 springboot