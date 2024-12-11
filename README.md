# Backend - Gestor de Matrículas
Este é o back-end do sistema Gestor de Matrículas, desenvolvido em Java com Spring Boot.
## Pré-requisitos
Antes de iniciar, certifique-se de ter instalado:

- [Java 17+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- [PostgreSQL 14+](https://www.postgresql.org/download/) ou outro banco de dados compatível.
##  Configuração e Execução

### 1. Clonar o Repositório
```bash
  git clone https://github.com/seu-usuario/gestordematriculas.git
  cd gestordematriculas
``` 

## Configurar o Banco de Dados

Recomendo realizar uma configuração básica yml para um banco local. 
```yml
spring:
datasource:
url: jdbc:h2:mem:gestordematriculadb
driver-class-name: org.h2.Driver
username: sa
password:
jpa:
hibernate:
ddl-auto: update
show-sql: true
database-platform: org.hibernate.dialect.H2Dialect

server:
port: 8080
```

## Executar o Projeto

```bash
  ./mvnw spring-boot:run
```

## Estrutura do Projeto
- controller/: Controladores REST.
- service/: Lógica de negócios.
- repository/: Interfaces de acesso ao banco de dados.
- model/: Entidades JPA.
- dto/: Transferência de dados entre camadas.

## Endpoints Principais
- Alunos
 GET /api/students - Listar todos os alunos.
 POST /api/students - Cadastrar um aluno.
- Cursos
 GET /api/courses - Listar todos os cursos.
 POST /api/courses - Cadastrar um curso.
- Matrículas
 GET /api/enrollments - Listar todas as matrículas.
 POST /api/enrollments - Criar uma matrícula.

## Popular o Banco de Dados 

Utilize o Insomnia ou o Postman para realizar a população do DB.

1. JSON para Alunos
   Endpoint: POST /api/students

```json
[
{
"name": "John Doe",
"email": "john.doe@example.com"
},
{
"name": "Jane Smith",
"email": "jane.smith@example.com"
},
{
"name": "Alice Johnson",
"email": "alice.johnson@example.com"
},
{
"name": "Bob Brown",
"email": "bob.brown@example.com"
},
{
"name": "Charlie Green",
"email": "charlie.green@example.com"
}
]
```

2. JSON para Cursos
Endpoint: POST /api/courses

```json

[
{
"name": "Introduction to Programming",
"description": "Learn the basics of programming using Python."
},
{
"name": "Data Structures and Algorithms",
"description": "Understand data structures and algorithms for solving problems."
},
{
"name": "Web Development",
"description": "Learn to build modern web applications."
},
{
"name": "Database Management",
"description": "Understand relational databases and SQL."
},
{
"name": "Machine Learning",
"description": "Explore machine learning fundamentals."
}
]
```

3. JSON para Matrículas
Endpoint: POST /api/enrollments

Assumindo que você já tenha os IDs de alunos e cursos criados, aqui estão as matrículas com relações simuladas:

```json
[
{
"studentId": "1",
"courseId": "1"
},
{
"studentId": "2",
"courseId": "2"
},
{
"studentId": "3",
"courseId": "3"
},
{
"studentId": "1",
"courseId": "2"
},
{
"studentId": "4",
"courseId": "4"
},
{
"studentId": "5",
"courseId": "5"
}
]
```

OBS: SUBSTITUIR NUMEROS PELOS RESPECTIVOS UUIDs DOS CADASTROS! 