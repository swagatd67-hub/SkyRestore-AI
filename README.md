# 🛰 SkyRestore AI

> **AI Powered Satellite Cloud Removal & Disaster Intelligence Platform**

SkyRestore AI is an end to end disaster intelligence platform that removes clouds from satellite imagery using Artificial Intelligence and generates disaster insights using Google's Gemini AI.

The platform helps emergency responders, governments and disaster management agencies obtain clear satellite imagery for faster and more informed decisions.

---

# ✨ Features

## 🤖 AI Cloud Removal

Remove cloud cover from satellite imagery using deep learning.

## 🌍 Disaster Intelligence

Generate AI powered reports using Gemini AI.

## 📡 Satellite Image Processing

Upload and analyze satellite imagery.

## 🗺 Interactive Disaster Map

Visualize disaster locations with GIS mapping.

## 📊 Analytics Dashboard

View AI confidence, disaster statistics and trends.

## 🔒 Secure Authentication

JWT based authentication using Spring Boot.

---

# 🏗 Project Architecture

```text
                 Angular Frontend
                        │
                        ▼
               Spring Boot Backend
                        │
          ┌─────────────┴─────────────┐
          ▼                           ▼
     FastAPI AI Service           MySQL Database
          │
          ▼
      Gemini AI
```

---

# 💻 Technology Stack

## Frontend

- Angular
- Angular Material
- SCSS
- Chart.js
- Leaflet

## Backend

- Spring Boot
- Spring Security
- JWT
- MySQL

## AI

- FastAPI
- Python
- Gemini AI

---

# 📂 Project Structure

```text
SkyRestore-AI
│
├── frontend
├── backend
├── ai-service
├── docs
└── README.md
```

---

# 🚀 Getting Started

## Clone Repository

```bash
git clone https://github.com/swagatd67-hub/SkyRestore-AI.git
```

## Frontend

```bash
cd frontend
npm install
ng serve
```

## Backend

```bash
cd backend
mvn spring-boot:run
```

## AI Service

```bash
cd ai-service
pip install -r requirements.txt
uvicorn main:app --reload
```

---

# 🎯 Future Scope

- Multi satellite support
- Live disaster monitoring
- AI powered rescue recommendations
- Real time weather integration
- Mobile application

---

# 👨‍💻 Team

SkyRestore AI Hackathon Team

---

# 📄 License

MIT License