#include <iostream>
using namespace std;

class A
{
public:
    int a = 1;
    void showA()
    {

        cout << "Value A: " << a << endl;
    }
};
class H
{
public:
    int h;
    void showH()
    {

        cout << "Value H: " << h << endl;
    }
};
class B : public A
{
public:
    int b = 2;
    void showB()
    {

        cout << "Value B: " << a + b << endl;
    }
};
class C : public B
{
public:
    int c = 3;
    void showC()
    {

        cout << "Value C: " << a + b + c << endl;
    }
};
class D : public B
{
};
class E : public C, virtual public D
{
};
class F : public A, virtual public E
{
};
class G : public A, public H
{
};

class I : public G
{
};
class J : public G
{
};
// class K : public G, virtual public G
// {
// };
class L : public F
{
};
class M : public E, virtual public L
{
};

int main()
{
    C objC;
    objC.showC();
}