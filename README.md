# ATM Management System

This is a basic Java-based ATM management system that simulates banking operations such as:

- User Login
- Balance Checking
- Cash Withdrawal
- Cash Deposit
- PIN Change
- Admin Operations (Add User, Delete User, View Transactions)

## Project Structure:
- **Account Class:** Manages user accounts with getters, setters, and basic data storage.
- **Transaction Class:** Records transactions with details like type, user, and amount.
- **ATM Class:** The core ATM logic managing user lists, admin lists, and notes.
- **Actions Class:** Handles user and admin actions for the ATM operations.
- **Notes Class:** Represents different denominations and their counts.
- **Admin Action & User Action Classes:** Specific actions available for admin and users, including deposit and withdrawal operations.

## Future Enhancements (Ideas for Contributors):
- [ ] Implement a database backend for account storage instead of in-memory storage.
- [ ] Add support for multi-factor authentication (MFA).
- [ ] Enhance the UI with a graphical interface using Java Swing.
- [ ] Implement exception handling for secure transaction management.
- [ ] Add a feature for printing transaction receipts.
- [ ] Create a test suite using JUnit for better testing coverage.
- [ ] Improve security by encrypting user PINs using hashing algorithms.

## Getting Started:
1. Clone the repository:  
