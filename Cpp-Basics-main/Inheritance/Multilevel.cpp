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

class B: public A{
    protected: int y,sum;
    public:
        void getData(){
            cout<<"Enter a num2 ";
            cin>>y;
        }

};

class C : public B{
    int z;
    public:

        public:
        void getData2(){
            cout<<"Enter a num3 ";
            cin>>z;
            
        }
     
        void putData(){
          
            cout<<"Sum: "<<x + y + z;
        }
};


int main(){
    
    C obj2;

    obj2.input();
    obj2.getData();
    obj2.getData2();
    obj2.putData();
}