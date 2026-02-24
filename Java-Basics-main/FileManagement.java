package Java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManagement {
    public static void main(String[] args) {
        // Prompt the user for the file path
        String filePath = getUserInput("Enter the file path: ");

        try {
            // Attempt to open and read the file
            readFile(filePath);
        } catch (IOException e) {
            // Handle and report file-related errors
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    // Method to read and display the contents of the file
    private static void readFile(String filePath) throws IOException {
        // Attempt to open the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("File contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Re-throw the exception to be handled by the calling method
            throw new IOException("Error reading the file: " + e.getMessage());
        }
    }

    // Method to get user input
    private static String getUserInput(String prompt) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
