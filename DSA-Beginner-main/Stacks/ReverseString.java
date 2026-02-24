package Stacks;
import java.util.*;
public class ReverseString {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String str = "Hello";
        String str2 = "";
        for(int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));
        }
        for(int i=0; i<str.length(); i++){
            char ch = stack.peek();
            str2+=ch;
            stack.pop();
        }
        System.out.println(str2);
    }
}
