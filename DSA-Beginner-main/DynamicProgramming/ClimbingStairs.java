package DynamicProgramming;

import java.util.*;

class ClimibingStairs {
    // recursion -> O(2^n)
    public static int countRecursion(int n) {
        if (n == 0)
            return 1;
        if (n < 1)
            return 0;
        return countRecursion(n - 1) + countRecursion(n - 2);
    }

    // recursion + memoization -> O()
    public static int countMemoization(int n, int check[]) {

        if (n == 0)
            return 1;
        if (n < 1)
            return 0;
        if (check[n] != -1)
            return check[n];
        check[n] = countMemoization(n - 1, check) + countMemoization(n - 2, check);
        return check[n];
    }
    // tabulation

    public static void main(String[] args) {
        int n = 5;
        int check[] = new int[n + 1];
        Arrays.fill(check, -1);
        int ways = countRecursion(n);
        System.out.println(ways);
        int waysViaMem = countMemoization(n, check);
        System.out.println(waysViaMem);
    }
}