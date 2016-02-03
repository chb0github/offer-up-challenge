FROM java:8
EXPOSE 8080

RUN mkdir -p /usr/src/app/

COPY ./target/offer-up-1.0.0-SNAPSHOT.jar /usr/src/app/offer-up-1.0.0-SNAPSHOT.jar
WORKDIR /usr/src/app
CMD [ "java", "-jar", "offer-up-1.0.0-SNAPSHOT.jar" ]