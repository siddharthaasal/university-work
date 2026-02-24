#include <iostream>
using namespace std;

class complex
{
    int real, imaginary;

public:
    void setData()
    {
        cout << "Enter real part: ";
        cin >> real;
        cout << "Enter im. part: ";
        cin >> imaginary;
    }

    void getData()
    {
        cout << "Real: " << real << endl;
        cout << "imaginary: " << imaginary << endl;
    }
};

int main()
{
    int size = 3;
    complex *ptr = new complex[size]; // array of objects
    complex *ptrTemp = ptr;
    int r, i;
    for (int j = 0; j < 3; j++)
    {
        ptr->setData();
        ptr++;
    }
    for (int j = 0; j < 3; j++)
    {
        ptrTemp->getData();
        ptrTemp++;
    }
}