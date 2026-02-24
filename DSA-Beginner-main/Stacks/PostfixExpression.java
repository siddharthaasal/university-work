package Stacks;

import java.util.Stack;

public class PostfixExpression {
    public static int evaluate(int a, int b, char ch){
        switch(ch){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            case '%':
                return a%b;
            default:
                return -1;
        }
    }
    public static void main(String[] args) {
        String str = "533*+"; 
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char o = str.charAt(i);
            if(o == '%' || o == '/' || o == '*' || o == '+' || o == '-'){
                int element2 = stack.pop();
                int element1 = stack.pop();
                int result = evaluate(element1,element2,o);
                stack.push(result);
            }
            else{
                stack.push(Character.getNumericValue(o));
            }
        }
        System.out.println(stack.peek());
    }
}
