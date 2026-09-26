# Facility Booking System

A full-stack, enterprise-ready web application built to streamline the scheduling and management of corporate or community facilities (e.g., meeting rooms, event halls, sports complexes, labs). Featuring a modern microservice-ready **Spring Boot REST API** backend paired with a dynamic, responsive **React** frontend dashboard.

[![Spring Boot](https://shields.io)](https://spring.io)
[![React](https://shields.io)](https://react.dev)
[![License: MIT](https://shields.io)](https://opensource.org)

---

## 🚀 Features

### 👤 User Capabilities
* **Interactive Booking Calendar:** Visual grid layout to view hourly or daily facility availability.
* **Smart Search & Filters:** Filter options by capacity, facility type, equipment requirements, and specific date/time blocks.
* **Booking Management:** Real-time updates to request, track, reschedule, or cancel reservations.
* **Automated Email Confirmations:** Immediate receipt generation and booking approvals triggered natively via backend workers.

### 🛠 Admin Dashboard
* **Facility Management:** Fully comprehensive CRUD actions to create, update, or disable rooms, including customizable asset listing (e.g., A/V setup, whiteboards).
* **Dynamic Approval Workflows:** Configure manual review checkpoints or establish automated approvals based on priority parameters.
* **Analytics & Reports:** Visualized usage breakdowns mapping peak booking hours, occupancy rates, and high-demand facility types.

### 🔒 Core Architecture
* **Role-Based Access Control (RBAC):** Distinct operational capabilities mapped securely to `ROLE_USER` and `ROLE_ADMIN` identities.
* **Token-Based Session Security:** State management backed via stateless **JSON Web Tokens (JWT)** via Spring Security routing filters.
* **Double-Booking Prevention:** Strict ACID-compliant database locking mechanisms ensuring zero schedule overlaps at point of write.

---

## 🛠 Tech Stack

| Tier | Component | Technology Used |
| :--- | :--- | :--- |
| **Frontend** | UI Framework | [React.js](https://react.dev) (Hooks, Context API) |
| | Styling | [Tailwind CSS](https://tailwindcss.com) / Material UI |
| | HTTP Client | [Axios](https://axios-http.com) |
| **Backend** | Framework | [Spring Boot](https://spring.io) (Java 17+) |
| | Security | [Spring Security](https://spring.io) & JWT |
| | Data Access | Spring Data JPA / Hibernate |
| **Database** | Relational DB | MySQL / PostgreSQL |

---

## 💻 Getting Started

### Prerequisites
* [Java Development Kit (JDK) 17+](https://adoptium.net)
* [Node.js](https://nodejs.org) (v18+)
* [MySQL](https://mysql.com) or another relational database service.

### 📦 Installation

#### 1. Database Setup
Create a new database scheme locally:
```sql
CREATE DATABASE facility_booking_db;
```

#### 2. Backend Configurations
Clone the repository and locate `backend/src/main/resources/application.properties` to map your local credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/facility_booking_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=YOUR_DATABASE_USERNAME
spring.datasource.password=YOUR_DATABASE_PASSWORD

# JWT Secret Key Config
app.jwt.secret=YourSuperSecretSignatureKeyThatIsAtLeast256BitsLong
app.jwt.expiration-ms=86400000
```

Run the Spring Boot server instance:
```bash
cd backend
./mvnw spring-boot:run
```

#### 3. Frontend Configurations
Open a secondary shell pipeline to fetch and initialize interface package assets:
```bash
cd frontend
npm install
npm start
```
The application will launch locally at `http://localhost:3000`, communicating with the backend hosted environment routing at `http://localhost:8080`.

---

## 📡 API Architecture Highlights
All system endpoints follow uniform REST patterns protected behind standard JWT authorization filters:

* `POST /api/auth/register` - Create user enrollment.
* `GET /api/facilities` - Fetch public index of available real estate listings.
* `POST /api/bookings` - Create reservation block (`Requires Auth`).
* `GET /api/admin/analytics` - Pull global occupancy breakdown structures (`Requires Admin`).

---

## 📄 License
Distributed under the MIT License. See `LICENSE` for more details.