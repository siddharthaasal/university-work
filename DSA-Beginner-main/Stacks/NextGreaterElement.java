package Stacks;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        Stack<Integer> stack = new Stack<>();
        int nextGreater[] = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            while(!stack.empty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            if(stack.empty()){
                nextGreater[i] = -1;
            }
            else{
                nextGreater[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        for(int i=0; i<nextGreater.length; i++){
            System.out.print(nextGreater[i]+" ");
        }
    }
}
// 4