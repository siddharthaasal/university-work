#include<iostream>
using namespace std;
class complex{
    int a;
    int b;

    public: 
        void setData(int v1, int v2){
            a = v1;
            b = v2;
        }

        friend complex setDataBySum(complex o1, complex o2){
            complex c3;
            c3.a = o1.a + o2.a;
            c3.b = o1.b + o2.b;
            return c3;
        }

        void printNumber(){
            cout<<"Your complex number is "<<a<<" + "<<b<<"i"<<endl;
        }
};


int main(){
    complex c1, c2, c3;
    c1.setData(1, 2);
    c1.printNumber();

    c2.setData(3, 4);
    c2.printNumber();
    
    c3 = setDataBySum(c1,c2);
    cout<<"After summing the above two: "<<endl;
    c3.printNumber();
    return 0;
}