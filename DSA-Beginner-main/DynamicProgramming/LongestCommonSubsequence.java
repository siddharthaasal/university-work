package DynamicProgramming;

public class LongestCommonSubsequence {
    public static int lcsRecursion(String s1, String s2, int n, int m) {
        // Base Case
        if (n == 0 || m == 0)
            return 0;
        // Recursive Case
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return 1 + lcsRecursion(s1, s2, n - 1, m - 1);
        } else {
            return Math.max(lcsRecursion(s1, s2, n - 1, m), lcsRecursion(s1, s2, n, m - 1));
        }
    }

    public static int lcsMemoization(String s1, String s2, int n, int m, int[][] dp) {

        // Base Case
        if (n == 0 || m == 0)
            return 0;
        // Recursive Case
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = 1 + lcsMemoization(s1, s2, n - 1, m - 1, dp);
            return dp[n][m];
        } else {
            dp[n][m] = Math.max(lcsMemoization(s1, s2, n - 1, m, dp), lcsMemoization(s1, s2, n, m - 1, dp));
            return dp[n][m];
        }

    }

    // O(m*n)
    public static int lcsTabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        // Initialisation
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
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "abcdge";
        String s2 = "abedg";
        // LCS -> abdg, length: 4
        int n = s1.length();
        int m = s2.length();

        // Naive Recursion
        System.out.println(lcsRecursion(s1, s2, n, m));

        // Recursion + Memoization
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(lcsMemoization(s1, s2, n, m, dp));

        // Tabulation
        System.out.println(lcsTabulation(s1, s2));
    }
}
