FROM maven:3.9.6-eclipse-temurin-11 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -q
COPY src ./src
RUN mvn package -DskipTests -q

FROM eclipse-temurin:11-jre-alpine
WORKDIR /app
COPY --from=build /app/target/classes ./classes
ENTRYPOINT ["java", "-cp", "classes", "com.teste.subarray.adapter.in.cli.Main"]
