package DynamicProgramming;

import java.util.*;

public class CoinChange {
    // O(coins.length * sum)
    public static int countCoinChangeTabulation(int[] coins, int sum) {
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];
        // intitialize i->coins j->sum/change
        for (int i = 0; i < n + 1; i++)
            dp[i][0] = 1; // to give change of 0, there's only one way.

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                // Valid case
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] // include
                            + dp[i - 1][j]; // exclude
                } else {
                    // Invalid Case
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];

    }

    public static void main(String[] args) {
        int coins[] = { 2, 5, 3, 6 };
        int sum = 10; // ans: 5
        System.out.println(countCoinChangeTabulation(coins, sum));
    }
}
