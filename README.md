\# 🎉 Birthday Reminder Application



A Spring Boot-based backend application that automatically manages birthday reminders and sends email notifications to users.



\---



\## 🚀 Project Overview



This system allows users to:

\- Add a person’s name, email, birthday date, and custom message

\- Automatically send a welcome email when a user is added

\- Schedule and send birthday emails on the exact date of birth

\- Maintain a simple automated birthday notification system



The goal of this project is to eliminate the need for manually remembering birthdays by automating email notifications.



\---



\## 🛠️ Tech Stack



\- Java 17

\- Spring Boot

\- Spring Web

\- Spring Data JPA

\- Spring Scheduler

\- Maven

\- SMTP Email Service (Gmail or similar)

\- PostgreSQL (Railway hosted database)



\---



\## ⚙️ Features



\### ✅ User Management

\- Add birthday entries with email and message

\- Store user data in database



\### 📧 Email Notifications

\- Sends confirmation email when a user is added

\- Automatically sends birthday wishes on the scheduled date



\### ⏰ Scheduler

\- Uses Spring Scheduler to run periodic checks

\- Compares current date with stored birthdays

\- Triggers email service when match is found



\---



\## 🗄️ Database



\- Hosted on Railway

\- Stores:

&#x20; - Name

&#x20; - Email

&#x20; - Birthday date

&#x20; - Custom message



\---



\## 📂 Project Structure

src/

├── controller

├── service

├── repository

├── model

├── scheduler

└── config





\---



\## 🧠 How It Works



1\. User submits birthday details

2\. Data is stored in database

3\. System scheduler runs periodically

4\. If current date matches birthday:

&#x20;  - Email service is triggered

&#x20;  - Birthday message is sent automatically



\---



\## 📌 API Endpoints (Sample)



\- `POST /api/birthdays` → Add new birthday entry  

\- `GET /api/birthdays` → Get all entries  

\- `DELETE /api/birthdays/{id}` → Remove entry  



\---



\## 📦 Build \& Run (Local)



```bash

mvn clean install

mvn spring-boot:run

