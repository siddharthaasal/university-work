package Java;
import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int row1=3, col1=3, row2=3, col2=2;  //col1 = row2
        int a[][] = new int[row1][col1];
        int b[][] = new int[row2][col2];
        System.out.println("Enter the elements of 3 by 3 matrix: ");
        for(int i=0; i<row1; i++){
            for(int j=0; j<col1; j++){
                a[i][j] = kb.nextInt();
            }
        }
        System.out.println("Enter the elements of 3 by 2 matrix: ");
        for(int i=0; i<row2; i++){
            for(int j=0; j<col2; j++){
                b[i][j] = kb.nextInt();
            }
        }

        int c[][]  = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < row2; k++)
                    c[i][j] += a[i][k] * b[k][j];
            }
        }

        for(int i=0; i<row1; i++){
            for(int j=0; j<col2; j++){
                System.out.print(c[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
