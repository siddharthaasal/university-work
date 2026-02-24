package Java.Game;

import java.util.*;

public class magnet {
    static HashMap<String,Integer> hm = new HashMap<>();


    public static void fillGrid(String arr[][]) {
        int rows = 10, columns = 9;
        int n = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (n < 10) {
                    arr[i][j] = "0"+ String.valueOf(n);
                } else {
                    arr[i][j] = String.valueOf(n);
                }
                n++;
            }
        }
    }

    public static void displayGrid(String arr[][]) {
        int rows = 10, columns = 9;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(" " + arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static int whoseTurn(boolean turn) {
        if (turn == true) {
            return 1;
        } else {
            return 2;
        }
    }

    public static boolean gameEnd(int player1Magnets, int player2Magnets) {
        if (player1Magnets == 0) {
            System.out.println("Player 1 Won");
            return true; // game ended
        }
        if (player2Magnets == 0) {
            System.out.println("Player 2 Won");
            return true;
        }
        return false;

    }

    public static String[][] inputHandling(String arr[][], int turn, int input){
        if(Integer.valueOf(input)<0 || Integer.valueOf(input)>89){
            System.err.println("Wrong Input");
            return arr;
        }
        //valid input
        if(!hm.containsKey(input)){
            arr[input/10][input%10] = "M";
        }
        return arr;
    }

    public static void magneticFieldStrength(int input){

    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int player1Magnets = 5, player2Magnets = 5;
        String arr[][] = new String[10][9];
        boolean turn = true;
        boolean gameOn = true;
        fillGrid(arr);
        while (gameEnd(player1Magnets, player2Magnets) == false) {
            int playerPlaying = whoseTurn(turn);
            displayGrid(arr);
            System.out.println("Turn of Player " + playerPlaying + ":");
            System.out.println("Enter where you wanna place the magnet: ");
            player1Magnets = 0;
            int place = kb.nextInt();
            arr = inputHandling(arr, playerPlaying, place);
            displayGrid(arr); 
        }

    }
}
