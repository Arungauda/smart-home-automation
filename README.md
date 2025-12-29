🏠 Smart Home Automation System (Console Application)
📌 Overview

This project is a console-based Smart Home Automation System designed to demonstrate the application of SOLID principles, advanced design patterns, and microservices design patterns using plain Java.

The system supports:

Device management

User management

Automation rules

Event-driven notifications

Reports

⚠️ No UI frameworks, no database, and no external libraries are used.
All data is stored statically in memory, as per assignment requirements.

🎯 Objectives

Demonstrate correct usage of design patterns

Build a maintainable, scalable architecture

Simulate microservices concepts without infrastructure

Keep the solution simple, readable, and extensible

🧱 Architecture Overview

The application follows a layered and decomposed architecture:

Main (Console Input)
   ↓
Services / Gateway
   ↓
Repositories (Static In-Memory)
   ↓
EventBus (Publish–Subscribe)
   ↓
Notification Service


Each component has a single responsibility and communicates through well-defined contracts.

📂 Package Structure
com.smarthome
 ├── Main.java
 ├── controller
 │   └── SmartHomeGateway.java
 ├── common
 │   ├── AppLogger.java
 │   └── SmartHomeException.java
 │   ├── interceptor
 │   │   └── LoggingInterceptor.java
 │   └── operational
 │       ├── CircuitBreaker.java
 │       └── HealthCheck.java
 ├── device
 │   ├── Device.java
 │   ├── DeviceDetails.java
 │   ├── DeviceRepository.java
 │   ├── DeviceRepositoryImpl.java
 │   └── DeviceService.java
 ├── user
 │   ├── User.java
 │   ├── Admin.java
 │   ├── HomeOwner.java
 │   ├── UserFactory.java
 │   ├── UserRepository.java
 │   └── UserRepositoryImpl.java
 ├── automation
 │   ├── AutomationRule.java
 │   ├── AutomationService.java
 │   └── AutomationRuleRepository.java
 ├── notification
 │   ├── Event.java
 │   ├── DeviceStatusChangedEvent.java
 │   ├── AutomationExecutedEvent.java
 │   ├── Subscriber.java
 │   ├── EventBus.java
 │   └── NotificationService.java
 └── report
     └── ReportService.java

🧠 Design Patterns Used
1️⃣ Factory Method

Purpose: Create different user roles without exposing creation logic
Implementation: UserFactory

ADMIN → Admin
HOMEOWNER → HomeOwner

2️⃣ Singleton

Purpose: Ensure a single instance across the system
Implementation:

EventBus

AppLogger

3️⃣ Publish–Subscribe (Observer)

Purpose: Decouple services using event-driven communication
Implementation:

EventBus publishes events

NotificationService subscribes and reacts

Used for:

Device status changes

Automation rule execution notifications

4️⃣ Repository Pattern

Purpose: Abstract data access and storage
Implementation:

UserRepository

DeviceRepository

AutomationRuleRepository

📌 All repositories use static in-memory data structures.

5️⃣ Lazy Loading

Purpose: Delay expensive object creation
Implementation:

DeviceDetails is initialized only when accessed from Device

6️⃣ Interceptor Pattern

Purpose: Pre- and post-processing of requests
Implementation:

LoggingInterceptor for request logging

7️⃣ Resource Pool Pattern

Purpose: Manage reusable resources efficiently
Implementation:

Device-related resources are pooled and reused conceptually
(Simulated for demonstration purposes)

🌐 Microservices Design Patterns (Simulated)

⚠️ No real microservices infrastructure is used.
Patterns are demonstrated conceptually within a single JVM.

🔹 Decomposition Pattern

Each domain is split into independent services:

UserService

DeviceService

AutomationService

NotificationService

🔹 Integration Patterns

API Gateway Simulation: SmartHomeGateway

Event-Driven Integration: EventBus

Services do not directly depend on each other.

🔹 Data Patterns

Database per service is simulated using:

Separate static in-memory repositories

No shared global data store

🔹 Operational Patterns

Circuit Breaker: Prevents repeated failures in DeviceService

Health Check: Allows gateway to verify service availability

These patterns improve resilience and fault isolation.

⚙️ Functional Features
✔ User Management

Create users (Admin / HomeOwner)

View users

✔ Device Management

Add devices

Update device status

View devices

✔ Automation Rules

Define rule triggers and actions

Execute rules based on triggers

✔ Notifications

Console-based notifications for:

Device changes

Automation execution

✔ Reports

Device usage report

Automation rules report

Console output only

🖥️ How to Run
Prerequisites

Java 8 or higher

Steps
javac Main.java
java Main


Follow the menu-driven console options to interact with the system.

🧪 Sample Console Flow
1. Create User
2. Add Device
3. Change Device Status
→ Notification printed
→ Event published
→ Automation triggered (if applicable)

📌 Assumptions

Single-threaded console execution

No persistence beyond runtime

Time-based scheduling is simulated using triggers

Notifications are console messages only

🚀 Future Enhancements

Replace in-memory repositories with databases

Expose REST APIs

Add real schedulers

Integrate message brokers (Kafka / RabbitMQ)

Introduce authentication & authorization

✅ Conclusion

This project demonstrates a clean, extensible, and scalable architecture using core Java, design patterns, and microservices concepts, fulfilling all assignment requirements without unnecessary complexity.

If you want next:

✅ Final review checklist

✅ Screenshots guidance

✅ One-page architecture explanation for viva

Just tell me 👍
