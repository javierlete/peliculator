# peliculator

Para poner en marcha instalar

`sudo snap install heroku`

Luego loguearse dentro de Heroku desde la línea de comandos

`heroku login`

Establecemos la aplicación para todos los comandos

`export HEROKU_APP=peliculator`

Después hacer un 

`mvn clean heroku:deploy-war && heroku open && heroku logs --tail`

Instalar PostgreSQL

`sudo apt install postgresql`

Crear usuario de TCP/IP (no el de sockets)

```
sudo su -
su - postgres
psql
CREATE USER admin WITH PASSWORD 'admin' CREATEDB;
\q
exit
exit
psql -h localhost -U admin -W postgres
admin
CREATE DATABASE peliculas_bdd;
\q
```

Migrar de MySQL a PostgreSQL

`sudo apt install pgloader`

`pgloader mysql://debian-sys-maint:o8lAkaNtX91xMUcV@localhost:3306/peliculas_bdd pgsql://admin:admin@localhost/peliculas_bdd`

Script de build para probar en local

`~/apache-tomcat-8.5.51/bin/shutdown.sh && rm -fr ~/apache-tomcat-8.5.51/webapps/peliculator* && mvn clean package && cp target/uf2218_peliculas-0.0.1-SNAPSHOT.war ~/apache-tomcat-8.5.51/webapps/peliculator.war && ~/apache-tomcat-8.5.51/bin/startup.sh`

Ejecutar un shell remoto

`heroku run /bin/bash`

(Salir con exit)
