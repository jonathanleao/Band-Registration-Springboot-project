# 🎸 Band Registration - Spring Boot Project

Um projeto de registro e gerenciamento de bandas e seus líderes desenvolvido com **Spring Boot 4.0.6** e **Java 17**, criado para fins de aprendizado e desenvolvimento contínuo.

## 📋 Sobre o Projeto

Este é um aplicativo backend desenvolvido em **Spring Boot** que permite o registro, gestão e organização de informações sobre bandas e seus líderes. O projeto segue as melhores práticas de desenvolvimento com Spring Framework, incluindo validação de dados, mapeamento de objetos e persistência em banco de dados relacional.

## 🛠️ Tecnologias Utilizadas

### Core Framework
- **Spring Boot** 4.0.6
- **Java** 17
- **Maven** - Gerenciador de dependências

### Bibliotecas e Dependências

#### Spring Framework
- **Spring Web MVC** - Desenvolvimento de controllers REST
- **Spring Data JPA** - Persistência de dados com ORM
- **Spring Validation** - Validação de dados

#### Ferramentas de Desenvolvimento
- **Lombok** - Redução de boilerplate code (getters, setters, constructores)
- **MapStruct** 1.6.3 - Mapeamento de objetos (DTO ↔ Entity)
- **Spring DevTools** - Reload automático durante desenvolvimento

#### Banco de Dados
- **MySQL Connector/J** - Driver MySQL para conexão com banco de dados

#### Ferramentas de Teste
- **Postman** - Testes de API REST

## 📁 Estrutura do Projeto

```
Band-Registration-Springboot-project/
├── src/
│   ├── main/
│   │   ├── java/com/jonas/BandRegistrationSpringboot/
│   │   │   ├── domain/                       # Entidades JPA
│   │   │   ├── controller/                   # Controllers REST
│   │   │   ├── service/                      # Lógica de negócio
│   │   │   ├── repository/                   # Acesso a Banco de dados
│   │   │   ├── DTO/                          # Data Transfer Objects
|   |   |   ├── Exceptions/exceptionsDetails? # Tratamento de exceções customizadas
|   |   |   ├── GlobalHandler/                #  Controle de padronização de exceções        
│   │   │   ├── mapper/                       # MapStruct Mappers
│   │   │   └── BandRegistrationSpringbootApplication.java
│   │   └── resources/
│   │       ├── application.yaml     # Configuração principal
│   │       └── application-example.yml  # Exemplo de configuração
│   └── test/                        # Testes unitários e de integração
├── .mvn/
├── pom.xml                          # Configurações Maven
├── mvnw                             # Maven Wrapper (Unix)
└── mvnw.cmd                         # Maven Wrapper (Windows)
```

## 🚀 Como Começar

### Pré-requisitos

- **Java 17** ou superior instalado
- **Maven 3.6+** (ou use o Maven Wrapper incluído)
- **MySQL 8.0+** instalado e rodando
- Uma IDE como **IntelliJ IDEA**, **VS Code** ou **Eclipse**

### Instalação

1. **Clone o repositório**
   ```bash
   git clone https://github.com/jonathanleao/Band-Registration-Springboot-project.git
   cd Band-Registration-Springboot-project
   ```

2. **Configure o banco de dados**
   
   Crie um arquivo `src/main/resources/application.yaml` baseado no template `application-example.yml`:
   ```yaml
   server:
     error:
       include-stacktrace: never
       include-message: always
       include-binding-errors: never

   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/cadastro_banda?createDatabaseIfNotExist=true
       username: root
       password: sua_senha
       driver-class-name: com.mysql.cj.jdbc.Driver
     
     jpa:
       hibernate:
         ddl-auto: update
   ```

3. **Instale as dependências**
   ```bash
   ./mvnw clean install
   ```
   
   Ou no Windows:
   ```bash
   mvnw.cmd clean install
   ```

4. **Inicie a aplicação**
   ```bash
   ./mvnw spring-boot:run
   ```

   A aplicação estará disponível em: `http://localhost:8080`

## 💻 Desenvolvimento

### Compilar o projeto
```bash
./mvnw clean compile
```

### Construir JAR executável
```bash
./mvnw clean package
```

### Usar DevTools para desenvolvimento
Durante o desenvolvimento, o **Spring DevTools** permite que a aplicação reinicie automaticamente ao detectar mudanças nos arquivos, tornando o desenvolvimento mais ágil.

## 📚 Funcionalidades Principais

- ✅ Registro de bandas com validação de dados
- ✅ Registro e gerenciamento de líderes de banda
- ✅ CRUD completo (Create, Read, Update, Delete)
- ✅ Persistência em banco de dados MySQL
- ✅ Mapeamento de objetos com MapStruct
- ✅ Validação automática de entrada
- ✅ REST API
- ✅ Testado com Postman

