FROM khipu/openjdk17-alpine

WORKDIR /app

COPY target/fibonacci-0.0.1-SNAPSHOT.jar app.jar

EXPOSE $PORT

CMD ["java", "-jar", "-Dserver.port=$PORT", "app.jar"]


