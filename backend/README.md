# Backend for Coronakarma

# Konfiguration:

Datenbank-Settings in src/main/resources/application.properties müssen angepasst werden

SQL für Dummy-Daten ist in src/main/resources/import.sql

# Lokal laufen lasen:

./mvnw spring-boot:run

# docker image bauen (docker muss installiert sein, noch nicht getestet):

./mvnw com.google.cloud.tools:jib-maven-plugin:dockerBuild -Dimage=wirvsvirus/coronakarma-backend

# Testen:

z.B.: curl http://<ip>:8080/location/55469/persons/

# Swagger-API:

http://<ip>:8080/swagger-ui.html
