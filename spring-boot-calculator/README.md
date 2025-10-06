# Spring Boot Calculator

A simple REST API calculator built with Spring Boot that performs basic arithmetic operations.

## Features

- Addition
- Subtraction
- Multiplication
- Division (with zero-division error handling)

## Technology Stack

- Java 17
- Spring Boot 3.1.0
- Maven

## Project Structure

```
spring-boot-calculator/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── example/
│                   └── calculator/
│                       ├── CalculatorApplication.java
│                       ├── CalculatorController.java
│                       └── CalculatorService.java
├── pom.xml
└── README.md
```

## API Endpoints

All endpoints are accessible at: `http://localhost:8080/api/calculator`

### Add
```
GET /api/calculator/add?a={number1}&b={number2}
```

### Subtract
```
GET /api/calculator/subtract?a={number1}&b={number2}
```

### Multiply
```
GET /api/calculator/multiply?a={number1}&b={number2}
```

### Divide
```
GET /api/calculator/divide?a={number1}&b={number2}
```

## How to Run

1. Clone the repository
2. Navigate to the project directory
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
4. The application will start on `http://localhost:8080`

## Example Usage

```bash
curl "http://localhost:8080/api/calculator/add?a=10&b=5"
# Returns: 15.0

curl "http://localhost:8080/api/calculator/subtract?a=10&b=5"
# Returns: 5.0

curl "http://localhost:8080/api/calculator/multiply?a=10&b=5"
# Returns: 50.0

curl "http://localhost:8080/api/calculator/divide?a=10&b=5"
# Returns: 2.0
```

## Building the Project

```bash
mvn clean install
```

## Running Tests

```bash
mvn test
```
