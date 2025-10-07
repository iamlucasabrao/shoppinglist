# 🛒 Simple Shopping List API

A simple **Spring Boot REST API** for managing shopping list items.  
The API supports CRUD operations, loads initial data from a JSON file, and calculates the total cost of each item (`price × quantity`).
A H2 database is used for storing the data and some few data are already filled up for testing purposes as soon as the app starts.

---

## 🚀 Features

- CRUD endpoints for managing shopping list items
- Embedded H2 database
- Automatic data loading from `data.json` on startup
- Computed field: `cost = price × quantity`
- Timestamps (`createdAt`, `updatedAt`)
- Simple error handling
- Dockerized setup with `docker-compose`

---

## 🧱 Project Structure

rc/
├── main/
│ ├── java/com/example/shoppinglist/
│ │ ├── controller/
│ │ ├── service/
│ │ ├── repository/
│ │ └── model/
│ └── resources/
│ ├── application.properties
│ └── data.json
└── test/

---

## Run with Docker Compose

1. Make sure you have **Docker** and **Docker Compose** installed.
2. Build and start the app:

```bash
docker-compose up --build 

```

Once it’s running, the API will be available at:
👉 http://localhost:8080/api/items

API Endpoints

| Method | Endpoint          | Description     |
| ------ | ----------------- | --------------- |
| GET    | `/api/items`      | Get all items   |
| GET    | `/api/items/{id}` | Get item by ID  |
| POST   | `/api/items`      | Create new item |
| PUT    | `/api/items/{id}` | Update item     |
| DELETE | `/api/items/{id}` | Delete item     |


🧪 Sample Data (data.json)

[
{ "name": "Apples", "price": 2.5, "quantity": 4, "category": "Fruit" },
{ "name": "Milk", "price": 3.0, "quantity": 2, "category": "Dairy" },
{ "name": "Bread", "price": 4.0, "quantity": 1, "category": "Bakery" }
]

Author
Lucas Abrão - lucaspiano@gmail.com