SmartSplit
A Java-based command-line application for managing contacts, groups, transactions, and trips using fundamental data structures and OOP concepts. This project demonstrates practical usage of Binary Search Trees, HashMaps, and Lists to build a real-world information management system.

Features
Contact Management

Add new contacts with name, phone number, and email.
Search for contacts by name.
Display all contacts in alphabetical order (implemented using a Binary Search Tree).
Group Management

Create groups and add contacts to them.
Record transactions associated with groups or individuals (including amount, direction, purpose, and completion status).
Display group details, including members and transaction history.
Trip Management

Add new trips with destinations and participants.
Display participants for a specific trip.
Transaction Handling

Log transactions for individuals or groups.
Mark transactions as completed.
Technologies Used
Java Standard Library
OOP Principles (Classes, Encapsulation)
Data Structures: Binary Search Tree (BST), HashMap, ArrayList
How to Run
Clone the repository:

Code
git clone https://github.com/Vardayini27/DSA_MINIPROJECT.git
Compile the Java code:

Code
javac Main.java
Run the application:

Code
java Main
Follow the interactive menu to manage contacts, groups, and trips.

Project Structure
Main.java — Main application file containing all logic.
ContactBST: Manages contacts using a BST for efficient search and display.
GroupManager: Handles groups, group membership, and group transactions.
TripManager: Manages trips and their participants.
Transaction: Represents a financial transaction with metadata.
Example Usage
Add contacts, then create a group and add members.
Log transactions for group events or individual payments.
Organize and track trip details and participants.
