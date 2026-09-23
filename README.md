# E-Commerce Microservices Architecture (Demo)

A foundational microservices project built with Java and Spring Boot. This project demonstrates the core concepts of distributed systems, including Service Discovery, declarative REST clients, and fault isolation.

## 🏗 Architecture Overview

This system mimics a basic e-commerce backend split into three distinct applications:

1. **Service Registry (Eureka Server):** Acts as a dynamic directory. It allows microservices to find and communicate with each other without hardcoding IP addresses or port numbers.
2. **Product Service:** An independent REST API that manages product inventory data.
3. **Order Service:** A client-facing service that handles order creation. It communicates dynamically with the Product Service to fetch data before processing an order.

## 🛠 Tech Stack

* **Language:** Java 25
* **Framework:** Spring Boot 4.x
* **Cloud Infrastructure:** Spring Cloud (Netflix Eureka)
* **Inter-Service Communication:** Spring Cloud OpenFeign
* **Build Tool:** Maven

## 🚀 Key Concepts Demonstrated

* **Service Discovery:** Implemented Eureka so services can register themselves dynamically on startup.
* **Declarative HTTP Clients:** Replaced manual `RestTemplate` calls with **OpenFeign** interfaces for cleaner, more maintainable inter-service communication.
* **Fault Isolation:** Architected so that if one business domain goes offline, it does not crash the internal routing infrastructure.

## ⚙️ How to Run Locally

Because these services depend on each other, they must be started in a specific sequence.

1. **Start the Service Registry:**
   * Navigate to the `service-registry` directory and run the application.
   * Verify it is running by opening `http://localhost:8761` in your browser.

2. **Start the Microservices:**
   * Run the `product-service` application (starts on port 8081).
   * Run the `order-service` application (starts on port 8082).
   * Refresh the Eureka dashboard at `http://localhost:8761` to verify both `PRODUCT-SERVICE` and `ORDER-SERVICE` are registered.

3. **Test the Endpoints:**
   * **Test Product Service isolated:** `GET http://localhost:8081/products`
   * **Test Inter-service communication:** `GET http://localhost:8082/orders/create`
