package Stacks;

import java.util.Stack;

public class MaxAreaHistogram {

    public static int area(int arr[]){
        int max = Integer.MIN_VALUE;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
        //Next Smaller Right
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            while(!stack.empty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.empty()){
                nsr[i] = arr.length;
            }
            else{
                nsr[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        //Next Smaller Left
        for(int i=0; i<arr.length; i++){
            while(!stack.empty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.empty()){
                nsl[i] = -1;
            }
            else{
                nsr[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        //Current Area
        for(int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i]-nsl[i]-1;
            int currArea = height*width;
            max = Math.max(max, currArea);
        }
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        System.out.println(area(arr));
    }
}
