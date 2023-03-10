# Desafio Técnico Backend MaxMilhas

Esse é o back end desenvolvido para o desafio técnico da empresa MaxMilhas.

# Contextualização do Problema

Atualmente o time de análise antifraude do ecommerce realiza um controle de CPFs emuma planilha eletrônica. Nesta planilha são adicionados CPFs com risco de fraude. Com o aumento da nossa base de clientes têm ficado cada vez mais difícil manter o controle manual. Com isso o Product Owner do time levantou os principais requisitos funcionais para desenvolvimento de um sistema que controle os CPFs adicionado-os em uma lista restrita.

## Descrição da API

- GET - /cpf
  - Descrição: Retorna a lista de CPFs da lista restrita
  - Respostas: 
      - 200 OK - Content: [ { "cpf": "64852893055", createdAt: "2019-12-17T22:22:08.547Z"} ]
  
- GET - /cpf/{cpf}
  - Descrição: Verificar se um determinado CPF está na lista restrita
  - Respostas: 
      - 200 OK - Content: { "cpf": "64852893055", createdAt: "2019-12-17T22:22:08.547Z"}
      - 400 BAD REQUEST - Content: { "type": "InvalidCpfException", "message": "CPF is not valid."}
      - 404 NOT FOUND - Content: { "type": "NotFoundCpfException", "message": "CPF was not found"}
               
- POST - /cpf
  - Descrição: Adicionar CPF na lista restrita
  - Parâmetros: { "cpf": "64852893055" }
  - Respostas: 
      - 201 CREATED 
      - 400 BAD REQUEST - Content: { "type": "InvalidCpfException", "message": "CPF is not valid."}
      - 409 CONFLICT - Content: { "type": "ExistsCpfException", "message": "CPF already exists."}
               
- DELETE - /cpf/{cpf}
  - Descrição: Remover um CPF da lista restrita
  - Respostas: 
      - 204 NO CONTENT
      - 400 BAD REQUEST - Content: { "type": "InvalidCpfException", "message": "CPF is not valid."}
      - 404 NOT FOUND - Content: { "type": "NotFoundCpfException", "message": "CPF was not found"}

## Tecnologias

As seguintes ferramentas e frameworks foram usados na construção do projeto:<br>

  ![JAVA 17](https://img.shields.io/badge/JAVA-17-%23E34F26.svg?style=for-the-badge)
  ![SPRINGBOOT 3](https://img.shields.io/badge/SPRINGBOOT-3-%231572B6.svg?style=for-the-badge)
  ![MAVEN](https://img.shields.io/badge/MAVEN-%23323330.svg?style=for-the-badge)
  ![LOMBOK](https://img.shields.io/badge/LOMBOK-%2320232a.svg?style=for-the-badge)
  ![JUNIT](https://img.shields.io/badge/JUNIT-CA4245?style=for-the-badge)
  ![MOCKITO](https://img.shields.io/badge/MOCKITO-DB7093?style=for-the-badge)
  ![ASSERTJ](https://img.shields.io/badge/ASSERTJ-6DA55F?style=for-the-badge)
  ![MAPSCTRUCT](https://img.shields.io/badge/MAPSCTRUCT-%23404d59.svg?style=for-the-badge)
  ![OPENAPI](https://img.shields.io/badge/OPENAPI-%23316192.svg?style=for-the-badge)
  ![STELLA](https://img.shields.io/badge/STELLA-%23007ACC.svg?style=for-the-badge)
  ![MONGODB](https://img.shields.io/badge/MONGODB-3982CE?style=for-the-badge)
  ![MONGOEXPRESS](https://img.shields.io/badge/MONGOEXPRESS-%23C21325?style=for-the-badge)
  ![SLF4J](https://img.shields.io/badge/SLF4J-%23E5E5E5?style=for-the-badge)
  ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
  
## Por quê?

A API foi desenvolvida em Java por ser a linguagem da vaga aplicada, as versões 17 do Java e 3 do Spring Boot foram escolhidas por serem as mais recentes, enquanto o maven foi escolhido por ser a tecnologia mais popular para gerenciamento de pacotes do Java. 
As ferramentas de testes como JUnit, Mockito e AssertJ também foram escolhidas pela popularidade na comunidade, e possibilitam juntas uma gama muito grande de métodos para realizar as asserções nos testes e mocks para realizar testes unitários com qualidade.
As ferramentas auxiliares como Lombok, Mapstruct e SLF4J também são muito populares, Lombok e Mapstruct são ótimas para reduzir código desnecessários na aplicação fornecendo respectivamente anotações que geram códigos em tempo de execução e metódos que fazem mapeamento automático entre objetos. Já o SLF4J fornece um fachada de logging para várias implementações de log técnicos (INFO, ERROS, DEBUG, etc.)
A escolha do banco de dados para o MongoDB se deu pela não necessidade de manter relacionamento entre os dados, fornecendo assim grande desempenho, fleibilidade, escalabilidade, facilidade de desenvolvimento e baixa manutenção. A utilização do Mongo Express auxilia na visualização do banco de dados enquanto a OpenAPI do Swagger auxilia na documentação e visualização dos elementos da API.
Por ultimo, a Stella é uma biblioteca de terceiros simples e leve para validação de CPF e CNPJ.

## Como rodar

1. Clone o repositório

2. Acesse a pasta em que foi clonado

3. Instale o docker
```bash
 sudo apt-get install docker-ce docker-ce-cli containerd.io docker-compose-plugin

```

4. Dê permissão para rodar o Docker com seu usuário corrente:
```bash
 sudo usermod -aG docker $USER

```

5. Garanta que o docker esteja rodando
```bash
sudo service docker start
```

6. Rode os containers com
```bash
docker compose up --build -d
```

7. Para verificar os containers em execução
```bash
docker ps
```

8. Acesse http://localhost:8080/swagger-ui/index.html para ver a documentação da api com o Swagger

9. Acesse http://localhost:8081 para ver a interface gráfica do MongoDB
