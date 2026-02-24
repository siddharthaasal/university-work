#include<iostream>
using namespace std;
 inline int max(int a, int b, int c){
    if(a>b && a>c){
        return a;
    }
    else if(b>a && b>c){          
        return b;
    }
    else{
        return c;
    }
 }
 inline int min(int a, int b, int c){
    if(a<b && a<c){
        return a;
    }
    else if(b<a && b<c){          
        return b;
    }
    else{
        return c;
    }
 }
int main()
{
    int num1, num2, num3;
    cout<<"Enter three numbers: ";
    cin>>num1>>num2>>num3;
    int Max = max(num1, num2, num3);
    int Min = min(num1, num2, num3);

    cout<<"Maximum: "<<Max<<endl;
    cout<<"Minimum: "<<Min;
}