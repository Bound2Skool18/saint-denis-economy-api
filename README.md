###Saint Denis Economy API

A RESTful API build with Spring Boot that manages trader economy data for a Red Dead Redemption 2 inspired trading system.

## Features 

- **Create** new trader prices (POST)
- **Read** all trader prices (GET)
- **Update** existing trader prices (PUT)
- **Delete** trader prices (DELETE)
- Automatic profit calculation 
- H2 in-memory database 
- RESTful architecture

## Technologies Used 

- Java 17/21
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
- Maven 

## API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/trader/prices` | Get all trader prices |
| POST | `/api/trader/prices` | Create new trader price |
| PUT | `/api/trader/prices/{id}` | Update existing trader price |
| DELETE | `/api/trader/prices/{id}` | Delete trader price |

## How to Run

1. Clone the repository
2. Open in your IDE (IntelliJ IDEA recommended)
3. Run `EconomyApiApplication.java`
4. API will be available at `http://localhost:8080`
5. H2 Console available at `http://localhost:8080/h2-console`

## Sample Request

**POST** `/api/trader/prices`
```json
{
  "productName": "Moonshine",
  "buyPrice": 30.0,
  "sellPrice": 80.0,
  "deliveryTimeMinutes": 15
}
```

**Response:**
```json
{
  "id": 1,
  "productName": "Moonshine",
  "buyPrice": 30.0,
  "sellPrice": 80.0,
  "profit": 50.0,
  "deliveryTimeMinutes": 15
}
```

## Future Enhancements

- Add input validation
- Implement filtering and sorting
- Switch to PostgreSQL
- Add authentication
- Build a frontend interface

## Author

[Your Name]
```

---

### 2. Add a .gitignore (if not already present)

Make sure you have a `.gitignore` file in your project root. Spring Initializr should have created one, but verify it includes:
```
target/
!.mvn/wrapper/maven-wrapper.jar
!**/src/main/**/target/
!**/src/test/**/target/

### IntelliJ IDEA ###
.idea
*.iws
*.iml
*.ipr

### VS Code ###
.vscode/

### Mac ###
.DS_Store
