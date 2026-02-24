#include <iostream>
using namespace std;
class A
{
public:
    int a = 1;
    int b = 2;
};
class B : virtual public A
{
};
class C : virtual public A
{
};
class D : public C, public B
{
};
int main()
{
    D obj;
    int x = obj.a;
    cout << x;
}
// solves ambiguity in hybrid inheritance