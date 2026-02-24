#include<iostream>
using namespace std;

class A{
    protected: int x;
    public: 
        void input(){
            cout<<"Enter a num1 ";
            cin>>x;
        }
};

class B : public A{
    protected: int y, sum;
    public:
        void getData(){
            cout<<"Enter a num2 ";
            cin>>y;
        }
     

};

class D {
    protected: int z;
    public:
     
        void putData(){
           cout<<"Enter a num3 ";
            cin>>z;
        }
};

class C : public B, public D{
    int finalSum;
    public:
     
        void putData2(){
          
            cout<<"Final Sum: "<<x + y + z;
        }
};


int main(){
    
    
    C obj2;
   
    obj2.input();
    obj2.getData();


    obj2.putData();
    obj2.putData2();
}
