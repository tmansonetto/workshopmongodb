# Workshop MongoDB

A Spring Boot REST API backed by **MongoDB**, built while studying Spring Data MongoDB: documents, references between collections, DTOs and global exception handling.

## Tech stack
- Java 25
- Spring Boot 4.1 (Spring Web MVC, Spring Data MongoDB)
- MongoDB
- Maven (wrapper included)

## Project structure
```
com.tmansonetto.workshopmongo
├── config        Instantiation – seeds the database on startup
├── domain        User and Post documents
├── dto           UserDTO
├── repository    UserRepository, PostRepository (MongoRepository)
├── services      UserService, exception/ObjectNotFoundException
└── resources     UserResource (REST controller), exception handler / StandardError
```

## Getting started
1. Install and start MongoDB (default `localhost:27017`).
2. Check `src/main/resources/application.properties`:
   ```properties
   spring.mongodb.uri=mongodb://localhost:27017/workshop_mongo
   ```
3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
   The API is served at `http://localhost:8080`.

## Endpoints (`/users`)
| Method | Path | Description |
|---|---|---|
| GET | `/users` | List all users |
| GET | `/users/{id}` | Find a user by id |
| POST | `/users` | Create a user |
| PUT | `/users/{id}` | Update a user |
| DELETE | `/users/{id}` | Delete a user |

Example:
```bash
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Maria Brown","email":"maria@example.com"}'
```

## Concepts practiced
- Mapping classes to MongoDB collections with `@Document`
- `MongoRepository` and layered architecture (resource → service → repository)
- DTO pattern
- Custom exceptions with a `@ControllerAdvice` handler returning a standard error body
