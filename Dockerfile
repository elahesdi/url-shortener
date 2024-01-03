FROM openjdk:17-jdk-slim
ADD target/springboot-redis-0.0.1-SNAPSHOT.jar spring-boot-redis.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "spring-boot-redis.jar"]