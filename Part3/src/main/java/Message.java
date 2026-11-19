/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


public class Message {
    
    
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    private String flag;

   
    public Message(String messageID, int messageNumber, String recipient, String messageText, String flag) {
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.flag = flag;
        this.messageHash = createMessageHash();
    }


    public String getMessageID() { return messageID; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public String getMessageHash() { return messageHash; }
    public String getFlag() { return flag; }

    
    public String createMessageHash() {
        if (messageText == null || messageText.isEmpty()) {
            return "";
        }
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
      
        return (messageID.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }
}
    

