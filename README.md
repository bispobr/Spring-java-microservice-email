# Email Service

Microsserviço responsável pelo processamento e envio de e-mails a partir de mensagens recebidas através do RabbitMQ.

O serviço faz parte de um conjunto de microsserviços desenvolvido com Java e Spring Boot.

## Arquitetura

Fluxo simplificado:

```text
User Service
      │
      ▼
  RabbitMQ
      │
      ▼
 Email Service
      │
      ▼
Servidor SMTP
```

O serviço consome mensagens recebidas através do RabbitMQ e utiliza as informações da mensagem para realizar o envio do e-mail.

## Responsabilidades

- Consumir mensagens do RabbitMQ
- Processar informações de e-mail
- Realizar o envio das mensagens
- Disponibilizar informações de saúde e métricas da aplicação

## Tecnologias

- Java 21
- Spring Boot
- Spring AMQP
- RabbitMQ / CloudAMQP
- Spring Mail
- PostgreSQL
- Spring Boot Actuator
- Docker
- JUnit 5
- Mockito

## Requisitos

- Java 21
- Maven
- RabbitMQ ou CloudAMQP
- Servidor SMTP

## Configuração

As configurações de RabbitMQ e SMTP devem ser fornecidas pelo ambiente.

Exemplo:

```properties
RABBITMQ_ADDRESSES=amqps://...
RABBITMQ_EMAIL_QUEUE=...
MAIL_HOST=smtp.gmail.com
MAIL_PORT=587
MAIL_USERNAME=...
MAIL_PASSWORD=...
```

Não versione credenciais reais no repositório.

## Executando

Clone o repositório:

```bash
git clone https://github.com/bispobr/Spring-java-microservice-email.git
cd Spring-java-microservice-email
```

Execute:

```bash
./mvnw spring-boot:run
```

A aplicação utiliza a porta `8082`.

## Actuator

O Spring Boot Actuator disponibiliza informações de saúde e métricas da aplicação.

Endpoint:

```text
http://localhost:8082/actuator
```

## Docker

O projeto possui configuração relacionada a Docker documentada no repositório. A execução deve ser feita de acordo com os arquivos de infraestrutura presentes na versão atual do projeto.

## Testes

```bash
./mvnw test
```

## Serviços relacionados

- [User Service](https://github.com/bispobr/Spring-java-microservice-usuario)
- [Order Service](https://github.com/bispobr/Spring-java-microservice-pedido)
- [Processing Service](https://github.com/bispobr/Spring-java-microservice-processamento)

## Status

Projeto de estudo desenvolvido para praticar mensageria assíncrona, integração com SMTP e processamento de mensagens utilizando Java e Spring Boot.
