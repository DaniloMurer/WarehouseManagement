FROM openjdk:14

LABEL maintainer="danilo.murer@gmail.com"

EXPOSE 80

WORKDIR /app

COPY ./target/warehousemanagement-1.0.0.jar /app/warehousemanagement.jar

ENTRYPOINT ["java", "-jar", "warehousemanagement.jar"]


