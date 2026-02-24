package Java;

import java.util.Scanner;

public class RecursionFibonacci {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter which term of fibonacci series you want to know: ");
        int n = kb.nextInt();
        int term = fib(n);
        System.out.println(term);

    }
    public static int fib(int n){
        //base case
        if(n==1){
            return 1;
        }
        else if(n==0){
            return 0;
        }
        //recursive case
        return n = fib(n-1) + fib(n-2);

    }
}
