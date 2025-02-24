# 🚀 Spring Cloud Gateway - Canary Release Demo

This repository demonstrates how to implement a **Canary Release** strategy using **Spring Cloud Gateway** to distribute traffic between two versions of an API: **Stable** and **Canary**.

## 📌 Overview

The project consists of **three services**:

1. **Gateway** (Spring Cloud Gateway) - Acts as the entry point, distributing requests between the APIs according to the Canary strategy.
2. **Stable API** - The stable version of the API.
3. **Canary API** - The experimental version with new features.

## 🏗 Technologies Used

- **Spring Boot 3**
- **Spring Cloud Gateway**
- **Spring Web**

## ⚙️ Gateway Configuration

The **Spring Cloud Gateway** distributes traffic as follows:

- **90% of requests** are directed to the **Stable API**.
- **10% of requests** are directed to the **Canary API**.

### 🔧 Configuration in `application.yaml`:

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: stable-service
          uri: http://localhost:8081
          predicates:
            - Path=/api/**
            - Weight=group, 90
          filters:
            - RewritePath=/api/(?<segment>.*), /stable/${segment}

        - id: canary-service
          uri: http://localhost:8082
          predicates:
            - Path=/api/**
            - Weight=group, 10
          filters:
            - RewritePath=/api/(?<segment>.*), /canary/${segment}
```

## 🚀 How to Run

### 1️⃣ Clone the Repository

```sh
git clone https://github.com/your-username/your-repository.git
cd your-repository
```

### 2️⃣ Build and Run the Services

Open **three terminals** and execute the following commands:

#### 🏠 **Gateway**

```sh
cd gateway
mvn spring-boot:run
```

The application will be available at: `http://localhost:8080`

#### ✅ **Stable API**

```sh
cd stable-api
mvn spring-boot:run
```

Running at: `http://localhost:8081`

#### 🆕 **Canary API**

```sh
cd canary-api
mvn spring-boot:run
```

Running at: `http://localhost:8082`

## 🔍 Testing the Canary Release

Make requests to the Gateway:

```sh
curl -X GET http://localhost:8080/api
```

- **90% of requests** will be forwarded to `http://localhost:8081/stable/`.
- **10% of requests** will be forwarded to `http://localhost:9092/canary/`.

## 🎯 Conclusion

This project demonstrates how to use **Spring Cloud Gateway** to implement a **Canary Release**, allowing a small percentage of traffic to utilize a new API version before a full release.

---

# 🚀 Spring Cloud Gateway - Canary Release Demo

Este repositório demonstra como implementar a estratégia **Canary Release** utilizando **Spring Cloud Gateway** para distribuir tráfego entre duas versões de uma API: **Stable** e **Canary**.

## 📌 Visão Geral

O projeto é composto por **três serviços**:

1. **Gateway** (Spring Cloud Gateway) - Atua como o ponto de entrada, distribuindo as requisições entre as APIs conforme a estratégia Canary.
2. **Stable API** - Versão estável da API.
3. **Canary API** - Versão experimental com novas funcionalidades.

## 🏗 Tecnologias Utilizadas

- **Spring Boot 3**
- **Spring Cloud Gateway**
- **Spring Web**

## ⚙️ Configuração do Gateway

O **Spring Cloud Gateway** distribui o tráfego da seguinte forma:

- **90% das requisições** são direcionadas para a **Stable API**.
- **10% das requisições** são direcionadas para a **Canary API**.

### 🔧 Configuração no `application.yaml`:

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: stable-service
          uri: http://localhost:8081
          predicates:
            - Path=/api/**
            - Weight=group, 90
          filters:
            - RewritePath=/api/(?<segment>.*), /stable/${segment}

        - id: canary-service
          uri: http://localhost:8082
          predicates:
            - Path=/api/**
            - Weight=group, 10
          filters:
            - RewritePath=/api/(?<segment>.*), /canary/${segment}
```

## 🚀 Como Executar

### 1️⃣ Clonar o Repositório

```sh
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

### 2️⃣ Compilar e Executar os Serviços

Abra **três terminais** e execute os comandos:

#### 🏠 **Gateway**

```sh
cd gateway
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

#### ✅ **Stable API**

```sh
cd stable-api
mvn spring-boot:run
```

Rodando em: `http://localhost:8081/`

#### 🆕 **Canary API**

```sh
cd canary-api
mvn spring-boot:run
```

Rodando em: `http://localhost:8082/`

## 🔍 Testando o Canary Release

Faça requisições ao Gateway:

```sh
curl -X GET http://localhost:8080/api/
```

- **90% das requisições** serão encaminhadas para `http://localhost:8081/stable/`.
- **10% das requisições** serão encaminhadas para `http://localhost:9092/canary/`.

## 🎯 Conclusão

Este projeto demonstra como usar o **Spring Cloud Gateway** para implementar um **Canary Release**, permitindo que uma pequena parte do tráfego utilize uma nova versão da API antes de um lançamento completo.
