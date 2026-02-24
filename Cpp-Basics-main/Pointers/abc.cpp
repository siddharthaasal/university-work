#include <iostream>

using namespace std;

class Number

{

private:
    int num;

public:
    // constructor

    Number() { num = 0; };

    // member function to get input

    void inputNumber(void)

    {

        cout << "Enter an integer number: ";

        cin >> num;
    }

    // member function to display number

    void displayNumber()

    {

        cout << "Num: " << num << endl;
    }
};

// Main function

int main()

{

    // declaring object to the class number

    Number N;

    // input and display number using norn object

    N.inputNumber();

    N.displayNumber();

    // declaring pointer to the object

    Number *ptrN;

    ptrN = new Number; // creating & assigning memory

    // printing default value

    cout << "Default value... " << endl;

    // calling member function with pointer

    ptrN->displayNumber();

    // input values and print

    ptrN->inputNumber();

    ptrN->displayNumber();

    return 0;
}