#include <iostream>
using namespace std;

int a = 10;
float b = 10.5;
string x = "hi";

class complex
{

    int real, imaginary; // data members
    // to access private data members, we need member function
public:
    // syntax of a function ->  returnType fnName(parameter list)  (int a, int b)

    void setData()
    {
        cout << "Enter real part: ";
        cin >> real;
        cout << "Enter im. part: ";
        cin >> imaginary;
    }

    void setData(int r, int i)
    {
        real = r;
        imaginary = i;
    }

    void printData()
    {
        cout << "Real: " << real << endl;
        cout << "Imaginary: " << imaginary << endl;
    }

    // 1+2i
    // 3+4i

    complex add(complex c1, complex c2)
    {
        complex c3;
        c3.real = c1.real + c2.real;
        c3.imaginary = c1.imaginary + c2.imaginary;
        return c3;
    }
};

int main()
{
    complex c1, c2, c3;
    // objectName.fnName(parameter list);
    // c1.setData(1, 2);
    c1.setData();
    c2.setData();
    c3 = c3.add(c1, c2);
    c3.printData();
}
