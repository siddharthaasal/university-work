package Stacks;

import java.util.Stack;

public class DuplicateParantheses {
    public static void main(String[] args) {
        String str = "(((a+b)+(c+d)))";
        Stack<Character> stack = new Stack<>();
        boolean isDuplicate = false;
        for(int i=0; i<str.length(); i++){
            boolean isAnotherOperator = false;
            char ch = str.charAt(i);
            if(ch!=')'){
                stack.push(ch);
            }
            else{
                while(stack.peek()!='('){
                    if(stack.peek()!='('){
                        isAnotherOperator = true;
                    }
                    stack.pop();
                }
                stack.pop(); // '(' remove
                if(isAnotherOperator==true){
                    isDuplicate=false;
                }
                else{
                    isDuplicate=true;
                    break;
                }
            }
        }
        if(isDuplicate==true){
            System.out.println("Duplicate");
        }
        else{
            System.out.println("Not Duplicate");
        }
    }
}
