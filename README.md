# Projeto de Microserviços de E-commerce

Este projeto é uma plataforma de E-commerce abrangente, construída usando Quarkus e arquitetura de microserviços. O principal objetivo deste projeto foi aprofundar meu entendimento sobre o Quarkus e suas capacidades em lidar com a comunicação entre microserviços, migrações de banco de dados com Flyway, e observabilidade usando Grafana e Prometheus.

## Stack utilizada

**Back-end:** Java, Quarkus, PostgreSQL + DBeaver, RESTEasy para APIs REST, Flyway para migração de banco de dados, Grafana e Prometheus para observabilidade e Docker para containerização, Swagger OpenAPI para documentação.

## Estrutura do Projeto
O projeto é dividido em vários microserviços, cada um responsável por uma parte específica da plataforma de E-commerce. Cada microserviço é uma aplicação Quarkus separada.

### Microserviços
    1. ms-produto: Gerencia o catálogo de produtos, incluindo operações CRUD.
    2. ms-carrinho: Gerencia as operações do carrinho de compras.
    3. ms-checkout: Responsável pelo processo de checkout e gerenciamento de pagamentos.
    4. ms-dashboard: Agrupa e exibe dados analíticos e métricas sobre o desempenho da loja.

## Configuração

- Certifique-se de ter o Java e o Maven instalados em seu sistema antes de prosseguir.

```bash
  git clone https://github.com/seuusuario/ecommerce-microservices.git
  cd ecommerce-microservices
```

- ### Configuração do Banco de Dados

1. **Instalação do Docker**: Se você ainda não tem o Docker instalado em seu sistema, siga as instruções de instalação fornecidas no site oficial do Docker para o seu sistema operacional.

2. **Instalação do PostgreSQL**: Após a instalação do Docker, você pode usar uma imagem Docker do PostgreSQL para configurar o banco de dados. Execute o seguinte comando para iniciar um contêiner PostgreSQL:

```cmd
  docker run --name some-postgres -e POSTGRES_PASSWORD=sua_senha -d postgres
```
Certifique-se de substituir sua_senha pela senha desejada para o usuário postgres. Após inicie o contêiner PostgreSQL.

3. **Configuração do Flyway:** O Flyway é uma ferramenta de migração de banco de dados que permite gerenciar e versionar alterações em seu banco de dados. Certifique-se de ter o Flyway configurado em cada microserviço. As migrações serão executadas automaticamente quando os microserviços forem iniciados.
    
5. **Sequência de Execução dos Microserviços:** Para garantir que as migrações sejam executadas corretamente, inicie os microserviços na seguinte ordem:
   - ms-produto, porta: 8081
   - ms-carrinho, porta: 8082
   - ms-checkout, porta: 8083
   - ms-dashboard, porta: 8084

   Execute cada microserviço usando o comando:
   ```cmd
    mvn clean install -DskipTests
    mvn quarkus:dev
    ```
Certifique-se de que o Docker está em execução e o contêiner do PostgreSQL está ativo antes de iniciar os microserviços. Além disso, certifique-se, também, de ajustar qualquer configuração específica nos arquivos de configuração do Quarkus (application.properties ou application.yml) de cada microserviço para apontar para o contêiner PostgreSQL e os respectivos bancos de dados.

## Documentação da APIs

A documentação completa da API pode ser encontrada no Swagger. Para acessar a documentação, siga as etapas abaixo:

1. Certifique-se de que o projeto esteja em execução.

2. Abra um navegador da web e vá para a seguinte URL:

   - [Swagger API Documentation - MsProdutos](http://localhost:8081/q/swagger-ui)
   - [Swagger API Documentation - MsCarrinho](http://localhost:8082/q/swagger-ui)
   - [Swagger API Documentation - MsCheckout](http://localhost:8083/q/swagger-ui)
   - [Swagger API Documentation - MsDashboard](http://localhost:8084/q/swagger-ui)

3. Isso abrirá a interface do Swagger, onde você pode explorar e testar os endpoints da API, apenas se tiver autenticado.

Divirta-se explorando a API!

## Como a API funciona
Para começar, siga os passos abaixo:

- Fluxograma de todos os microsserviços na aplicação:
![App Screenshot](https://github.com/ThallysCezar/Ecommerce-Quarkus/blob/main/assets/images/aplicacao-funcional.jpeg)


- Fluxograma de como a aplicação funciona, com os microsserviços:
![App Screenshot](https://github.com/ThallysCezar/Ecommerce-Quarkus/blob/main/assets/images/fluxo-com-ms.jpeg)


- Fluxograma da aplicação geral:
![App Screenshot](https://github.com/ThallysCezar/Ecommerce-Quarkus/blob/main/assets/images/fluxo-normal.jpeg)

Dito isso, como a aplicação funciona:
1. Microsserviço de produtos:
    - onde entrará na página principal, onde conterá todos os produtos que serão produtos livros e mangás, [Link](http://localhost:8081/products)
        ```http
            GET /products
        ```
    - Esta requisição retornará todos os produtos.

2. Microsserviço de carrinho:
    - Após escolher o produto, agora o usuário irá adicionar o produto ao carrinho,[Link](http://localhost:8082/carts/add):
        ```http
            POST carts/add
        ```
    - Este endpoint adicionará produtos no carrinho que estará ligado a um usuário.
        ```json
        {
          "usuarioId": 1,
          "productIds": [1, 2, 3],
          "quantity": 5
        }
        ```
      JSON para exemplificará como será usado.
3. Microsserviço de checkout:
    - Após adicionar ao carrinho, os produtos escolhidos, agora irá iniciar o checkout para validar as informações presentes no carrinho e iniciar com o "pagamento",[link](http://localhost:8083/checkout/start):
        ```http
            POST /checkout/start
        ```
    - Este endpoint iniciará o checkout com o id de um usuário válido, já que cada carrinho é ligado a um usuário.
        ```json
        {
          "userId": 1
        }
        ```
      JSON para exemplificará como será usado.
    - Agora iremos finalizar ou cancelar o checkout, isso irá validar todas as informações no carrinho, tanto o pagamento, quanto um usuário ou produto válidos, [link](http://localhost:8083/checkout/1/complete).
      ```http
        POST /checkout/1/complete
      ```
      Com o JSON:
      ```json
      {
        "total": 114.7,
        "formaPagamento": "debito"
      }
      ```
      Para o processo de cancelamento seria os mesmos passos.

Observação: Caso tenha dificuldades para acessar os endpoints fornecidos, consulte como deve ser usado cada endpoint na documentação da API.

## Monitoramento com Prometheus e Grafana

-  O Prometheus é um sistema de monitoramento e alerta de código aberto que coleta métricas de seus alvos em tempo real. Ele armazena todas as informações em uma base de dados de séries temporais, permitindo consultas flexíveis e alertas detalhados com uma linguagem de consulta poderosa.

- Por outro lado, o Grafana é uma plataforma de análise e monitoramento de métricas multi-fonte e multi-plataforma. Ele permite visualizar e compreender seus dados, seja através de gráficos simples ou painéis altamente detalhados e interativos.

## Contribuindo

Contribuições são sempre bem-vindas!

Se você encontrar problemas ou tiver sugestões de melhorias, sinta-se à vontade para abrir um problema ou enviar uma solicitação pull.
