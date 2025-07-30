import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

class Contact {
    long mobileNumber;
    String name;
    String email;

    public Contact(long number, String name, String email) {
        this.mobileNumber = number;
        this.name = name;
        this.email = email;
    }

    void display() {
        System.out.println("\tName: " + name +
                         "\n\tMobile Number: " + mobileNumber +
                         "\n\tEmail: " + email);
    }

    String getName() {
        return name;
    }
}

class ContactNode {
    ContactNode left, right;
    Contact contact;

    ContactNode(Contact contact) {
        this.left = null;
        this.right = null;
        this.contact = contact;
    }
}

class ContactBST {
    ContactNode root;
    Scanner sc = new Scanner(System.in);

    public void insertContact() {
        boolean flag = true;
        while (flag) {
            System.out.print("Enter Contact Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Phone Number: ");
            long phoneNumber = Long.parseLong(sc.nextLine());
            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            Contact newContact = new Contact(phoneNumber, name, email);
            ContactNode newNode = new ContactNode(newContact);

            if (root == null) {
                root = newNode;
                System.out.println("Contact inserted!");
            } else {
                ContactNode current = root;
                while (true) {
                    if (name.compareToIgnoreCase(current.contact.name) < 0) {
                        if (current.left == null) {
                            current.left = newNode;
                            System.out.println("Contact inserted!");
                            break;
                        }
                        current = current.left;
                    } else if (name.compareToIgnoreCase(current.contact.name) > 0) {
                        if (current.right == null) {
                            current.right = newNode;
                            System.out.println("Contact inserted!");
                            break;
                        }
                        current = current.right;
                    } else {
                        System.out.println("Contact name already exists!");
                        break;
                    }
                }
            }
            System.out.print("Enter more? 0:no or 1:yes? ");
            int t = sc.nextInt();
            sc.nextLine(); // clear buffer
            if (t == 0) {
                flag = false;
            }
            System.out.println();
        }
    }

    public Contact search(String name) {
        ContactNode current = root;
        while (current != null) {
            if (name.equalsIgnoreCase(current.contact.name)) {
                return current.contact;
            }
            current = name.compareToIgnoreCase(current.contact.name) < 0 ? current.left : current.right;
        }
        return null;
    }

    public void displayAllContacts() {
        if (root == null) {
            System.out.println("No contacts in the directory.");
        } else {
            System.out.println("Contacts:");
            inOrderTraversal(root);
        }
    }

    private void inOrderTraversal(ContactNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            node.contact.display();
            inOrderTraversal(node.right);
        }
    }
}

class Transaction {
    String name;
    LocalDate date;
    LocalTime time;
    boolean paymentDone;
    String purpose;
    double amount;
    String transactionType;
    String groupName;
    String direction;

    public Transaction(String name, double amount, String transactionType,
                      String groupName, String direction, String purpose) {
        this.name = name;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.paymentDone = false;
        this.purpose = purpose;
        this.amount = amount;
        this.transactionType = transactionType;
        this.groupName = transactionType.equals("group") ? groupName : null;
        this.direction = direction;
    }

    public void displayTransactionDetails() {
        System.out.println("Transaction Details:");
        System.out.println("Name: " + name);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Type: " + transactionType);
        System.out.println("Group: " + (groupName == null ? "N/A" : groupName));
        System.out.println("Direction: " + direction);
        System.out.println("Payment Done: " + (paymentDone ? "Yes" : "No"));
        System.out.println("Purpose: " + purpose);
    }

    public void markAsDone() {
        this.paymentDone = true;
        System.out.println("Transaction marked as done.");
    }
}

class Group {
    String name;
    List<Contact> contacts;
    List<Transaction> transactions;

    public Group(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void displayGroup() {
        System.out.println("Group: " + name);
        System.out.println("Members:");
        for (Contact contact : contacts) {
            System.out.println("- " + contact.getName());
        }
        System.out.println("\nTransactions:");
        for (Transaction t : transactions) {
            t.displayTransactionDetails();
            System.out.println();
        }
    }
}

class GroupManager {
    private ContactBST contactBST;
    private Map<String, Group> groups;
    private Scanner sc;

    public GroupManager(ContactBST contactBST) {
        this.contactBST = contactBST;
        this.groups = new HashMap<>();
        this.sc = new Scanner(System.in);
    }

    public void addGroup() {
        System.out.print("Enter group name: ");
        String groupName = sc.nextLine();
        groups.put(groupName, new Group(groupName));
        System.out.println("Group '" + groupName + "' created.");
    }

