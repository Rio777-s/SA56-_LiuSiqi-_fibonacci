FROM khipu/openjdk17-alpine

WORKDIR /app

COPY target/fibonacci-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8080

# 运行 Spring Boot 应用
CMD ["java", "-jar", "app.jar"]


