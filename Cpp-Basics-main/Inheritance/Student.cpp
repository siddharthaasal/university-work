#include <iostream>
using namespace std;

class student
{
    string uid;
    string name;

public:
    void setData()
    {
        cout << "Enter UID: ";
        cin >> uid;
        cout << "Enter Name: ";
        cin >> name;
    }
    void putData()
    {
        cout << "UID: " << uid << endl;
        cout << "Name: " << name << endl;
    }
};

class test : public virtual student
{
    int marks1, marks2;

public:
    void setMarks()
    {
        cout << "Enter Marks1: ";
        cin >> marks1;
        cout << "Enter Marks2: ";
        cin >> marks2;
    }
    void putMarks()
    {
        cout << "Marks1 " << marks1 << endl;
        cout << "Marks2 " << marks2 << endl;
    }
};

class sports : public virtual student
{
    int sportsScore;

public:
    void setScore()
    {
        cout << "Enter Sport's Score: ";
        cin >> sportsScore;
    }
    void putScore()
    {
        cout << "Sport's Score: " << sportsScore << endl;
    }
};

class result : public test, public sports
{
public:
    void display()
    {
        putData();
        putMarks();
        putScore();
    }
};

int main()
{
    result object;
    object.setData();
    object.setMarks();
    object.setScore();
    object.display();
}