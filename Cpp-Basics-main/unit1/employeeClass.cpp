#include<iostream>
using namespace std;

class employee{
    
    char name[30];
    int age;
    char designation[15];
    double salary;
    public:
    void GetData();
    void PutData();
};

void employee :: GetData() {
    cout<<"Enter employee's name: ";
    cin>>name;
    cout<<"Enter employee's age: ";
    cin>>age;
    cout<<"Enter employee's designation: ";
    cin>>designation;
    cout<<"Enter employee's salary: ";
    cin>>salary;
}

void employee :: PutData() {
    cout<<"Employee Name: "<<name<<endl;
    cout<<"Employee Age: "<<age<<endl;
    cout<<"Employee Designation: "<<designation<<endl;
    cout<<"Employee Salary: "<<salary<<endl;
}
int main(){

    employee E[3];
    for(int i=0; i<3; i++){
        E[i].GetData();
    }
    for(int i=0; i<3; i++){
        E[i].PutData();
    }
}