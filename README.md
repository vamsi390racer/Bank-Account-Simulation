# Bank-Account-Simulation
Java OOP simulation of basic bank operations. Includes the Account class for encapsulation, managing balance, deposits, withdrawals (with checks for insufficient funds), and maintaining a detailed, timestamped transaction history
Java Developer Internship - Task 5: Bank Account Simulation
This repository contains the solution for Task 5, which involves simulating basic banking operations using Object-Oriented Programming (OOP) principles in Java.

🚀 Project Objective
The primary goal of this task was to design a robust Account class to manage funds, deposits, and withdrawals while adhering to core OOP concepts like Encapsulation.

✨ Key Features Implemented
The Account class and the BankSimulation driver class collectively demonstrate the following functionalities:

Encapsulation: The account balance (balance) is kept private, accessible only through controlled public methods (deposit, withdraw, getBalance).

Deposit: Allows funds to be added to the account. Includes validation to ensure the deposited amount is positive.

Withdrawal: Allows funds to be subtracted from the account. Includes checks for Insufficient Funds to prevent overdrafts.

Balance Inquiry: A method to retrieve the current account balance.

Transaction History: A detailed history of every deposit and withdrawal, including timestamps and the resulting new balance, is maintained and can be printed.

⚙️ How to Run the Project
Prerequisites
Java Development Kit (JDK) installed (version 8 or higher).

A text editor or IDE (like VS Code, IntelliJ, or Eclipse).

Execution Steps
Save the file: Save the provided code as BankSimulation.java.

Compile: Open your terminal or command prompt in the directory where you saved the file and compile the Java code:

javac BankSimulation.java

Run: Execute the compiled class file to start the simulation:

java BankSimulation

The console output will display the account creation, deposits, a successful withdrawal, and an attempt at an insufficient funds withdrawal, followed by the complete transaction history.

💡 Demonstrated OOP Concepts
This project directly applies several key OOP concepts:

Classes & Objects: Defines the Account class blueprint and creates instances (objects) of it.

Encapsulation: Protecting the internal state (private double balance;) and exposing functionality via public methods.

Data Structures: Using java.util.List (ArrayList) to maintain the transaction history.
