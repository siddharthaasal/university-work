package DynamicProgramming;

public class EditDistance {

    public static int editRecursion(String s1, String s2, int n, int m) {
        // base case -> wrong yet
        if (n == 0 || m == 0) {
            return 0;
        }
        // recursive case
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return editRecursion(s1, s2, n - 1, m - 1);
        } else {
            int add = 1 + editRecursion(s1, s2, n, m - 1);
            int delete = 1 + editRecursion(s1, s2, n - 1, m);
            int replace = 1 + editRecursion(s1, s2, n - 1, m - 1);
            return Math.min(add, Math.min(delete, replace));
        }

    }

    public static int editTabulation(String s1, String s2, int n, int m, int[][] dp) {

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int add = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    ;
                    dp[i][j] = Math.min(add, Math.min(delete, replace));
                }
            }

        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";

        // recursion
        int n = s1.length();
        int m = s2.length();
        System.out.println(editRecursion(s1, s2, n, m));

        // tabulation
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        System.out.println(editTabulation(s1, s2, n, m, dp));
    }
}
