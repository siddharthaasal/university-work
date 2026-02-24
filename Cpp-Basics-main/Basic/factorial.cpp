#include<iostream>
using namespace std;

int main(){
    int n;
    cout<< "Enter a number\n";
    cin >> n;
    int fac = 1;

    while(n>=1){
        fac*=n;
        n--;
    }
    cout << fac ;
}