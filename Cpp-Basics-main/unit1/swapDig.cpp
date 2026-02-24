#include<iostream>
using namespace std;

int main(){
    int n;
    cout<< "Enter a number\n";
    cin >> n;

    int x = n;
    
    string num = to_string(x);
    
    char lastDig = num[num.length() - 1];
    char firstDig = num[0];

    num[num.length() - 1] = firstDig;
    num[0] = lastDig;

    cout << num;



}