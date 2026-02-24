#include <iostream>
using namespace std;
class complex
{
    int a;
    int b;

public:
    void setData(int v1, int v2)
    {
        a = v1;
        b = v2;
    }
    //returnType operator symbol(arg list)
    friend complex operator +(complex c1, complex c2)
    {
        complex c3;
        c3.a = c1.a + c2.a;
        c3.b = c1.b + c2.b;
        return c3;
    }

    void printNumber()
    {
        cout << "Your complex number is " << a << " + " << b << "i" << endl;
    }
};

int main()
{
    complex c1, c2, c3;
    c1.setData(1, 2);
    c1.printNumber();

    c2.setData(3, 4);
    c2.printNumber();

    c3 = c1 + c2;

    cout << "After summing the above two: " << endl;
    c3.printNumber();
    return 0;
}