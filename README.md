# 🎮 Game API

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?style=for-the-badge&logo=springboot)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-Hibernate-blue?style=for-the-badge&logo=hibernate)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

Uma API RESTful desenvolvida em Java com Spring Boot para o gerenciamento de um catálogo de jogos e suas informações. O projeto disponibiliza endpoints para operações completas de CRUD (Create, Read, Update, Delete), permitindo o cadastro, consulta, atualização e remoção de registros.

---

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA** (Persistência de dados)
- **Spring Web** (Construção de endpoints RESTful)
- **H2 Database / PostgreSQL / MySQL** (Banco de dados)
- **Maven** (Gerenciamento de dependências e build)
- **Postman / Insomnia** (Testes de API)

---

## 🛠️ Funcionalidades da API

- **Listar Jogos:** Retorna todos os jogos cadastrados no sistema.
- **Buscar por ID:** Retorna os detalhes de um jogo específico pelo seu identificador.
- **Cadastrar Jogo:** Adiciona um novo jogo ao banco de dados.
- **Atualizar Jogo:** Edita as informações de um jogo existente.
- **Deletar Jogo:** Remove um jogo do sistema por ID.

---

## 📌 Endpoints da API

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/games` | Retorna a lista completa de jogos. |
| `GET` | `/games/{id}` | Retorna as informações de um jogo específico. |
| `POST` | `/games` | Cadastra um novo jogo no sistema. |
| `PUT` | `/games/{id}` | Atualiza os dados de um jogo existente. |
| `DELETE` | `/games/{id}` | Remove um jogo do banco de dados. |

### 📝 Exemplo de Payload (JSON)

#### **POST /games** (Criar Novo Jogo)
```json
{
  "title": "Minecraft Dungeons",
  "genre": "Action RPG",
  "platform": "PC / Console",
  "releaseYear": 2020
}
