# Banking Management System
## Overview
The Banking Management System is a Java-based application built using AWT and Swing for the GUI and MySQL for database management. This system provides an ATM-like interface where users can create accounts, log in securely, and perform essential banking operations such as deposits, withdrawals, fund transfers, PIN changes, balance inquiries, and mini-statements.

## Features
User Authentication: Secure login using a unique card number and password.

Account Creation: New users can sign up and create an account.

ATM-Like Interface:

Deposit: Add money to the account.

Withdraw: Withdraw money with balance validation.

Transfer: Send money to another account.

PIN Change: Update account PIN securely.

Balance Inquiry: Check the available balance.

Mini Statement: View the last transaction details.

Transaction Logging: Each transaction is stored in the database with a timestamp.

## Technologies Used
Programming Language: Java

GUI Framework: AWT, Swing

Database: MySQL

## Database Schema
### Tables
1. account_services
2. account_statment
3. customer_amount
4. customer_personal_information
5. login

## Setup Instructions
### Prerequisites
Ensure you have the following installed:

Java Development Kit (JDK)

MySQL Database

IDE (Eclipse, IntelliJ IDEA, or NetBeans)

## Steps to Run
Clone the repository:
git clone https://github.com/Saikat04/Banking-Management-System

Import the project into your Java IDE.

Set up the MySQL database:

Create a database named banking_system.

Execute the SQL script provided in the repository to create tables.

Update database credentials in the Java code:
String url = "jdbc:mysql://localhost:3306/banking_management_system";
String user = "your_username";
String password = "your_password";

Compile and run the application


## Usage
Create an account or log in with an existing card number and password.

Use the ATM-like interface to perform banking transactions.

Transactions will be stored in the database and can be retrieved using the Mini Statement feature.

## Future Enhancements
Implementing a more secure authentication mechanism.

Adding email and SMS notifications for transactions.

Enhancing the UI with modern frameworks like JavaFX.



