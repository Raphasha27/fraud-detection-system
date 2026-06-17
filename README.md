# Fraud Detection System

[![CI](https://github.com/koketseraphasha/fraud-detection-system/actions/workflows/ci.yml/badge.svg)](https://github.com/koketseraphasha/fraud-detection-system/actions/workflows/ci.yml)

AI-powered fraud detection for banking transactions. Detects unusual transfers, rapid transactions, location anomalies, and high-risk activity.

## Features
- Real-time transaction monitoring
- Rule-based + ML fraud detection
- Risk scoring dashboard
- Investigation workflow
- Integration-ready for AI models

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
