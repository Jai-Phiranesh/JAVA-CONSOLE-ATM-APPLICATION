# ATM Management System

## Overview
A Java-based terminal application for ATM Management System. This project demonstrates core OOP concepts,and user authentication in a console environment.
The ATM management system that simulates banking operations such as:

- User Login
- Balance Checking
- Cash Withdrawal
- Cash Deposit
- PIN Change
- Admin Operations (Add User, Delete User, View Transactions,Add Cash In ATM)

## Project Structure:
![Atm class structure](https://github.com/user-attachments/assets/ff90830e-3fc5-4b54-b3a7-6bf923ddbb38)

- **Account Class:** Manages user accounts with getters, setters, and basic data storage.
- **Transaction Class:** Records transactions with details like type, user, and amount.
- **ATMActions Class:** The core ATM logic managing user lists, admin lists, and notes.
- **Actions Class:** Handles user and admin actions for the ATM operations.
- **Notes Class:** Represents different denominations and their counts.
- **Admin Action & User Action Classes:** Specific actions available for admin and users, including deposit and withdrawal operations.

## Console Execution


https://github.com/user-attachments/assets/c1d030f5-7d68-4b17-a031-714872b20f77



## Future Enhancements (Ideas for Contributors):
- [ ] Implement a database backend for account storage instead of in-memory storage.
- [ ] Enhance the UI with a graphical interface using Java Swing.
- [ ] Implement exception handling for secure transaction management.
- [ ] Improve security by encrypting user PINs using hashing algorithms.

## Getting Started

### Prerequisites
* Java Development Kit (JDK) 11+
* Command Line Interface
* Git


Clone the repository:
```bash
git clone https://github.com/Jai-Phiranesh/JAVA-CONSOLE-ATM-APPLICATION
```

Change Directory
```bash
cd ATM
```
Compile the Main File
```bash
javac Tester.java
```
Run in the Terminal
```bash
java Tester
```

