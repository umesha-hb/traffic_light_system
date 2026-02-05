# 🚦 Traffic Light Control System

A production-style Spring Boot application designed to control traffic signals at an intersection. This project demonstrates clean architecture, REST API design, scheduling, concurrency handling, and database integration.

---

# 📌 Features

✅ Control traffic signals (RED, YELLOW, GREEN)
✅ Manual signal override via REST APIs
✅ Automatic signal rotation using Scheduler
✅ Emergency signal support (design-ready)
✅ Optimistic locking to prevent race conditions
✅ Global exception handling
✅ DTO-based API design (no entity exposure)
✅ MYSQL database for development
✅ Clean layered architecture

---

# 🧱 Tech Stack

* **Java 21**
* **Spring Boot 3.5*
* Spring Web
* Spring Data JPA
* H2 Database
* Maven 3+

---

# 🏗️ Architecture
The project follows a layered architecture:
Controller → Service → Repository → Database

# Package Structure
traffic.light.system
│
├── config # Scheduler & startup configuration
├── controller # REST APIs
├── service # Business logic
├── repository # Data access layer
├── entity # JPA entities
├── dto # Request/Response models
├── enums # Enum definitions
├── scheduler # Automatic signal rotation
├── exception # Global exception handling

-------
🔌 API Endpoints

PUT /traffic/signal

Request

{
"direction": "NORTH",
"signal": "GREEN"
}

Response
200 OK

