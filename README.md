# Quiz Quest - Java Quiz Application 🎯
Quiz Quest is an interactive Java-based quiz application built with Swing and AWT. It features a profile system, leaderboard, and quiz history to track user progress. This project was developed as part of Project-Based Learning (PBL) for CSE Skill Lab V by a team of four members.

## Team Members

1. [Kritansh Tank](https://github.com/Kritansh-Tank) - PRN: 2143110058, Roll No: 07 
2. [Ujjwal Singh](https://github.com/Kritansh-Tank) - PRN: 2143110035, Roll No: 08
3. [Mitali Chaudhari](https://github.com/Kritansh-Tank) - PRN: 2143110046, Roll No: 09
4. [Rohan Singh](https://github.com/Kritansh-Tank) - PRN: 2143110044, Roll No: 10

## Project Implementation

1. Software Used: NetBeans IDE
2. Implemented: 7 JFrame Pages
3. Concepts Covered: JDBC, AWT, Swingx

## Features 🚀

1. ✅ Leaderboard System (Stores top scores using MySQL)
2. ✅ User Profile System (Stores age, email, and contact)
3. ✅ Quiz History (Tracks past scores)
4. ✅ 50-50 Lifeline (Removes two incorrect options)

## Installation & Setup 💻

### 1️⃣ Prerequisites

#### Ensure you have:

1. Java JDK (11 or higher)
2. MySQL Database (via XAMPP or MySQL Server)
3. json.jar for JSON parsing

### 2️⃣ Database Setup (MySQL) 📂

#### Run the following SQL commands in MySQL to set up the database:

``` 
CREATE DATABASE quizdb;
USE quizdb;

CREATE TABLE leaderboard (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    score INT NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(100) NOT NULL,
    contact VARCHAR(15) NOT NULL
);
```

### 3️⃣ Project Setup 🛠️

#### For NetBeans

1. Open NetBeans → File → Open Project → Select Folder.
2. Right-click the project → Properties → Libraries → Add JAR/Folder.
3. Select json.jar and click OK.
4. Run Login.java.

## Screenshots 📸

### 🎮 Login Page

![Login Page](https://drive.google.com/uc?id=1HPRwcezdObM0z3ebSfi13hzTzQZaWmHW)

### ❓ Quiz Interface

![Quiz Interface](https://drive.google.com/uc?id=1gfNDfe7OhKRTQoNTKehcdYkldHcUbn15)

### 🏆 Leaderboard

![Leaderboard](https://drive.google.com/uc?id=145K14IyS8Z_rPYA49iBImQPPq3B3GE6E)

## License 📚

This project is open-source under the MIT License.
