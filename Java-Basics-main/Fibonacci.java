package Java;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter which term of fibonacci series you want to know: ");
        int n = kb.nextInt();
        if (n < 3) {
            System.out.println("The n-th value of the fibonacci series is 1");
        } else {
            int term1 = 1;
            int term2 = 1;
            int term=0;
            n = n - 2;
            while (n > 0) {
                term = term1 + term2;
                term1 = term2;
                term2 = term;
                n--;
            }
            System.out.println("The n-th value of the fibonacci series is " + term);
        }
    }
}