## 🔗 Endpoints REST

### Bandas

```
GET    /bands/{id}         - Obter banda específica
POST   /bands              - Criar nova banda
PUT    /bands              - Atualizar banda
DELETE /bands/{id}         - Deletar banda
```

### Líderes

```
GET    /leaders/{id}       - Obter líder específico
POST   /leaders            - Criar novo líder
PUT    /leaders            - Atualizar líder
DELETE /leaders/{id}       - Deletar líder
```

## 📋 Exemplos de Requisições (Postman)

### Criar uma banda

**Método:** `POST`  
**URL:** `http://localhost:8080/bands`  
**Content-Type:** `application/json`

```json
{
  "bandName": "The Beatles",
  "numMembers": 4,
  "leaderId": 1
}
```

**Resposta (201 Created):**
```json
{
  "id": 1,
  "bandName": "The Beatles",
  "numMembers": 4,
  "leaderId": 1
}
```

---

### Obter uma banda específica

**Método:** `GET`  
**URL:** `http://localhost:8080/bands/1`

**Resposta (200 OK):**
```json
{
  "id": 1,
  "bandName": "The Beatles",
  "numMembers": 4,
  "leaderId": 1
}
```

---

### Atualizar uma banda

**Método:** `PUT`  
**URL:** `http://localhost:8080/bands`  
**Content-Type:** `application/json`

```json
{
  "id": 1,
  "bandName": "The Beatles",
  "numMembers": 5,
  "leaderId": 1
}
```

---

### Deletar uma banda

**Método:** `DELETE`  
**URL:** `http://localhost:8080/bands/1`

---

### Criar um líder

**Método:** `POST`  
**URL:** `http://localhost:8080/leaders`  
**Content-Type:** `application/json`

```json
{
  "leaderName": "John",
  "surname": "Lennon"
}
```

**Resposta (201 Created):**
```json
{
  "id": 1,
  "leaderName": "John",
  "surname": "Lennon"
}
```

---

### Obter um líder específico

**Método:** `GET`  
**URL:** `http://localhost:8080/leaders/1`

**Resposta (200 OK):**
```json
{
  "id": 1,
  "leaderName": "John",
  "surname": "Lennon"
}
```

---

### Atualizar um líder

**Método:** `PUT`  
**URL:** `http://localhost:8080/leaders`  
**Content-Type:** `application/json`

```json
{
  "id": 1,
  "leaderName": "John",
  "surname": "Lennon"
}
```

---

### Deletar um líder

**Método:** `DELETE`  
**URL:** `http://localhost:8080/leaders/1`

---

## 📝 Padrões e Boas Práticas

Este projeto utiliza:

- **DTO Pattern** - Separação entre entidades e dados transferidos
- **Mapper Pattern** (MapStruct) - Conversão automática de objetos
- **Validação Bean Validation** - Validação declarativa de dados
- **Separation of Concerns** - Camadas bem definidas (Controller → Service → Repository)
- **Spring JPA** - ORM para acesso a dados relacional
- **RESTful API** - Endpoints semânticos e bem estruturados

## 📦 Dependências Principais

| Dependência | Versão | Propósito |
|-------------|--------|----------|
| spring-boot-starter-web | 4.0.6 | Web e REST |
| spring-boot-starter-data-jpa | 4.0.6 | Persistência |
| spring-boot-starter-validation | 4.0.6 | Validação |
| mapstruct | 1.6.3 | Mapeamento de objetos |
| lombok | Latest | Reduz boilerplate |
| mysql-connector-j | Latest | Conexão MySQL |

## 🎓 Propósito

Este é um projeto de **aprendizado e desenvolvimento contínuo**, onde são praticados:

- Desenvolvimento com Spring Boot
- Implementação de APIs REST
- Acesso a dados com JPA/Hibernate
- Boas práticas de organização de código
- Validação e tratamento de erros
- Mapeamento de entidades com MapStruct

## 🧪 Testes

A API foi testada e validada utilizando **Postman** para garantir o funcionamento correto de todos os endpoints.

## 📚 Recursos de Aprendizado

- [Documentação Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Lombok Documentation](https://projectlombok.org/)
- [MapStruct Documentation](https://mapstruct.org/)
- [Spring Validation](https://spring.io/guides/gs/validating-form-input/)
- [Postman Documentation](https://learning.postman.com/)

## 🤝 Contribuindo

Este é um projeto pessoal de aprendizado, mas sugestões e melhorias são bem-vindas!

## 📄 Licença

Este projeto está aberto para uso educacional e desenvolvimento pessoal.

## 👨‍💻 Autor

**Jonathan Leão**
- GitHub: [@jonathanleao](https://github.com/jonathanleao)

---

**Última atualização:** 01 de junho de 2026

*Um projeto em construção! 🚀 Continua sendo atualizado conforme o aprendizado evolui.*
