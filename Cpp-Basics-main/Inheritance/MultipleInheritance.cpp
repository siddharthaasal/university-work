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

class B{
    protected: int y;
    public:
        void getData(){
            cout<<"Enter a num2 ";
            cin>>y;
        }

};

class C : public A, public B{
    int z;
    public:
     
        void putData(){
          
            cout<<"Sum: "<<x+y;
        }
};


int main(){
    
    C obj2;
   
    obj2.input();
    obj2.getData();
    obj2.putData();
}