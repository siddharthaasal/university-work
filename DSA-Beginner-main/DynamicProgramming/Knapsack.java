package DynamicProgramming;

import java.util.*;

public class Knapsack {
    // Recursion
    public static int knapsackRecursion(int weight[], int profit[], int capacity, int index) {
        // Base cases
        if (index >= weight.length || weight[index] > capacity || capacity < 0) {
            return 0;
        }
        // recursive case
        int profitInc = 0;
        if (weight[index] <= capacity) {
            profitInc = profit[index] + knapsackRecursion(weight, profit, capacity - weight[index], index + 1);
        }
        int profitExc = knapsackRecursion(weight, profit, capacity, index + 1);
        return Math.max(profitInc, profitExc);
    }

    // Recursion + Memoization
    public static int knapsackMemoization(int weight[], int profit[], Integer dp[][], int capacity, int index) {
        // Base cases
        if (index >= weight.length || weight[index] > capacity || capacity < 0) {
            return 0;
        }
        if (dp[index][capacity] != null) {
            return dp[index][capacity];
        }
        // recursive case
        int profitInc = 0;
        if (weight[index] <= capacity) {
            profitInc = profit[index] + knapsackMemoization(weight, profit, dp, capacity - weight[index], index + 1);
        }
        int profitExc = knapsackMemoization(weight, profit, dp, capacity, index + 1);
        dp[index][capacity] = Math.max(profitInc, profitExc);
        return dp[index][capacity];
    }

    public static void main(String[] args) {
        int n = 4, capacity = 7;
        int weight[] = { 1, 2, 3, 5 };
        int profit[] = { 1, 6, 10, 16 };
        System.out.println(knapsackRecursion(weight, profit, capacity, 0));
        Integer dp[][] = new Integer[n][capacity + 1];
        // Arrays.fill(dp, -1);
        System.out.println(knapsackMemoization(weight, profit, dp, capacity, 0));

    }
}
