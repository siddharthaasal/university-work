package DynamicProgramming;

import java.util.*;

public class LongestIncreasingSubsequence {
    public static int lisTabulation(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int[][] dp = new int[n + 1][m + 1];

        // Initialise
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Tabulation
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // Valid case
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                // Invalid case
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int arr[] = { 5, 3, 10, 7, 40, 80 };

        // Unique elements
        HashSet<Integer> set = new HashSet<Integer>();
        for (int j = 0; j < arr.length; j++) {
            set.add(arr[j]);
        }
        int arr2[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }

        // Ascending Order
        Arrays.sort(arr2);

        System.out.println(lisTabulation(arr, arr2));
    }
}
