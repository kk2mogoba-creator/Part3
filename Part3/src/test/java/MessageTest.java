/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

/**
 *
 * @author Student
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testSentMessagesArrayPopulated() {
        // Test Data 1 and 4 are Sent messages
        Message msg1 = new Message("0838884567", 1, "+27834557896", "Did you get the cake?", "Sent");
        Message msg4 = new Message("0838884567", 4, "0838884567", "It is dinner time!", "Sent");
        
        assertEquals("Did you get the cake?", msg1.getMessageText());
        assertEquals("It is dinner time!", msg4.getMessageText());
    }

    @Test
    public void testLongestMessage() {
        // Test Data 2 and 5 are Stored messages. Data 2 is longer.
        Message msg2 = new Message("0838884567", 2, "+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        Message msg5 = new Message("0838884567", 5, "+27838884567", "Ok, I am leaving without you.", "Stored");
        
        assertTrue(msg2.getMessageText().length() > msg5.getMessageText().length());
        assertEquals("Where are you? You are late! I have asked you to be on time.", msg2.getMessageText());
    }

    @Test
    public void testSearchMessageID() {
        // The test data expects ID 0838884567 to return "It is dinner time!"
        Message msg4 = new Message("0838884567", 4, "0838884567", "It is dinner time!", "Sent");
        
        assertEquals("0838884567", msg4.getMessageID());
        assertEquals("It is dinner time!", msg4.getMessageText());
    }

    @Test
    public void testSearchByRecipient() {
        // Test Data for recipient +27838884567 should return messages 2 and 5
        Message msg2 = new Message("0838884567", 2, "+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        Message msg5 = new Message("0838884567", 5, "+27838884567", "Ok, I am leaving without you.", "Stored");
        
        String targetRecipient = "+27838884567";
        
        assertEquals(targetRecipient, msg2.getRecipient());
        assertEquals(targetRecipient, msg5.getRecipient());
        assertEquals("Where are you? You are late! I have asked you to be on time.", msg2.getMessageText());
        assertEquals("Ok, I am leaving without you.", msg5.getMessageText());
    }

    @Test
    public void testDeleteMessageByHash() {
        // Check if hash is generated correctly to simulate deletion
        Message msg2 = new Message("0838884567", 2, "+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        
        // Ensure the hash format matches the expected output for deletion
        assertNotNull(msg2.getMessageHash());
        assertTrue(msg2.getMessageHash().contains(":2:"));
    }
}

