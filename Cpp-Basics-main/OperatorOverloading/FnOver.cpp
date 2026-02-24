// redefinition error if same argument list is passed.
#include <iostream>
using namespace std;

// int cube(int);
// double cube(double);

// int cube(int a)
// {
//     return a * a * a;
// }
// double cube(double a)
// {
//     return a * a * a;
// }
int add(int a, int b)
{
    return a + b;
}
int add(int a, int b, int c)
{
    return a + b + c;
}

int main()
{
    // int x = cube(2);
    // double y = cube(2.5);
    // cout << "Cube: " << x << endl
    //      << "Cube: " << y;

    int x = add(2, 3);
    cout << x;
    int y = add(2, 3, 4);
    cout << y;
}
