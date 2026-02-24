#include <iostream>
using namespace std;
class A
{

public:
    int a, b;
    A(int a, int b)
    {
        this->a = a;
        this->b = b;
    }
};
int main()
{
    A obj(2, 3);
    cout << obj.a;
}