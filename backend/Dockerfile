FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENV JAVA_OPTS="-Dspring.datasource.url=${POSTGRES_URL} -Dspring.datasource.username=${POSTGRES_USER} -Dspring.datasource.password=${POSTGRES_PASSWORD}"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app.jar"]
