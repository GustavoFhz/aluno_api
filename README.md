# Aluno API

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)

## Descrição
O **Aluno API** é uma API REST desenvolvida com **Java Spring Boot** para o gerenciamento de alunos. O projeto utiliza **JPA** para interação com o banco de dados **MySQL** e conta com testes automatizados para garantir a qualidade do código.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **JUnit 5**
- **Postman (para testes de API)**

## Como Executar o Projeto

### 1. Clonar o Repositório
```bash
git clone https://github.com/GustavoFhz/aluno_api.git
cd aluno_api
```

### 2. Configurar o Banco de Dados
Certifique-se de ter um banco de dados MySQL rodando. Configure as credenciais no arquivo `application.properties` ou `application.yml`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/alunos_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### 3. Rodar a Aplicação
Utilize o Maven para compilar e rodar o projeto:
```bash
./mvnw spring-boot:run
```
A API estará acessível em `http://localhost:8080`

## Endpoints
A API oferece os seguintes endpoints:

### Criar um Aluno
```http
POST /alunos
```
**Body (JSON):**
```json
{
  "nome": "João Silva",
  "idade": 20,
  "curso": "Engenharia"
}
```

### Listar Alunos
```http
GET /alunos
```

### Buscar Aluno por ID
```http
GET /alunos/{id}
```

### Atualizar um Aluno
```http
PUT /alunos/{id}
```
**Body (JSON):**
```json
{
  "nome": "Maria Souza",
  "idade": 22,
  "curso": "Medicina"
}
```

### Deletar um Aluno
```http
DELETE /alunos/{id}
```

## Testes Automatizados
Para rodar os testes automatizados, utilize o comando:
```bash
./mvnw test
```





