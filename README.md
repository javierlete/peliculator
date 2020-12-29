# peliculator

Para poner en marcha instalar

`sudo snap install heroku`

Luego loguearse dentro de Heroku desde la línea de comandos

`heroku login`

Después hacer un 

`mvn clean heroku:deploy-war`

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
