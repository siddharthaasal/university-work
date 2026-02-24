#include <iostream>
using namespace std;
class A
{
public:
    void print()
    {
        cout << "In class A";
    }
};
class B
{
public:
    void print()
    {
        cout << "In class B";
    }
};

class C : public A, public B
{
public:
    void print()
    {
        cout << "In class C";
    }
};

int main()
{
    C obj;
    // Case 1: Multiple inheritance
    obj.A::print();
    obj.B::print();

    // C2:  fn overriding
    obj.print();
}