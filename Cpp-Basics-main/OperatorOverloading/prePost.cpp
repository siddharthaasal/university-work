#include <iostream>
using namespace std;

class overloading
{
    int n;

public:
    overloading()
    {
        n = 0;
    }
    overloading(int a)
    {
        n = a;
    }
    overloading operator++()
    {
        ++n;
        return overloading(n);
    }

    overloading operator++(int)
    {
        n++;
        return overloading(n);
    }
    void display()
    {
        cout << n << endl;
    }
};

int main()
{
    overloading o1(10);
    ++o1;
    o1.display();
    o1++;
    o1.display();
}