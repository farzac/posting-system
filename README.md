#                                                          Posting-upvote
                                                          

## Passos para subir aplicação
               
                                   
## Contexto
O servidor backend feito em SpringBoot vai expor uma API que será consumida por uma aplicação Front-end ReactJS and Swagger, persistindo os dados em um banco de dados H2.


## Pré-requisito

jdk >= 8 

node


## Passos para testes

### Aplicacao backend

#### Abrir novo terminal e fazer o checkout desse projeto (posting-system) e seguir o passo abaixo

git clone https://github.com/farzac/posting-system.git


cd posting-system/backend/  &&
rm -rf target/  &&
sudo chmod 777 mvnw  &&
./mvnw spring-boot:run






### Aplicacao frontend


#### Abrir novo terminal e entrar no diretorio do checkout do projeto conforme segue abaixo

cd posting-system/frontend/   &&   
npm install  &&
npm start






## Endereço web da aplicação

http://localhost:9999/swagger-ui.html


http://localhost:3000/#/


http://localhost:9999/h2-console

