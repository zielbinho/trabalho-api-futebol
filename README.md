# projeto-api-futebol

Uma API REST para gerenciar jogadores de futebol e seus respectivos pagamentos.

# Desenvolvido por:

   * Alan Felipe Dias Wisniewski - RA: 22000126
   * Gabriel Henrique Pereira Guimarães - RA: 22001726
   * Rafael Henrique Mauda Scos - RA: 22014026

## Descrição

Este projeto consiste em uma API desenvolvida em Java com Spring Boot para realizar operações CRUD (Criar, Ler, Atualizar, Deletar) relacionadas a jogadores de futebol e registrar pagamentos associados a eles. É uma aplicação de exemplo para demonstrar a construção de APIs RESTful.

## Funcionalidades Principais

* Gerenciamento de Jogadores:
    * Cadastrar novos jogadores
    * Listar todos os jogadores cadastrados
    * Buscar um jogador específico por ID
    * Atualizar dados de um jogador
    * Remover um jogador
* Gerenciamento de Pagamentos:
    * Registrar um novo pagamento para um jogador
    * Listar todos os pagamentos
    * Buscar pagamentos de um jogador específico
    * Buscar um pagamento específico por ID
    * Atualizar dados de um pagamento
    * Remover um pagamento

## Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3.5.0** (incluindo Spring Web, Spring Data JPA)
* **Maven** (para gerenciamento de dependências e build do projeto)
* **PG Admin com PostgreSQL** (banco de dados e linguagem SQL)
* **Postman** (Para testar os Endpoints da API)

## Endpoints da API (Exemplos)

A API segue os padrões RESTful. Os principais endpoints são:

### Jogadores (`/api/jogadores`)

* `GET /api/jogadores`: Lista todos os jogadores.
* `GET /api/jogadores/{id}`: Busca um jogador pelo ID.

![Post Exemplo](/Imagens/GET_generico.png)
  
* `POST /api/jogadores`: Cria um novo jogador.
    * Corpo da requisição (exemplo):
        ```json
        {
          "nome": "Nome do Jogador",
          "email": "email@exemplo.com",
          "dataNasc": "2000-01-15",
        }
        ```
        
   ![Post Exemplo](/Imagens/POST_header_jogador.png)
   ![Post Exemplo](/Imagens/POST_body_jogador.png)
  
* `PUT /api/jogadores/{id}`: Atualiza um jogador existente.
* `DELETE /api/jogadores/{id}`: Remove um jogador.

### Pagamentos (`/api/pagamentos`)

* `GET /api/pagamentos`: Lista todos os pagamentos.
* `GET /api/pagamentos/{id}`: Busca um pagamento pelo ID.
* `GET /api/pagamentos/jogador/{jogadorId}`: Lista todos os pagamentos de um jogador específico.
  
![Post Exemplo](/Imagens/GET_generico.png)

* `POST /api/pagamentos/jogador/{jogadorId}`: Cria um novo pagamento para um jogador.
    * Corpo da requisição (exemplo):
        ```json
        {
          "ano": 1,
          "mes": "1",
          "valor": 10.00,
        }
        ```
        
   ![Post Exemplo](/Imagens/POST_header_pagamento.png)
   ![Post Exemplo](/Imagens/POST_body_pagamento.png)
  
* `PUT /api/pagamentos/{id}`: Atualiza um pagamento existente.
* `DELETE /api/pagamentos/{id}`: Remove um pagamento.

## Estrutura do Projeto

O projeto segue uma estrutura padrão para aplicações Spring Boot:

* `src/main/java/com/uepg/comp/eng/futebol_pagamentos`: Raiz do código fonte.
    * `FutebolPagamentosApplication.java`: Classe principal da aplicação Spring Boot.
    * `controller`: Contém os RestControllers que lidam com as requisições HTTP.
    * `dto`: Data Transfer Objects, usados para transferir dados entre camadas (ex: requisições e respostas da API).
    * `model`: Classes de entidade JPA que representam as tabelas do banco de dados.
    * `repository`: Interfaces Spring Data JPA para interação com o banco de dados.
    * `service`: Contém a lógica de negócios da aplicação.
* `src/main/resources`: Arquivos de configuração e recursos.
    * `application.properties`: Configurações da aplicação Spring Boot (ex: banco de dados, porta do servidor).
* `pom.xml`: Arquivo de configuração do Maven, define as dependências e o processo de build.
