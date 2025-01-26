
# CRUD com Spring Boot e Docker

Este repositório contém uma aplicação CRUD utilizando **Spring Boot** como backend e **PostgreSQL** como banco de dados, ambos configurados e executados em contêineres Docker. O objetivo é criar, ler, atualizar e deletar dados, além de aprender a configurar e executar aplicações de forma eficiente com Docker.

## Estrutura do Projeto

- **API (Spring Boot)**: Backend da aplicação.
- **PostgreSQL**: Banco de dados relacional para persistência.
- **Docker**: Contêineres para API e banco de dados.

## Como Executar

1. **Clonar o repositório:**  
   ``git clone git@github.com:MiqueiasBento/spring-boot-with-docker.git``
  
2.  **Subir os contêineres com Docker Compose:** Certifique-se de ter o Docker e o Docker Compose instalados no sistema.  
    `docker-compose up` 
  
3.  **Acessar a API:** A aplicação estará disponível em:  
    `localhost:8080/swagger-ui/index.html`

5.  **Banco de Dados:** O PostgreSQL será inicializado e estará acessível na porta `5433`.  
    Credenciais padrão:
    -   **Usuário**: `postgres`
    -   **Senha**: `123`
    -   **Banco de Dados**: `meubanco`
  
## Rotas da API

-   **GET** `/atividades`: Lista todas as atividades.
-   **GET** `/atividades/{id}`:Retorna uma atividade a partir do id dado.
-   **POST** `/atividades`: Cria uma nova atividade.
-   **PUT** `/atividades/{id}`: Atualiza uma atividade existente.
-   **DELETE** `/atividades/{id}`: Deleta uma atividade.

## Observações

-   O volume de dados do banco de dados é persistente por meio de volumes Docker configurados no arquivo `docker-compose.yml`.
-   Para reconstruir os contêineres ou limpar dados, utilize:  
    `docker-compose down --volumes` 
    

## Tecnologias Utilizadas

-   **Java** (17)
-   **Spring Boot** (3.4.1)
-   **PostgreSQL** (15)
-   **Docker** e **Docker Compose**

## Autor
**Miqueias Bento**  
  
*Desenvolvido para fins de aprendizado em DevOps e backend com Spwing Boot.*
