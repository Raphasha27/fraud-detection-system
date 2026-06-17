# Fraud Detection System


[![Coverage](https://img.shields.io/badge/Coverage-JaCoCo-blue?style=flat-square&logo=codecov)](https://github.com/Raphasha27/fraud-detection-system/actions)
[![CI](https://github.com/koketseraphasha/fraud-detection-system/actions/workflows/ci.yml/badge.svg)](https://github.com/koketseraphasha/fraud-detection-system/actions/workflows/ci.yml)

AI-powered fraud detection for banking transactions. Detects unusual transfers, rapid transactions, location anomalies, and high-risk activity.

## Features
- Real-time transaction monitoring
- Rule-based + ML fraud detection
- Risk scoring dashboard
- Investigation workflow
- Integration-ready for AI models



## Architecture

```mermaid
graph LR
    CL[Client] --> GW[API Gateway]
    GW --> AUTH[Auth Service]
    GW --> SVC[Banking Service]
    SVC --> DB[(PostgreSQL)]
    SVC --> EVT[Event Bus]
    EVT --> AUD[Audit Log]
    EVT --> FRAUD[Fraud Detection]
```

Microservices-based architecture with API Gateway, authentication layer, PostgreSQL persistence, and event-driven communication.

## Stack
Java 21, Spring Boot, PostgreSQL, Docker

## Quick Start
```bash
docker compose up -d
```

## Deployment & Architecture

This project is designed with cloud-ready principles:

- **Containerized** using Docker for consistent deployment
- **Environment-based configuration** — no hardcoded secrets
- **Modular structure** for independent scaling
- **Stateless design** where applicable
- **Separation of concerns** for maintainability

### Run Locally

`ash
docker-compose up --build
`

---

*Part of the Kirov Dynamics Technology portfolio — backend engineering focused on security, scalability, and system design.*
