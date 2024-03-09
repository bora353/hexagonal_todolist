#FROM openjdk:21
#ARG JAR_FILE=./build/libs/spring-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

# docker build -t springboot .
# docker run -d -p 5000:8080 springboot


# build 파일 사용하기
FROM openjdk:21 AS builder
WORKDIR /backend
COPY gradlew .
COPY gradle gradle
COPY build.gradle
COPY settings.gradle
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

FROM openjdk:21
COPY --from=builder /backend/build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
VOLUME /tmp
