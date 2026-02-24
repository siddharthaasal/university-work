#include<iostream>
using namespace std;

int main(){
    int n;
    cout << "Enter a number: " << endl;
    cin >> n;

    if(n%2==0){
        cout<< "Even";
    }
    else{
        cout << "Odd";
    }
    string x;
    x = (n%2==0)?"Even":"Odd";
    cout<<"\n";
    cout<< x ;
}