    public void addContactToGroup() {
        System.out.print("Enter group name: ");
        String groupName = sc.nextLine();
        Group group = groups.get(groupName);

        if (group == null) {
            System.out.println("Group not found!");
            return;
        }

        System.out.print("Enter contact name: ");
        String contactName = sc.nextLine();
        Contact contact = contactBST.search(contactName);

        if (contact == null) {
            System.out.println("Contact not found!");
            return;
        }

        group.addContact(contact);
        System.out.println("Contact added to group.");
    }

    public void handleTransactions() {
        System.out.print("Enter group name: ");
        String groupName = sc.nextLine();
        Group group = groups.get(groupName);

        if (group == null) {
            System.out.println("Group not found!");
            return;
        }

        System.out.print("Enter transaction name: ");
        String name = sc.nextLine();
        System.out.print("Enter amount: ");
        double amount = Double.parseDouble(sc.nextLine());
        System.out.print("Enter type (group/singular): ");
        String type = sc.nextLine();
        System.out.print("Enter direction (incoming/outgoing): ");
        String direction = sc.nextLine();
        System.out.print("Enter purpose: ");
        String purpose = sc.nextLine();

        Transaction transaction = new Transaction(name, amount, type, groupName, direction, purpose);
        group.addTransaction(transaction);
        System.out.println("Transaction added.");
    }

    public void displayGroup() {
        System.out.print("Enter group name: ");
        String groupName = sc.nextLine();
        Group group = groups.get(groupName);

        if (group == null) {
            System.out.println("Group not found!");
            return;
        }

        group.displayGroup();
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\nGROUP MANAGER MENU:");
            System.out.println("1. Add Group");
            System.out.println("2. Add Contact to Group");
            System.out.println("3. Add Transaction");
            System.out.println("4. Display Group");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addGroup();
                case 2 -> addContactToGroup();
                case 3 -> handleTransactions();
                case 4 -> displayGroup();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}

class TripManager {
    private Map<String, List<String>> trips;
    private Scanner sc;

    public TripManager() {
        this.trips = new HashMap<>();
        this.sc = new Scanner(System.in);
    }

    public void addTrip() {
        System.out.print("Enter destination: ");
        String destination = sc.nextLine();
        System.out.print("Enter participants (comma separated): ");
        String[] participants = sc.nextLine().split(",");

        List<String> participantList = new ArrayList<>();
        for (String p : participants) {
            participantList.add(p.trim());
        }

        trips.put(destination, participantList);
        System.out.println("Trip added.");
    }

    public void displayTrip() {
        System.out.print("Enter destination: ");
        String destination = sc.nextLine();
        List<String> participants = trips.get(destination);

        if (participants == null) {
            System.out.println("Trip not found!");
            return;
        }

        System.out.println("Trip to " + destination + ":");
        for (String p : participants) {
            System.out.println("- " + p);
        }
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\nTRIP MANAGER MENU:");
            System.out.println("1. Add Trip");
            System.out.println("2. Display Trip");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addTrip();
                case 2 -> displayTrip();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}

public class Main {
    public static void main(String[] args) {
        ContactBST contactBST = new ContactBST();
        GroupManager groupManager = new GroupManager(contactBST);
        TripManager tripManager = new TripManager();
        Scanner sc = new Scanner(System.in);

        int mainChoice;
        do {
            System.out.println("\nMAIN MENU:");
            System.out.println("1. Contact Management");
            System.out.println("2. Group Management");
            System.out.println("3. Trip Management");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            mainChoice = sc.nextInt();
            sc.nextLine();

            switch (mainChoice) {
                case 1 -> {
                    System.out.println("\nCONTACT MANAGEMENT");
                    System.out.println("1. Add Contact");
                    System.out.println("2. Search Contact");
                    System.out.println("3. Display All Contacts");
                    System.out.print("Enter choice: ");
                    int contactChoice = sc.nextInt();
                    sc.nextLine();

                    switch (contactChoice) {
                        case 1 -> contactBST.insertContact();
                        case 2 -> {
                            System.out.print("Enter name to search: ");
                            String name = sc.nextLine();
                            Contact contact = contactBST.search(name);
                            if (contact != null) {
                                contact.display();
                            } else {
                                System.out.println("Contact not found!");
                            }
                        }
                        case 3 -> contactBST.displayAllContacts();
                        default -> System.out.println("Invalid choice!");
                    }
                }
                case 2 -> groupManager.menu();
                case 3 -> tripManager.menu();
                case 0 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice!");
            }
        } while (mainChoice != 0);
    }
}