#include<iostream>
using namespace std;
#define MAX_SIZE 50

class Hall{
    string name;
    static int seatNo;

    public: 
        void setData(){
            cout<<"Enter the name of guest: ";
            cin>>name;
            seatNo++;
        }
        void getData(void)
        {
            if(seatNo>MAX_SIZE){
                cout<<"Only 50 guests allowed, limit exceeded!";
            }
            else{
                cout << "The name of guest is " << name << " and his seat number is " << seatNo << endl;
            }
        
        }
};

int Hall :: seatNo;

int main(){
    int count;
    cout<<"No of guests: ";
    cin>>count;

    Hall E[count];
    for(int i=0; i<=count-1; i++){
        E[i].setData();
        E[i].getData();
    }

}