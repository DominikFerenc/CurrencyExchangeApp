FROM adoptopenjdk/openjdk11:alpine
ADD target/CurrencyExchangeApp-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar CurrencyExchangeApp-0.0.1-SNAPSHOT.jar