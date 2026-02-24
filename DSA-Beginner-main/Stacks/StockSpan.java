package Stacks;

import java.util.Stack;

public class StockSpan {

    public static void span(int price[], int S[]){
        int n = price.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        S[0]=1;
        for(int i=1; i<n; i++){
            while(!stack.isEmpty() && price[stack.peek()]<=price[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                S[i]=i+1;
            }
            else{
                S[i] = i-stack.peek();
            }
            stack.push(i);
        }
    }
    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }
    public static void main(String[] args) {
        int price[] = { 100, 80, 60, 70, 60, 75, 85 };
        int n = price.length;
        int S[] = new int[n];
        span(price, S);
        printArray(S);
    }
}
