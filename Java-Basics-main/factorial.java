package Java;

import java.util.Scanner;

class factorial{

    public static long calculateFactorial(long num){
        //base case
        if(num==0){
            return 1;
        }
        //recursive case
        return num * calculateFactorial(num-1);
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the number to calculate its factorial: ");
        long n = kb.nextLong();
        if(n<0){
            System.err.println("Factorial is calculated for positive numbers only.");
        }
        else{
            System.out.println("The factorial of "+n+" is : "+ calculateFactorial(n));
        }
        kb.close();
    }
    
}