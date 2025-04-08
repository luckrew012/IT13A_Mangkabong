
package midterm;

import java.io.FileWriter;
import java.io.IOException;

public class EncryptFileHandling {
  
    public static void main(String[] args) throws IOException {
        FileWriter myWriter = new FileWriter("C:\\Users\\bmang\\OneDrive\\Documents\\File Handling.txt");
        int key = 6;
        String message = "I love you!\nGwapa ko!\nBuotan si Ma'am.";
        String encryptedMessage = encryptMessage(message, key);
        myWriter.write(encryptedMessage);
        
        myWriter.close();
        System.out.println("Succesfully wrote to the file.");
        System.out.println(encryptedMessage);
    }
    public static String encryptMessage(String message, int key){
        char[] chars = message.toCharArray();
        for (int i=0; i < chars.length; i++){
            if (chars[i] != '\n') {
                chars[i] += key;
            }

        }
      return new String(chars);
    }

}
    

