package Java.SocketPrograms;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("127.0.0.1", 888); // Replace with the server's IP

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.print("Enter a message for the server: ");
                String message = consoleInput.readLine();
                out.println(message);

                String response = in.readLine();
                System.out.println("Received from server: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
