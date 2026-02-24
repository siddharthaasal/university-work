#include<iostream>
using namespace std;

int main(){
    int n;
    cout<< "Enter a number\n";
    cin >> n;

    int x = n;
    int sum = 0;

    while(x>0){
        int digit  = x%10;
        sum = sum + (digit*digit*digit);
        x/=10;
    }

    if(sum==n){
        cout<< "Armstrong" << endl;
    }
    else{
        cout<< "Not Armstrong" << endl;
    }
}