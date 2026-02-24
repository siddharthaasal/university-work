#include <iostream>
using namespace std;
class A
{
public:
    int area;
    A()
    {
        area = 0;
    }
    A(int l, int b)
    {
        area = l * b;
    }
    A(int l, int b, int h)
    {
        area = l * b * h;
    }
};
int main()
{
    A obj;
    A obj2(2, 3);
    A obj3(2, 3, 4);
    cout << obj.area << endl;
    cout << obj2.area << endl;
    cout << obj3.area << endl;
}