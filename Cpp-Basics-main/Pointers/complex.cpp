#include <iostream>
using namespace std;

class complex
{
    int real, imaginary;

public:
    complex()
    {
        real = 0;
        imaginary = 0;
    }

    void setData(int r, int i)
    {
        real = r;
        imaginary = i;
    }

    void getData()
    {
        cout << "Real: " << real << endl;
        cout << "imaginary: " << imaginary << endl;
    }
};

int main()
{
    complex c1;
    complex *ptr = &c1; // complex* ptr = new complex;
    ptr->setData(2, 3); //(*ptr).setData(2, 3); //ptr
    ptr->getData();     //(*ptr).getData();
}
