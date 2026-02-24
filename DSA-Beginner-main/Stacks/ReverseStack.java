package Stacks;

import java.util.Stack;

public class ReverseStack {

    public static void pushAtBottom(Stack<Integer> s, int data){
        //base
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        //recursive
        int top = s.peek();
        s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverse(s);
        pushAtBottom(s,top);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
    
}
