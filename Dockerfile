FROM eclipse-temurin:17.0.9_9-jdk as builder

WORKDIR /
COPY . .
RUN ./mvnw install -DskipTests

FROM gcr.io/distroless/java17-debian12:latest
WORKDIR /app
COPY --from=builder /target/sample-java-messaging-spanner-1.0-SNAPSHOT.jar ./sample-java-messaging-spanner-1.0-SNAPSHOT.jar
COPY --from=builder /src/main/resources/lib/opentelemetry-javaagent.jar ./opentelemetry-javaagent.jar
EXPOSE 8080
ENTRYPOINT ["java","-javaagent:opentelemetry-javaagent.jar","-jar", "sample-java-messaging-spanner-1.0-SNAPSHOT.jar"]