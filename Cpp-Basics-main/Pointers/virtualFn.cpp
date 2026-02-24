#include <iostream>
using namespace std;

class media
{
protected:
    string title;
    float price;

public:
    media(string s, float p)
    {
        title = s;
        price = p;
    }
    virtual void display() // virtual fn being defined in base class
    {
        cout << "Title: " << title << endl;
        cout << "Price: " << price << endl;
    }
};
class book : public media
{
    float time;

public:
    book(string s, float p, float t) : media(s, p) // inheriting constructor
    {
        time = t;
    }
    void display()
    {
        cout << "Title: " << title << endl;
        cout << "Price: " << price << endl;
        cout << "Time: " << time << endl;
    }
};
class tape : public media
{
    int pages;

public:
    tape(string s, float p, int pg) : media(s, p) // inheriting constructor
    {
        pages = pg;
    }
    void display()
    {
        cout << "Title: " << title << endl;
        cout << "Price: " << price << endl;
        cout << "Pages: " << pages << endl;
    }
};
int main()
{
    string title = "Twisted Love";
    float price = 400.00;
    float time = 240;
    int pages = 250;
    book b1(title, price, time);
    tape t1(title, price, pages);
    media *ptr[2]; // pointer to object of base class
    ptr[0] = &b1;
    ptr[1] = &t1;
    ptr[0]->display();
    ptr[1]->display();
}
