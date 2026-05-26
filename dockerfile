FROM eclipse-temurin:22-jdk AS buildstage 

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
COPY src /app/src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:22-jdk

COPY --from=buildstage /app/target/CloudNative_s1-1.0.0.jar /app/app.jar

COPY src/main/resources/wallet /wallet
RUN chmod -R 755 /wallet && ls -la /wallet

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]
