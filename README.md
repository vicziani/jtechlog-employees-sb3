# Spring Boot 3 példa

Ez a program a JTechLog (<http://jtechlog.hu>) blog "Spring Boot 3 újdonságai" posztjához készült példaprogram.
Spring Boot alkalmazás.

Futtatásához adatbázis szükséges, mely Dockerrel a következőképp indítható:

```shell
docker run -d -e MARIADB_DATABASE=employees -e MARIADB_USER=employees -e MARIADB_PASSWORD=employees -e MARIADB_ALLOW_EMPTY_ROOT_PASSWORD=yes -p 3306:3306 --name employees-mariadb mariadb
```