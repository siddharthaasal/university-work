package Recursion;

public class basics {

    public static void printDecreasing(int n){
        if(n==0){
            return;
        }
        System.out.print(n + " ");
        printDecreasing(n-1);
    }

    public static void printIncreasing(int n){
        if(n==0){
            return;
        }
        printIncreasing(n-1);
        System.out.print(n + " ");
    }

    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static int sum(int n){
        if(n==1){
            return 1;
        }
        return n + sum(n-1);
    }

    public static int nthFibonacciNumber(int n){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }

        return nthFibonacciNumber(n-1) + nthFibonacciNumber(n-2);
    }

    public static void fibonnaciSeries(int n, int a, int b){
        if(n>0){
            System.out.print(a + " ");
            fibonnaciSeries(n-1, b, a+b);
        }
        

    }

    public static int power(int x, int n){
        if(n==0){
            return 1;
        }
        return x * power(x, n-1);
    }

    public static void main(String[] args) {
        printIncreasing(5);
        System.out.println(factorial(4));
        System.out.println(sum(5));
        fibonnaciSeries(4, 0, 1);
        System.out.println("\n"+power(2, 4));
    }
}
