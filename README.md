# ACEM DB

> If your using DotEnvImpl config as follows

1. Create a .env file inside the resource folder
2. Add these contents

```
IP_ADDRESS=localhost
PORT=3306
NAME=COLLEGE
USERNAME=root
PASSWORD=<YOUR_PASSWORD>
```

> If your using FileImpl config as follows

1. Create a db_credentials file inside the resource folder
2. Add these contents

```
IP_ADDRESS=localhost
PORT=3306
NAME=COLLEGE
USERNAME=root
PASSWORD=<YOUR_PASSWORD>
```

> Package and deploy to payara micro server

```
mvn clean package && java -jar payara-micro.jar --deploy target/*.war --nocluster

```

> Postman collection link: https://www.getpostman.com/collections/d6ac7c9e1ceae06c3921