package Stacks;
import java.util.*;
public class PushAtBottom {

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

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // stack.push(0);
        pushAtBottom(stack, 0);
        System.out.println(stack);
    }
}
