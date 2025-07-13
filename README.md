# Microserviço de Cadastro de Usuário - Java Spring

Este repositório contém a segunda parte de um projeto de microserviços desenvolvido com **Java Spring**, com foco, na prática de comunicação assíncrona entre serviços e uso de boas práticas de observabilidade.

## Descrição

A API redireciona mensagens recebidas por meio de uma fila **RabbitMQ** para o e-mail especificado.


## Tecnologias  Utilizadas

- **Java + Spring Boot** – Framework principal da aplicação
- **RabbitMQ** com **CloudAMQP** – Comunicação assíncrona entre serviços.
- **PostgreSQL** – Persistência dos dados dos usuários.
- **Lombok** – Uso da anotação `@Slf4j` para geração de logs.
- **Spring Boot Actuator** – Monitoramento da aplicação.


## Requisitos

- Java 21+
- Maven
- PostgreSQL


## Executando o Projeto

1. Clone o repositório 1:

```bash
git  https://github.com/bispobr/Spring-java-microservice-email.git
```
2. Clone o repositório 2:

```bash
git https://github.com/bispobr/Spring-java-microservice-usuario.git
```

3. Altere o arquivo de configuração **application.properties** com as credenciais de login do PostgreSQL do seu ambiente, juntamente com suas credenciais de email.

## Como usar

1. Inicie a aplicação 
2. API está acessivel atraves do endereço http://localhost:8082
3. O endpoint de saúde e métricas do Actuator está acessível através do Link http://localhost:8082/actuator
