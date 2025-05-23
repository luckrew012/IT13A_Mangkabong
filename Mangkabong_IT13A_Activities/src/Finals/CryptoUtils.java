/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Finals;

import java.io.BufferedReader;
import java.io.File;
//import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Base64;
//import java.util.Scanner;
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//import java.util.Base64;
//import static midterm.EncryptFileHandling.encryptMessage;

class CryptoUtils {
    private static final int SHIFT = 3;

    // Caesar cipher encryption
    public static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            encrypted.append((char) (c + SHIFT));
        }
        return encrypted.toString();
    }

    // Caesar cipher decryption
    public static String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            decrypted.append((char) (c - SHIFT));
        }
        return decrypted.toString();
    }

    // Check if username/password is valid
    public static boolean isValidLogin(File file, String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    String storedUser = parts[0];
                    String storedEncryptedPass = parts[1];
                    String decryptedPass = decrypt(storedEncryptedPass);

                    if (storedUser.equals(username) && decryptedPass.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
        }

        return false;
    }

    // Register user with encrypted password
    public static void registerUser(String username, String password) {
        try (FileWriter writer = new FileWriter("C:\\FREECOINGO!\\Users.txt", true)) {
            String encryptedPass = encrypt(password);
            writer.write(username + ":" + encryptedPass + System.lineSeparator());
        } catch (IOException e) {
        }
    }

    // Export decrypted user data to another file
    public static void exportDecryptedUsers(File encryptedFile, File outputFile) {
        try (
            BufferedReader reader = new BufferedReader(new FileReader(encryptedFile));
            FileWriter writer = new FileWriter(outputFile)
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    String username = parts[0];
                    String decryptedPass = decrypt(parts[1]);
                    writer.write(username + ":" + decryptedPass + System.lineSeparator());
                }
            }
            System.out.println("Decrypted users exported to " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Testing
    public static void main(String[] args) {
        // Register new user
        registerUser("testuser", "12345");

        // Validate login
        File loginFile = new File("C:\\FREECOINGO!\\Users.txt");
        boolean isValid = isValidLogin(loginFile, "testuser", "12345");
        System.out.println("Login valid: " + isValid);

        // Export decrypted file
        File decryptedOutput = new File("C:\\FREECOINGO!\\DecryptedUsers.txt");
        exportDecryptedUsers(loginFile, decryptedOutput);
    }
//    public static String encrypt(String input) {
//        return Base64.getEncoder().encodeToString(input.getBytes());
//    }
//
//    
//    public static String decrypt(String input) {
//        return new String(Base64.getDecoder().decode(input));
//    }
//
//    //SHIFT NATO KAY 2
//    public static boolean isValidLogin(File file, String username, String password) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(":", 2);
//                if (parts.length == 2) {
//                    String storedUser = parts[0];
//                    String storedEncryptedPass = parts[1];
//                    String decryptedPass = decrypt(storedEncryptedPass);
//
//                    if (storedUser.equals(username) && decryptedPass.equals(password)) {
//                        return true;
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//
//   //ENCRYPT
//    public static void registerUser(String username, String password) {
//        try (FileWriter writer = new FileWriter("C:\\FREECOINGO!\\Users.txt", true)) {
//            String encryptedPass = encrypt(password);
//            writer.write(username + ":" + encryptedPass + System.lineSeparator());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
////MAO NI DECRYPT
//
//    public static void exportDecryptedUsers(File encryptedFile, File outputFile) {
//        try (
//            BufferedReader reader = new BufferedReader(new FileReader(encryptedFile));
//            FileWriter writer = new FileWriter(outputFile)
//        ) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(":", 2);
//                if (parts.length == 2) {
//                    String username = parts[0];
//                    String decryptedPass = decrypt(parts[1]);
//                    writer.write(username + ":" + decryptedPass + System.lineSeparator());
//                }
//            }
//            System.out.println("Decrypted users exported to " + outputFile.getAbsolutePath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // Main method for testing
//    public static void main(String[] args) {
//        // Register new user
//        registerUser("testuser", "12345");
//
////       DIRINI KUHA SA LOGIN NGA VALIDATION
//        File loginFile = new File("C:\\FREECOINGO!\\Users.txt");
//        boolean isValid = isValidLogin(loginFile, "testuser", "12345");
//        System.out.println("Login valid: " + isValid);
//
//        // FILE SA DECRYPT
//        File decryptedOutput = new File("C:\\FREECOINGO!\\DecryptedUsers.txt");
//        exportDecryptedUsers(loginFile, decryptedOutput);
    }
 
    
