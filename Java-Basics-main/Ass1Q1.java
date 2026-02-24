package Java;

import java.util.*;

class Ass1Q1 {
    public static void main(String[] args) {
        int num1, num2, ans;
        char operator;
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter 1st num");
        num1 = kb.nextInt();
        System.out.println("Enter 2nd number");
        num2 = kb.nextInt();
        System.out.println("Choose the operation: + - * /");
        operator = kb.next().charAt(0);
        switch (operator) {
            case '+':
                ans = num1 + num2;
                System.out.println(ans);
                break;
            case '-':
                ans = num1 - num2;
                System.out.println(ans);
                break;
            case '*':
                ans = num1 * num2;
                System.out.println(ans);
                break;
            case '/':
                if (num2 != 0) {
                    ans = num1 / num2;
                    System.out.println(ans);
                }else{
                    System.out.println("Denominator cannot be zero");
                }
                break;
            default:
                System.out.println("Invalid operator choice");
        }

    }
}