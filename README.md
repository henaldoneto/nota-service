# Nota Service

### Instruções

O projeto foi desenvolvido utilizando:
Java 11, Spring Boot, Postgres...

Antes de iniciar o projeto rode o comando abaixo na raiz do projeto para executar o docker-compose que 
irá criar o container do Postgres;

`docker-compose -f docker-compose.yml up -d` 

 Ao rodar o projeto Spring Boot, NotaServiceApplication. 
 O liquibase criará as tabelas utilizadas no banco postgres. 
 
 Para acessar a documentaćão via Swagger das API: 
http://localhost:8025/swagger-ui.html

Apis

Receive/Import NFEs from Arquivei Sandbox Nfes Api
```
[GET]/v1/nfe/receive
```
http://localhost:8025/v1/nfe/receive

Recover Nota by Access Key
```
[GET]/v1/nota/{accessKey}
```
http://localhost:8025/v1/nota/35171130290824000104550000000158651247375232


### Web
[Swagger UI](http://localhost:8025/swagger-ui.html) 