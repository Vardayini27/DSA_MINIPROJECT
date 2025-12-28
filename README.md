# SmartSplit

## Overview

SmartSplit is a Java-based command-line application designed to manage contacts, groups, transactions, and trips using core object-oriented programming principles and fundamental data structures. The project demonstrates how standard data structures such as Binary Search Trees, HashMaps, and Lists can be applied to build a structured, real-world information management system.

The application provides an interactive menu-driven interface and focuses on efficient data organization, retrieval, and logical separation of responsibilities across components.

---

## Features

### Contact Management

* Add new contacts with name, phone number, and email
* Search contacts efficiently by name
* Display all contacts in alphabetical order using a Binary Search Tree

### Group Management

* Create and manage groups
* Add contacts to groups
* Record transactions associated with groups or individual members
* Track transaction details including amount, direction, purpose, and completion status
* View group members and transaction history

### Trip Management

* Create trips with destinations and participants
* Display participants for a specific trip
* Organize shared expenses and associations within trips

### Transaction Handling

* Log transactions for individuals or groups
* Update transaction status (completed or pending)

---

## Technologies Used

* Java (Standard Library)
* Object-Oriented Programming principles (classes, encapsulation)
* Data Structures:

  * Binary Search Tree (BST)
  * HashMap
  * ArrayList

---

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/Vardayini27/DSA_MINIPROJECT.git
```

2. Compile the application:

```bash
javac Main.java
```

3. Run the program:

```bash
java Main
```

Follow the interactive menu to manage contacts, groups, transactions, and trips.

---

## Project Structure

* `Main.java`
  Entry point of the application and menu controller

* `ContactBST`
  Manages contact storage, search, and alphabetical display using a Binary Search Tree

* `GroupManager`
  Handles group creation, membership management, and group-based transactions

* `TripManager`
  Manages trip creation and participant tracking

* `Transaction`
  Represents a financial transaction with associated metadata

---

## Example Usage

* Add contacts and organize them into groups
* Record shared expenses or individual payments
* Track group transactions and mark them as completed
* Create trips and manage participant lists

---

## Project Highlights

* Practical application of core data structures
* Clear object-oriented design and modular code organization
* Efficient contact searching and ordered display using BST
* Suitable for academic coursework and data structure demonstrations

Just tell me.
