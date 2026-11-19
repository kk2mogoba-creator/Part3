/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */

    import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    
    
 
    static ArrayList<Message> sentMessages = new ArrayList<>();
    static ArrayList<Message> disregardedMessages = new ArrayList<>();
    static ArrayList<Message> storedMessages = new ArrayList<>();
    static ArrayList<String> messageHashes = new ArrayList<>();
    static ArrayList<String> messageIDs = new ArrayList<>();

    public static void main(String[] args) {
      
        populateTestData();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");
            System.out.println("4. Stored Messages"); 
            System.out.print("Choose an option: ");
            
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Feature to send messages goes here.");
                    break;
                case "2":
                    System.out.println("Coming Soon.");
                    break;
                case "3":
                    running = false;
                    System.out.println("Exiting application...");
                    break;
                case "4":
                    storedMessagesMenu(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

   
    private static void populateTestData() {
        // Test Data Message 1
        Message msg1 = new Message("0838884567", 1, "+27834557896", "Did you get the cake?", "Sent");
        sentMessages.add(msg1);
        messageHashes.add(msg1.getMessageHash());
        messageIDs.add(msg1.getMessageID());

        // Test Data Message 2
        Message msg2 = new Message("0838884567", 2, "+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        storedMessages.add(msg2);
        messageHashes.add(msg2.getMessageHash());
        messageIDs.add(msg2.getMessageID());

        // Test Data Message 3
        Message msg3 = new Message("0838884567", 3, "+27834484567", "Yohoooo, I am at your gate.", "Disregard");
        disregardedMessages.add(msg3);
        messageHashes.add(msg3.getMessageHash());
        messageIDs.add(msg3.getMessageID());

        // Test Data Message 4
        Message msg4 = new Message("0838884567", 4, "0838884567", "It is dinner time!", "Sent"); 
        sentMessages.add(msg4);
        messageHashes.add(msg4.getMessageHash());
        messageIDs.add(msg4.getMessageID());

        // Test Data Message 5
        Message msg5 = new Message("0838884567", 5, "+27838884567", "Ok, I am leaving without you.", "Stored");
        storedMessages.add(msg5);
        messageHashes.add(msg5.getMessageHash());
        messageIDs.add(msg5.getMessageID());
    }

    //(Options a to f)
    private static void storedMessagesMenu(Scanner scanner) {
        boolean inMenu = true;
        while (inMenu) {
            System.out.println("\n--- Stored Messages Menu ---");
            System.out.println("a. Display the sender and recipient of all stored messages");
            System.out.println("b. Display the longest stored message");
            System.out.println("c. Search for a message ID and display the corresponding recipient and message");
            System.out.println("d. Search for all the messages stored for a particular recipient");
            System.out.println("e. Delete a message using the message hash");
            System.out.println("f. Display a report that lists the full details of all the stored messages");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose: ");
            
            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "a":
                    displaySenderAndRecipient();
                    break;
                case "b":
                    displayLongestMessage();
                    break;
                case "c":
                    System.out.print("Enter Message ID: ");
                    searchByID(scanner.nextLine());
                    break;
                case "d":
                    System.out.print("Enter Recipient number: ");
                    searchByRecipient(scanner.nextLine());
                    break;
                case "e":
                    System.out.print("Enter Message Hash to delete: ");
                    deleteByHash(scanner.nextLine());
                    break;
                case "f":
                    displayReport();
                    break;
                case "0":
                    inMenu = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a-f or 0.");
            }
        }
    }


    // Option A: Display sender and recipient of all stored messages
    private static void displaySenderAndRecipient() {
        if (storedMessages.isEmpty()) {
            System.out.println("No stored messages.");
            return;
        }
        System.out.println("\n--- Stored Messages: Recipients ---");
        for (Message msg : storedMessages) {
         
            System.out.println("Sender: User | Recipient: " + msg.getRecipient());
        }
    }

    // Option B: Display the longest stored message
    private static void displayLongestMessage() {
        if (storedMessages.isEmpty()) {
            System.out.println("No stored messages.");
            return;
        }
        Message longest = storedMessages.get(0);
        for (Message msg : storedMessages) {
            if (msg.getMessageText().length() > longest.getMessageText().length()) {
                longest = msg;
            }
        }
        System.out.println("\n--- Longest Stored Message ---");
        System.out.println("Recipient: " + longest.getRecipient());
        System.out.println("Message: \"" + longest.getMessageText() + "\"");
    }

    // Option C: Search for a message ID
    private static void searchByID(String id) {
        boolean found = false;
        for (Message msg : storedMessages) {
            if (msg.getMessageID().equals(id)) {
                System.out.println("\n--- Message Found ---");
                System.out.println("Recipient: " + msg.getRecipient());
                System.out.println("Message: " + msg.getMessageText());
                found = true;
                break; 
            }
        }
        if (!found) System.out.println("Message ID not found.");
    }

    // Option D: Search for all messages for a particular recipient
    private static void searchByRecipient(String recipient) {
        boolean found = false;
        System.out.println("\n--- Messages for " + recipient + " ---");
        for (Message msg : storedMessages) {
            if (msg.getRecipient().equals(recipient)) {
                System.out.println("- " + msg.getMessageText());
                found = true;
            }
        }
        if (!found) System.out.println("No messages found for this recipient.");
    }

    // Option E: Delete a message using the message hash
    private static void deleteByHash(String hash) {
        
        Iterator<Message> iterator = storedMessages.iterator();
        boolean found = false;
        
        while (iterator.hasNext()) {
            Message msg = iterator.next();
            if (msg.getMessageHash().equalsIgnoreCase(hash)) {
                System.out.println("\nMessage: \"" + msg.getMessageText() + "\" successfully deleted.");
                iterator.remove();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Message hash not found.");
    }

    // Option F: Display a full report of stored messages
    private static void displayReport() {
        if (storedMessages.isEmpty()) {
            System.out.println("No stored messages to report.");
            return;
        }
        System.out.println("\n--- Full Stored Messages Report ---");
        for (Message msg : storedMessages) {
            System.out.println("Message Hash : " + msg.getMessageHash());
            System.out.println("Recipient    : " + msg.getRecipient());
            System.out.println("Message      : " + msg.getMessageText());
            System.out.println("-----------------------------------");
        }
    }
}
    

