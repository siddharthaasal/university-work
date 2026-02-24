#include <iostream>
using namespace std;
class person
{
    string name;
    int age;

public:
    person()
    {
        name = "";
        age = 0;
    }
    void setData()
    {
        cout << "Enter Name: ";
        cin >> name;
        cout << "Enter Age: ";
        cin >> age;
    }
    void getData()
    {
        cout << "Name: " << name << endl
             << "Age: " << age << endl;
    }

    person eldest(person obj)
    {
        if (obj.age > this->age)
            return obj;
        else
            return *this;
    }
};
int main()
{
    person p1, p2, p3;
    p1.setData();
    p2.setData();
    p3 = p1.eldest(p2);
    p3.getData();
}