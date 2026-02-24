package Java;

import java.util.Stack;

public class SortedStack<T extends Comparable<T>> {
    private Stack<T> stack;

    public SortedStack() {
        stack = new Stack<>();
    }

    // Push an element onto the sorted stack while maintaining order
    public void push(T item) {
        Stack<T> tempStack = new Stack<>();

        // Pop elements greater than the new item to the tempStack
        while (!stack.isEmpty() && stack.peek().compareTo(item) > 0) {
            tempStack.push(stack.pop());
        }

        // Push the new item onto the stack
        stack.push(item);

        // Push elements from the tempStack back to the stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    // Pop the top element from the sorted stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.pop();
    }

    // Peek at the top element of the sorted stack
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.peek();
    }

    // Check if the sorted stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Get the size of the sorted stack
    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        // Demonstrate SortedStack with Integer values
        SortedStack<Integer> intStack = new SortedStack<>();
        intStack.push(3);
        intStack.push(1);
        intStack.push(4);
        intStack.push(2);

        System.out.println("SortedStack of Integers:");
        while (!intStack.isEmpty()) {
            System.out.println(intStack.pop());
        }

        // Demonstrate SortedStack with String values
        SortedStack<String> strStack = new SortedStack<>();
        strStack.push("banana");
        strStack.push("apple");
        strStack.push("cherry");

        System.out.println("\nSortedStack of Strings:");
        while (!strStack.isEmpty()) {
            System.out.println(strStack.pop());
        }
    }
}