//    public static String encrypt(String input) {
//    return Base64.getEncoder().encodeToString(input.getBytes());
//}
//
//public static String decrypt(String input) {
//    return new String(Base64.getDecoder().decode(input));
//}
//     public static boolean isValidLogin(File file, String username, String password) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(":", 2); 
//                if (parts.length == 2) {
//                    String storedUser = parts[0];
//                    String storedEncryptedPass = parts[1];
//                    String decryptedPass = decrypt(storedEncryptedPass); 
//
//                    if (storedUser.equals(username) && decryptedPass.equals(password)) {
//                        return true;
//                    }
//                }
//            }
//        } catch (IOException e) {
//        }
//
//        return false;
//    }
//
//    public static void registerUser(String username, String password) {
//        try (FileWriter writer = new FileWriter("C:\\FREECOINGO!\\Users.txt", true)) {
//            String encryptedPass = encrypt(password); // Use your actual encryption method
//            writer.write(username + ":" + encryptedPass + System.lineSeparator());
//        } catch (IOException e) {
//        }
//    }

    // Dummy methods for encryption/decryption (replace with real ones)
 

  
//            public static final int SHIFT = 1;
//    public static final String USER_FILE_PATH = "C:\\FREECOINGO!\\Users.txt";
//
//    // Save a new user to the file
//    
//
//    
//    
//    public static void registerUser(String username, String password) {
//        File file = new File("C:\\FREECOINGO!\\Users.txt");
//        String encryptedPassword = encryptCaesar(password, SHIFT);
//        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//
//        try (FileWriter writer = new FileWriter(USER_FILE_PATH, true)) {
//            writer.write("Username: " + username + "\n");
//            writer.write("Password: " + encryptedPassword + "\n");
//            writer.write("Registered at: " + time + "\n\n");
//        } catch (IOException e) {
//            System.out.println("Error writing to file: " + e.getMessage());
//        }
//    }
//
//    // Validate user login
//    public static boolean isValidLogin(String username, String password) {
//        String encrypted = encryptCaesar(password, SHIFT);
//        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE_PATH))) {
//            String line, fileUser = null, filePass = null;
//            while ((line = reader.readLine()) != null) {
//                if (line.startsWith("Username: ")) {
//                    fileUser = line.substring(10).trim();
//                } else if (line.startsWith("Password: ")) {
//                    filePass = line.substring(10).trim();
//                    if (fileUser != null && fileUser.equals(username) && filePass.equals(encrypted)) {
//                        return true;
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Login file error: " + e.getMessage());
//        }
//        return false;
//    }
//
//    // Caesar cipher encryption (demo only – not secure for real use)
//    public static String encryptCaesar(String text, int shift) {
//        StringBuilder result = new StringBuilder();
//        for (char ch : text.toCharArray()) {
//            if (Character.isLetter(ch)) {
//                char base = Character.isUpperCase(ch) ? 'A' : 'a';
//                result.append((char) ((ch - base + shift) % 26 + base));
//            } else if (Character.isDigit(ch)) {
//                result.append((char) ((ch - '0' + shift) % 10 + '0'));
//            } else {
//                result.append(ch); // keep special chars unchanged
//            }
//        }
//        return result.toString();
//    }
//
//    static boolean isValidLogin(File file, String newUser, String newPass) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//}
//    public static void main(String[] args) throws IOException {
//        FileWriter myWriter = new FileWriter("C:\\FREECOINGO!\\.txt");
//        int key = 0;
//        String message = "I love you!\nGwapa ko!\nBuotan si Ma'am.";
//        String encryptedMessage = encryptMessage(message, key);
//        myWriter.write(encryptedMessage);
//        
//        myWriter.close();
//        System.out.println("Succesfully wrote to the file.");
//        System.out.println(encryptedMessage);
//    }
//}
//    public static String encrypt(String strToEncrypt) {
//        try {
//            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");
//            Cipher cipher = Cipher.getInstance("C:\\FREECOINGO!\"");
//
//            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public static String decrypt(String strToDecrypt) {
//        try {
//            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
//
//            cipher.init(Cipher.DECRYPT_MODE, secretKey);
//            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
//        } catch (Exception e) {
//            return null;
//        }
//    }
//}
