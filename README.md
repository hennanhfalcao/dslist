  # 📌 DSList - Gerenciamento de Jogos com Drag and Drop

## 📖 Sobre o Projeto

O **DSList** é uma API RESTful desenvolvida com **Java e Spring Boot**, que permite a gestão de listas de jogos. O sistema possibilita a organização dos jogos em listas personalizadas e conta com um recurso de **drag and drop**, permitindo a reordenação dos itens de forma intuitiva.

---

## 🛠 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4.1**
  - Spring Web
  - Spring Data JPA
- **PostgreSQL**
- **H2 Database** (para testes)
- **Docker e Docker Compose**
- **Maven**

---

## 🚀 Como Executar o Projeto

### 🔧 Configuração Inicial

1. Clone o repositório:
   ```bash
   git clone https://github.com/hennanhfalcao/dslist.git
   cd dslist
   ```

2. Configure o banco de dados no arquivo `application-dev.properties` (caso necessário):
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5434/dslist
   spring.datasource.username=postgres
   spring.datasource.password=1234567
   ```

### 🐳 Executando com Docker

1. Suba o container do PostgreSQL:
   ```bash
   docker-compose up -d
   ```

2. Para acessar o PgAdmin:
   - URL: `http://localhost:5050`
   - Usuário: `me@example.com`
   - Senha: `1234567`

3. Crie um servidor:
   - Nome: `Postgres-local-docker`
   - Host: `pg-docker`
   - Maintenance database: `mydatabase`
   - Port: `5432`
   - Usuário: `postgres`
   - Senha: `1234567`
   - 
4. Crie as relações e insira os dados no PgAdmin com o seguinte script:
  ```sql
    create table tb_belonging (position integer, game_id bigint not null, list_id bigint not null, primary key (game_id, list_id));
    create table tb_game (game_year integer, score float(53), id bigint generated by default as identity, genre varchar(255), img_url varchar(255), long_description TEXT, platforms varchar(255), short_description TEXT, title varchar(255), primary key (id));
    create table tb_game_list (id bigint generated by default as identity, name varchar(255), primary key (id));
    alter table if exists tb_belonging add constraint FKrchwdikeu66uky1hf75ym1kh foreign key (list_id) references tb_game_list;
    alter table if exists tb_belonging add constraint FK2slybclee7wdfxhfltbvqkgpg foreign key (game_id) references tb_game;
    INSERT INTO tb_game_list (name) VALUES ('Aventura e RPG');
    INSERT INTO tb_game_list (name) VALUES ('Jogos de plataforma');
    INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Mass Effect Trilogy', 4.8, 2012, 'Role-playing (RPG), Shooter', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
    INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Red Dead Redemption 2', 4.7, 2018, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/2.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
    INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('The Witcher 3: Wild Hunt', 4.7, 2014, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/3.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
    INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Sekiro: Shadows Die Twice', 3.8, 2019, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/4.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
    INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Ghost of Tsushima', 4.6, 2012, 'Role-playing (RPG), Adventure', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/5.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
    INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Super Mario World', 4.7, 1990, 'Platform', 'Super Ness, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/6.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
    INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Hollow Knight', 4.6, 2017, 'Platform', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/7.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
    INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Ori and the Blind Forest', 4, 2015, 'Platform', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/8.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
    INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Cuphead', 4.6, 2017, 'Platform', 'XBox, Playstation, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/9.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
    INSERT INTO tb_game (title, score, game_year, genre, platforms, img_url, short_description, long_description) VALUES ('Sonic CD', 4, 1993, 'Platform', 'Sega CD, PC', 'https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/10.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa.');
    INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 1, 0);
    INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 2, 1);
    INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 3, 2);
    INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 4, 3);
    INSERT INTO tb_belonging (list_id, game_id, position) VALUES (1, 5, 4);
    INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 6, 0);
    INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 7, 1);
    INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 8, 2);
    INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 9, 3);
    INSERT INTO tb_belonging (list_id, game_id, position) VALUES (2, 10, 4);
  ```
### ▶️ Rodando o Backend

1. Compile o projeto com Maven:
   ```bash
   mvn clean install
   ```

2. Inicie a API:
   ```bash
   mvn spring-boot:run
   ```

A API estará rodando em `http://localhost:8080`.

---

## 🔄 Endpoints da API

| Método | Rota                          | Descrição |
|---------|-------------------------------|-------------|
| GET     | `/games`                       | Retorna todos os jogos cadastrados |
| GET     | `/games/{id}`                   | Retorna os detalhes de um jogo pelo ID |
| GET     | `/lists`                        | Retorna todas as listas de jogos |
| GET     | `/lists/{listId}/games`         | Retorna todos os jogos de uma lista |
| POST    | `/lists/{listId}/replacement`   | Reordena os jogos dentro de uma lista |

### 📌 Exemplo de Requisição para Movimentar um Item na Lista
```json
{
  "sourceIndex": 2,
  "destinationIndex": 0
}
```

---

## 📄 Estrutura do Projeto

```
├── src
│   ├── main
│   │   ├── java/com/devsuperior/dslist
│   │   │   ├── config (Configuração de CORS)
│   │   │   ├── controllers (Controladores da API)
│   │   │   ├── dtos (Objetos de Transferência de Dados)
│   │   │   ├── entities (Entidades do Banco de Dados)
│   │   │   ├── projections (Consultas customizadas do banco)
│   │   │   ├── repositories (Interfaces de Acesso ao Banco)
│   │   │   ├── services (Regras de Negócio)
│   │   │   └── DslistApplication.java (Classe principal do Spring Boot)
│   ├── resources (Arquivos de configuração e scripts SQL)
│   ├── test/java/com/devsuperior/dslist (Testes automatizados)
├── docker-compose.yml (Configuração do PostgreSQL e PgAdmin)
├── pom.xml (Dependências Maven)
└── README.md (Documentação do projeto)
```

---
