// without parentheses
package Stacks;

import java.util.Stack;

public class BasicCalculator {
    public static int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        char ch = ' ';
        for(int i=0; i<s.length(); i++){
            ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int num = Character.getNumericValue(ch);
                currentNumber = currentNumber*10 + num;;
            }
            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == s.length() - 1){
                if(operation == '+'){
                    stack.push(currentNumber);
                    operation = ch;
                    currentNumber = 0;
                }
                else if(operation == '-'){
                    stack.push(currentNumber*-1);
                    operation = ch;
                    currentNumber = 0;
                }
                else if(operation == '*'){
                    stack.push(stack.pop()*currentNumber);
                    operation = ch;
                    currentNumber = 0;
                }
                else{
                    stack.push(stack.pop()/currentNumber);
                    operation = ch;
                    currentNumber = 0;
                }
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "3+4*3";
        System.out.println("Answer: "+calculate(s));
    }
}

