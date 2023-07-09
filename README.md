# HikariCP

### Setup Docker MySQL
```shell
docker run --rm \
--name=example-db \
-e MYSQL_DATABASE=exampledb \
-e MYSQL_USER=yukbelajar \
-e MYSQL_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
-e MYSQL_ROOT_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
-e TZ=Asia/Jakarta \
-p 6603:3306 \
-v "$PWD/docker/server-db/conf.d":/etc/mysql/conf.d \
-v "$PWD/storage/docker/serverdb-data":/var/lib/mysql \
mysql:8
```
### Run Project :
`mvn clean install spring-boot:run`

Open Your Browser : http://localhost:8080/

![Add Employee](img/add.png "Add Employee")

![Success Add Employee](img/success.png "Success Add Employee")

![Edit Employee](img/edit.png "Edit Employee")

![Delete Employee](img/delete.png "Delete Employee")