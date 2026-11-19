This repository contains the completed Java console application for PROG5121 Part 3: Store Data and Display Task Report.
Developed using Object-Oriented Programming principles, the application features a dedicated Message class to
encapsulate data attributes such as the message ID, recipient, text, and flag, while utilizing dynamic ArrayList data structures
to efficiently manage the sent, disregarded, and stored message collections. The core logic demonstrates a strong grasp of string 
manipulation through the createMessageHash() method, which splits text to generate a unique identifier, as well as the safe use of Java Iterators to prevent 
ConcurrentModificationExceptions when executing the message deletion feature via hash. 
The application includes a fully functional console menu system that seamlessly handles the required test data and allows users to search for specific messages,
identify the longest stored message, and generate comprehensive reports. 
To ensure robust performance and accurate logic, JUnit tests were integrated to verify the exact expected outputs for array population, longest message
identification, and search functionalities. This project demonstrates a solid foundational understanding of core Java concepts, including data structures, string 
handling, control flow, and unit testing, culminating in a fully functional, console-based messaging management system.
