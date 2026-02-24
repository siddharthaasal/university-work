#include <iostream>

using namespace std;

class Test
{

private:
    int num;

public:
    // required constructors

    // default constructor to initlize the variable

    Test()
    {

        num = 0;
    }

    // parameterized constructor to return object after incrementing

    Test(int n)
    {

        num = n;
    }

    // method to display time

    void display()
    {

        cout << "Number: " << num << endl;
    }

    // overloaded prefix ++ operator

    Test operator++()
    {

        // increment this object

        ++num;

        // return object with increment value

        return Test(num);
    }

    // overloaded postfix ++ operator

    Test operator++(int)
    {

        // save the original value

        Test t(num);

        // increment current object

        ++num;

        // return old original value

        return t;
    }
};

int main()
{

    Test T1(11), T2(11), T3;

    ++T1; // increment T1

    T1.display(); // display T1

    T2++; // increment T2

    T2.display(); // display T2

    T3.display(); // display T3

    T3 = T2++; // increment T2 again and assign pre-incremented value to T3

    T2.display(); // display T2

    T3.display(); // display T3

    return 0;
}
