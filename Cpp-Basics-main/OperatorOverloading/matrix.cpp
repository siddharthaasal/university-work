#include <iostream>
using namespace std;

#define maxR 5
#define maxC 5

class matrix
{
    int rows, columns;
    int arr[maxR][maxC];

public:
    void setMatrix()
    {
        cout << "Enter no. of rows and columns of a matrix: ";
        cin >> rows >> columns;
        arr[rows][columns];

        cout << "Enter elements of matrix:" << endl;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {

                cin >> arr[i][j];
            }
        }
    }
    void printMatrix()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                cout << arr[i][j] << " ";
            }
            cout << endl;
        }
    }

    friend matrix operator+(matrix m1, matrix m2)
    {
        // let's say m1 and m2 are of same order.
        matrix sum;
        sum.rows = m1.rows;
        sum.columns = m1.columns;
        int arr[sum.rows][sum.columns];

        for (int i = 0; i < m1.rows; i++)
        {
            for (int j = 0; j < m1.columns; j++)
            {
                sum.arr[i][j] = m1.arr[i][j] + m2.arr[i][j];
            }
        }
    }
};

int main()
{
    matrix x, y, z;
    x.setMatrix();
    y.setMatrix();
    z = x + y;
    z.printMatrix();
}