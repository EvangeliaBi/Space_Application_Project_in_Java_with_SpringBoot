# 🚀 Space Operations & Satellite Tracking Platform

A backend-focused space operations platform built with **Java, Spring Boot and PostgreSQL**.

The application focusing on clean backend architecture, REST APIs, database design, validation, exception handling and, in later stages, satellite telemetry and space-related simulation.

## 🎯 Project Overview

The goal of this project is to build a modular platform for managing satellites and space-operation data.

The system will progressively support:

* Satellite management
* Mission management
* Telemetry processing
* Satellite status monitoring
* Alert and event handling
* Ground station management
* Orbit and position calculations
* Telemetry simulation
* RESTful API services

## 🏗️ Architecture

The application follows a layered backend architecture:

Client
  │
  ▼
REST Controller
  │
  ▼
DTO / Validation
  │
  ▼
Service Layer
  │
  ▼
Repository Layer
  │
  ▼
Hibernate / JPA
  │
  ▼
PostgreSQL

The project is being developed incrementally so that each layer and feature can be tested independently.

## 🛠️ Technologies

### Backend

* Java 23
* Spring Boot 4.1.1
* Spring Web
* Spring Data JPA
* Hibernate
* Jakarta Validation
* Spring Boot Actuator

### Database

* PostgreSQL 18
* SQL

### Development Tools

* Eclipse IDE
* Maven
* Postman
* pgAdmin 4
* Git
* GitHub

### Satellite Management

The current version includes a complete basic CRUD REST API for satellites:

GET    /api/satellites
GET    /api/satellites/{id}
POST   /api/satellites
PUT    /api/satellites/{id}
DELETE /api/satellites/{id}

### Database

The PostgreSQL database currently contains the `satellites` table with fields for:

* Satellite code
* Name
* NORAD ID
* Operator
* Orbit type
* Altitude
* Inclination
* Status
* Launch date
* Creation timestamp

### Backend Structure

Current project structure:

com.space.spaceoperations
│
├── controller
│   └── SatelliteController
│
├── dto
│   ├── SatelliteRequest
│   └── SatelliteResponse
│
├── exception
│   ├── ApiError
│   ├── GlobalExceptionHandler
│   └── SatelliteNotFoundException
│
├── model
│   └── Satellite
│
├── repository
│   └── SatelliteRepository
│
├── service
│   └── SatelliteService
│
└── SpaceOperationsApplication


## 🔐 Validation & Error Handling

The API includes request validation using Jakarta Bean Validation.

Examples include:

* Required satellite fields
* Valid orbit types
* Valid satellite status values
* Positive NORAD IDs
* Non-negative altitude
* Valid inclination range

The application also uses centralized exception handling for API errors such as:

400 Bad Request
404 Not Found

## 🛰️ Planned Features

The project will continue to evolve with additional space-operation functionality.

### Mission Management

Mission
├── Mission ID
├── Mission Name
├── Satellite
├── Launch Date
├── Status
└── Description

### Telemetry

Telemetry data will include values such as:

Temperature
Battery
Solar Power
Signal Strength
Altitude
Velocity

### Alert System

The system will generate and manage events such as:

WARNING
CRITICAL
COMMUNICATION LOSS
LOW BATTERY
HIGH TEMPERATURE

### Orbit & Simulation

Future development will include:

* Satellite position calculations
* Orbital data processing
* Telemetry simulation
* Ground-track concepts
* Space-operation simulations

## 🧪 Testing

Testing will be expanded throughout development and will include:

* Unit tests
* Service layer tests
* Repository tests
* REST API integration tests

Planned technologies include:

JUnit
Mockito
Spring Boot Test

## 🐳 Deployment & DevOps

Future stages of the project will introduce:

* Docker
* Docker Compose
* GitHub Actions
* Automated testing
* CI/CD pipeline

## 📌 Project Status

This project is under active development.

The implementation is being built incrementally, starting with the satellite management backend and expanding toward a complete space operations platform.

## 👩‍💻 Purpose

* Object-Oriented Programming
* Java backend development
* REST API design
* Layered architecture
* Database integration
* Validation
* Exception handling
* Testing
* Software design
* Git/GitHub workflow
* DevOps and CI/CD concepts


## 👩‍💻 Author
Evangelia Bibasi
