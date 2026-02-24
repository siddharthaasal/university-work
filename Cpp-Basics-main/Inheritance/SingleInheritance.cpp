#include<iostream>
using namespace std;

class A{
    protected: int x;
    public: 
        void input(){
            cout<<"Enter a num";
            cin>>x;
        }
};

class B : public A{
    int y;
    public:
        void getData(){
            cout<<"Enter a value";
            cin>>y;
        }
        void putData(){
            cout<<"Sum: "<<x+y;
        }
};

int main(){
    B obj;
    obj.input();
    obj.getData();
    obj.putData();
}