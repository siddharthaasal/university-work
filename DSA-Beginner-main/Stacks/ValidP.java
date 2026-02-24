package Stacks;
import java.util.*;
class ValidP {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()==1)
        return false;
        for(int i=0;i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='[' || ch=='{' || ch== '('){
                stack.push(ch);
            }
            else{
                 if (stack.isEmpty()) {
                    return false;
                }
                char ch2 = stack.pop();
                if (ch2 == '(' && ch == ')') {
                    continue;
                } else if (ch2 == '{' && ch == '}') {
                    continue;
                } else if (ch2 == '[' && ch == ']') {
                    continue;
                } else {
                    return false; 
                }
        }
        }
        if(stack.empty()){
            return true;
        }
        else{
            return false;
        }
    }

}
