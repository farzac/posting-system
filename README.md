
<br/>
<p align="center">
  <h2 align="center">Posting-upvote</h2>
</p>


## Passos para subir aplicação


## Contexto
O servidor backend feito em SpringBoot vai expor uma API que será consumida por uma aplicação Front-end ReactJS and Swagger, persistindo os dados em um banco de dados H2.

Pré-requisito



- [JDK >= 8](https://www.oracle.com/br/java/technologies/javase-downloads.html) – Versão Java disponivel.
- [Node](https://nodejs.org/pt-br/download/) – Versão Node disponivel.
- [Azure](https://azure.microsoft.com/pt-br/features/azure-portal/) – Aplicativo web do Azure.


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

[http://localhost:9999/swagger-ui.html#/](http://localhost:9999/swagger-ui.html#/) para visualizar o Swagger.<br>

[http://localhost:3000](http://localhost:3000) para visualizar a aplicação web.<br>

[http://localhost:9999/h2-console](http://localhost:9999/h2-console) para visualizar o console do banco H2.<br>




### Aplicacao Azure


#### Abrir novo terminal e entrar no diretorio do checkout do projeto conforme segue abaixo

```sh
# Aplicação backend
cd posting-system/backend/
mvn azure-webapp:config
# Após o comando config, o arquivo pom.xml deve ser conforme segue abaixo:
<plugin> 
	<groupId>com.microsoft.azure</groupId>  
	<artifactId>azure-webapp-maven-plugin</artifactId>  
	<version>1.7.0</version>  
	<configuration>
	  <schemaVersion>V2</schemaVersion>
	  <resourceGroup>first-azure-application</resourceGroup>
	  <appName>posting-ms</appName>
	  <pricingTier>B1</pricingTier>
	  <region>westeurope</region>
	  <appSettings>
	  	<property>
	  		<name>JAVA_OPTS</name> 
	  		<value>-Dserver.port=80</value>
	  	</property>
	  </appSettings>
	  <runtime>
	    <os>linux</os>
	    <javaVersion>jre8</javaVersion>
	    <webContainer>jre8</webContainer>
	  </runtime>
	  <deployment>
	    <resources>
	      <resource>
		<directory>${project.basedir}/target</directory>
		<includes>
		  <include>*.jar</include>
		</includes>
	      </resource>
	    </resources>
	  </deployment>
	</configuration>
</plugin> 

mvn azure-webapp:deploy
```


#### Abrir novo terminal e entrar no diretorio do checkout do projeto conforme segue abaixo

```sh
# Aplicação frontend
cd posting-system/frontend/
az webapp up --name frontend-posting-ms --plan ServicePlan8b0e6925-f9b6-4c7b --resource-group first-azure-application --location westeurope
```


## Endereço web da aplicação na Azure

[http://posting-ms.azurewebsites.net/swagger-ui.html#/](http://posting-ms.azurewebsites.net/swagger-ui.html#/) para visualizar o Swagger na Azure.<br>

[https://frontend-posting-ms.azurewebsites.net/#/](https://frontend-posting-ms.azurewebsites.net/#/) para visualizar a aplicação web.<br>



