#include <iostream>
using namespace std;

class A
{
protected:
    int x, y;

public:
    void setData(int a, int b)
    {
        x = a;
        y = b;
    }
};

class B : public A
{
public:
    void printData()
    {
        cout << "Sum:" << x + y << endl;
    }
};

class C : public A
{
public:
    void printData()
    {
        cout << "Product:" << x * y << endl;
    }
};

int main()
{
    B o1;
    C o2;

    o1.setData(4, 5);
    o2.setData(4, 5);

    o1.printData();
    o2.printData();
}