#include<iostream>
using namespace std;

int main(){
    int a, b;
    cout<< "Enter num 1\n";
    cin >> a;
    cout<< "Enter num 2\n";
    cin >> b;
    
    a = a+b;
    b = a-b;
    a = a-b;

    cout<< "num1 -> " <<a << "\n";
    cout << "num2 -> " <<b;

}