#include <iostream>
using namespace std;

class base
{
protected:
    int b;

public:
    void set(int x)
    {
        b = x;
    }
    int get()
    {
        return b;
    }
};

class exponent
{
protected:
    int e;

public:
    void setData(int x)
    {
        e = x;
    }
    int getData()
    {
        return e;
    }
};

class child : public base, public exponent
{
public:
    int pow = 1;
    void show()
    {
        // get();
        // getData();
        for (int i = 1; i <= e; i++)
        {
            pow = pow * b;
        }
        cout << pow << endl;
    }
};

int main()
{
    child obj;
    obj.set(2);
    obj.setData(4);
    obj.show();
}
