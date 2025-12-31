# Quiz Quest - Java Quiz Application
Quiz Quest is an interactive Java-based quiz application built with Swing and AWT. It features a profile system, leaderboard, and quiz history to track user progress.

## Project Details

1. Software Used: NetBeans IDE
2. Implemented: 7 JFrame Pages
3. Concepts Covered: JDBC, AWT, Swing

## Features

1. Leaderboard System (Stores top scores using MySQL)
2. User Profile System (Stores age, email, and contact)
3. Quiz History (Tracks past scores)
4. 50-50 Lifeline (Removes two incorrect options)

## Purpose of Each Page

### 1️⃣ Login.java (User Authentication Page)
1. Purpose: This is the entry point of the quiz application where users enter their name to start the quiz.
2. Key Features:
    1. Allows users to enter their name.
    2. Provides buttons to navigate to rules, leaderboard, or exit the application.

### 2️⃣ Profile.java (User Profile Page)
1. Purpose: This page collects additional user details like age, email, and contact number before starting the quiz.
2. Key Features:
    1. Takes name, age, email, and contact number as input.
    2. Stores user data in the MySQL database using JDBC.
    3. Redirects users to the Rules page after saving the profile.

### 3️⃣ Rules.java (Quiz Instructions Page)
1. Purpose: Displays the quiz rules and guidelines before users start the quiz.
2. Key Features:
    1. Lists important quiz rules like time limits and scoring.
    2. Provides a "Start Quiz" button to begin the quiz.

### 4️⃣ Quiz.java (Main Quiz Page)
1. Purpose: This is the core quiz interface where users answer multiple-choice questions.
2. Key Features:
    1. Displays questions and four options dynamically.
    2. Implements a timer for each question.
    3. Provides navigation buttons:
        - Next → Moves to the next question.
        - 50-50 Lifeline → Removes two incorrect options.
        - Submit → Finishes the quiz and redirects to the Score page.

### 5️⃣ Score.java (Results Page)
1. Purpose: Displays the final quiz score after the user submits their answers.
2. Key Features:
    1. Shows a thank you message along with the final score.
    2. Provides a "Play Again" button to restart the quiz.
    3. Saves the score in the MySQL leaderboard database using JDBC.

### 6️⃣ Leaderboard.java (Top Scores Page)
1. Purpose: Displays the top 10 highest scores from the database.
2. Key Features:
    1. Fetches and displays the top 10 highest scores from MySQL.
    2. Includes a text field where users can enter their name to check their quiz history.
    3. Provides a "View Quiz History" button to check past scores.

### 7️⃣ QuizHistory.java (User's Past Quiz Scores)
1. Purpose: Shows a history of previous quiz scores for a specific user.
2. Key Features:
    1. Fetches all past scores from MySQL for the entered username.
    2. Displays scores in a scrollable text area.
    3. Provides a "Back" button to return to the Leaderboard page.

## Installation & Setup

### 1️⃣ Prerequisites

#### Ensure you have:

1. Java JDK (11 or higher)
2. MySQL Database (via XAMPP or MySQL Server)
3. json.jar for JSON parsing

### 2️⃣ Database Setup (MySQL) 

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

### 3️⃣ Project Setup 

#### For NetBeans

1. Open NetBeans → File → Open Project → Select Folder
2. Right-click the project → Properties → Libraries → Add JAR/Folder
3. Select json.jar and click OK
4. Run Login.java
