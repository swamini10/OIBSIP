# 🚆 Online Reservation System

A Java Swing-based Online Reservation System developed as part of the Oasis Infobyte Internship. The application allows users to log in, book train tickets, search reservations using a PNR number, and cancel reservations through a user-friendly desktop interface.

---

## 📌 Features

- 🔐 User Login
- 🎫 Train Ticket Reservation
- 🔍 Search Reservation by PNR
- ❌ Cancel Reservation
- 🚉 Auto-fetch Train Name using Train Number
- 🎲 Automatic PNR Generation
- 💾 MySQL Database Integration
- 🖥️ Java Swing GUI
- ⬅️ Dashboard Navigation
- 🚪 Logout Functionality

---

## 🛠️ Tech Stack

- Java
- Java Swing
- JDBC
- MySQL
- Eclipse IDE

---

## 📂 Project Structure

```
OnlineReservationSystem
│
├── db
│   └── DBConnection.java
│
├── dao
│   ├── TrainDAO.java
│   └── ReservationDAO.java
│
├── gui
│   ├── LoginFrame.java
│   ├── DashboardFrame.java
│   ├── ReservationFrame.java
│   └── CancellationFrame.java
│
├── model
│   └── Reservation.java
│
└── Main.java
```

---

## 🗄️ Database

Database Name:

```
reservation_db
```

Tables:

- users
- trains
- reservations

---

## 🚀 How to Run

1. Clone the repository

```bash
git clone https://github.com/swamini10/OnlineReservationSystem
```

2. Import the project into Eclipse.

3. Create the MySQL database.

4. Update the database credentials in:

```
DBConnection.java
```

5. Run:

```
LoginFrame.java
```

---

## 📸 Screenshots

Add screenshots of:

- Login Page
- Dashboard
- Reservation Form
- Cancellation Form
- Successful Reservation
- Successful Cancellation

<img width="1920" height="1080" alt="Screenshot 2026-07-21 171128" src="https://github.com/user-attachments/assets/b6a26834-aee3-4c86-8229-190c975d1cc3" />
<img width="1920" height="1080" alt="Screenshot 2026-07-21 171239" src="https://github.com/user-attachments/assets/92dcf7c7-5592-4c82-95c7-83c3822601cc" />
<img width="1920" height="1080" alt="Screenshot 2026-07-21 171258" src="https://github.com/user-attachments/assets/4fdc9e94-e840-4521-8d37-a77e637db3ba" />
<img width="1920" height="1080" alt="Screenshot 2026-07-21 171355" src="https://github.com/user-attachments/assets/e139a133-96e1-4c57-a90c-a4d8585e4ba1" />
<img width="1920" height="1080" alt="Screenshot 2026-07-21 171421" src="https://github.com/user-attachments/assets/603c2881-f237-470c-9983-0f61f96b4dba" />



---

## 🎯 Project Workflow

```
Login
   │
   ▼
Dashboard
   │
   ├── Reservation
   │      │
   │      ▼
   │  Book Ticket
   │      │
   │      ▼
   │  Generate PNR
   │
   └── Cancellation
          │
          ▼
     Search by PNR
          │
          ▼
     Cancel Reservation
```

---

## 📚 Concepts Used

- Java Swing
- Object-Oriented Programming (OOP)
- JDBC
- MySQL
- Event Handling
- Exception Handling
- GUI Development

---

## ⭐ Future Enhancements

- User Registration
- Seat Availability
- Ticket Printing (PDF)
- Email Confirmation
- Improved UI Design

---
## 👩‍💻 Author

**Swamini Satish Bhandare**

---
## 📄 License

This project is created for learning purposes as part of  Internship.
If you found this useful, consider giving it a ⭐ on GitHub.
