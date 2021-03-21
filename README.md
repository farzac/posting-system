
<br/>
<p align="center">
  <h3 align="center">Posting-upvote</h3>
</p>


# Passos para subir aplicação


## Contexto
O servidor backend feito em SpringBoot vai expor uma API que será consumida por uma aplicação Front-end ReactJS and Swagger, persistindo os dados em um banco de dados H2.

Pré-requisito



- [JDK >= 8](https://www.oracle.com/br/java/technologies/javase-downloads.html) – Versão Java disponivel.
- [Node](https://nodejs.org/pt-br/download/) – Versão Node disponivel.


## Passos para testes


### Aplicacao backend

#### Abrir novo terminal e fazer o checkout desse projeto (posting-system) e seguir o passo abaixo



```sh
git clone https://github.com/farzac/posting-system.git
cd posting-system/backend/
rm -rf target/
sudo chmod 777 mvnw
npm start
./mvnw spring-boot:run
```





### Aplicacao frontend


#### Abrir novo terminal e entrar no diretorio do checkout do projeto conforme segue abaixo

```sh
cd posting-system/frontend/
npm install
npm start
```





## Endereço web da aplicação

[http://localhost:9999](http://localhost:9999) para visualizar o Swagger.<br>

[http://localhost:3000](http://localhost:3000) para visualizar a aplicação web.<br>

[http://localhost:9999/h2-console](http://localhost:9999/h2-console) para visualizar o console do banco H2.<br>


