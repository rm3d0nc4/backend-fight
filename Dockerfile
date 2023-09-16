FROM openjdk:17

WORKDIR /app

COPY /build/libs/backend-fight-0.0.1-SNAPSHOT.jar /app/backend-fight.jar

EXPOSE 8080

CMD java -jar backend-fight.jar