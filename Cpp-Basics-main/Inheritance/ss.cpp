#include <iostream>
using namespace std;

class outer
{
public:
    int a = 20;
    class inner
    {
    public:
        int b = 40;
    };
};
int main()
{
    outer obj;
    outer ::inner obj1;
    cout << obj.a << endl;
    cout << obj1.b;
}
