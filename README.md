# implanner.service
JAX-RS services for implanner API

## How to run?
Clean and Package by running `mvn clean install` and then run jetty server by running `mvn jetty:run` (goal: jetty:run)

## How to test?
So far `FeatureMappingService` serves part file upload service at `http:\\localhost:8080\imp\part`
> web.xml url pattern `/imp/*` and path of `FeatureMappingService` is `part`
test with curl as below
```
curl -F file=@path\to\file http:\\localhost:8080\imp\part
```
