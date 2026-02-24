#include<iostream>
using namespace std;

class Second;  //declaring secong class ahead of first class


class First{
    protected:
        int num1;

    public:
        void input(int a){
             num1 = a;
        }
        void display(){
            cout<<"Value in class 1: "<<num1<<endl;
        }
        
        friend void swap(First &, Second &);  //friend function

};

class Second{
    protected:
        int num2;

    public:
        void input(int b){
             num2 = b;
        }
        void display(){
            cout<<"Value in class 2: "<<num2<<endl;
        }
        
        friend void swap(First &, Second &);

};

void swap(First &x, Second &y){   //swapping through reference 
    int temp = x.num1;
    x.num1 = y.num2;
    y.num2 = temp;

}

int main(){
    First var1; 
    Second var2;
    var1.input(2);
    var2.input(3);
    cout<<"Before swap: "<<endl;
    var1.display();
    var2.display();
    swap(var1, var2);
    cout<< "After swap: "<<endl;
    var1.display();
    var2.display();
}