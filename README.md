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
- PostgreSQL
- RabbitMQ ou CloudAMQP
- Servidor SMTP

## Configuração

As configurações de banco de dados, RabbitMQ e SMTP podem ser fornecidas por variáveis de ambiente.

| Variável | Descrição | Exemplo / padrão |
|---|---|---|
| `DB_URL` | URL de conexão com o PostgreSQL | `jdbc:postgresql://localhost:5432/microservice-email` |
| `DB_USERNAME` | Usuário do PostgreSQL | `postgres` |
| `DB_PASSWORD` | Senha do PostgreSQL | `admin` |
| `JPA_DDL_AUTO` | Estratégia de atualização do schema | `update` |
| `RABBITMQ_ADDRESSES` | Endereço do RabbitMQ ou CloudAMQP | `amqps://...` |
| `RABBITMQ_EMAIL_QUEUE` | Nome da fila de e-mails | `...` |
| `MAIL_HOST` | Servidor SMTP | `smtp.gmail.com` |
| `MAIL_PORT` | Porta do servidor SMTP | `587` |
| `MAIL_USERNAME` | Usuário utilizado no SMTP | definido pelo ambiente |
| `MAIL_PASSWORD` | Senha utilizada no SMTP | definida pelo ambiente |

A configuração SMTP utiliza autenticação e STARTTLS.

## Executando

Clone o repositório:

```bash
git clone https://github.com/bispobr/Spring-java-microservice-email.git
cd Spring-java-microservice-email
```

Compile e execute:

```bash
./mvnw clean package
./mvnw spring-boot:run
```

A aplicação utiliza a porta `8082`.

## Actuator

O Spring Boot Actuator disponibiliza informações de saúde e métricas da aplicação.

Endpoint de saúde:

```text
http://localhost:8082/actuator/health
```

Endpoint de métricas:

```text
http://localhost:8082/actuator/metrics
```

## Docker

O projeto possui configuração relacionada a Docker documentada no repositório. A execução deve ser feita de acordo com os arquivos de infraestrutura presentes na versão atual do projeto.

## Testes

Execute:

```bash
./mvnw test
```

## Serviços relacionados

- [User Service](https://github.com/bispobr/Spring-java-microservice-usuario)
- [Order Service](https://github.com/bispobr/Spring-java-microservice-pedido)
- [Processing Service](https://github.com/bispobr/Spring-java-microservice-processamento)

## Status

Projeto de estudo desenvolvido para praticar mensageria assíncrona, integração com SMTP e processamento de mensagens utilizando Java e Spring Boot.
