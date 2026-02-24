#include <iostream>
using namespace std;

class data
{
protected:
    string id, name, subject, publication;

public:
    void setData()
    {
        cout << "Enter Employee Id: ";
        cin >> id;
        cout << "Eneter Faculty Name: ";
        cin >> name;
        cout << "Eneter Subject: ";
        cin >> subject;
        cout << "Eneter Publication: ";
        cin >> publication;
    }
    void getData()
    {
        cout << "Employee Id: " << id << endl;
        cout << "Faculty Name: " << name << endl;
        cout << "Subject: " << subject << endl;
        cout << "Publication: " << publication << endl;
    }
};

int main()
{
    int choice;
    data teacher[10];
    data labAssistant[10];

    int i;

    char test;

    while (1)
    {
        int count;
    start:

        cout << "\n=====CHANDIGARH UNIVERSITY DATABASE=====\n\n\n";
        cout << "Choose Category of Information\n";
        cout << "1)  Teacher\n";
        cout << "2)  Lab Assistant\n";
        cout << "3)  Typist\n";
        cout << "4)  Exit\n";
        cout << "Enter your choice:-";

        cin >> choice;

        switch (choice)

        {

        case 1:
            while (1)

            {

                cout << "\n=====TEACHERS INFORMATION=====\n\n";

                cout << "\nChoose your choice\n";

                cout << "1) Create\n";

                cout << "2) Display\n";

                cout << "3) Jump to Main Menu\n";

                cout << "Enter your choice:-";

                cin >> choice;

                switch (choice)

                {

                case 1:
                    for (count = 0, i = 0; i < 10; i++)

                    {

                        cout << endl;

                        teacher[i].setData();

                        count++;

                        cout << endl;

                        cout << "\n\nAre you Interested in entering data\n";

                        cout << "Enter y or n:-";

                        cin >> test;

                        if (test == 'y' || test == 'Y')

                            continue;

                        else
                            goto out1;
                    }

                out1:

                    break;

                case 2:
                    for (i = 0; i < count; i++)

                    {

                        cout << endl;

                        teacher[i].getData();

                        cout << endl;
                    }

                    break;

                case 3:
                    goto start;

                default:
                    cout << "\nEnter choice is invalid\ntry again\n\n";
                }
            }

        case 2:
            while (1)

            {

                cout << "\n=====Lab Assistant Information=====\n\n";

                cout << "\nChoose your choice\n";

                cout << "1) Create\n";

                cout << "2) Display\n";

                cout << "3) Jump to Main Menu\n";

                cout << "Enter your choice:-";

                cin >> choice;

                switch (choice)

                {

                case 1:
                    for (count = 0, i = 0; i < 10; i++)

                    {

                        cout << endl;

                        labAssistant[i].setData();

                        count++;

                        cout << endl;

                        cout << "\n\nAre you Interested in entering data\n";

                        cout << "Enter y or n:-";

                        cin >> test;

                        if (test == 'y' || test == 'Y')

                            continue;

                        else
                            goto out2;
                    }

                out2:

                    break;

                case 2:
                    for (i = 0; i < count; i++)

                    {

                        cout << endl;

                        labAssistant[i].getData();

                        cout << endl;
                    }

                    break;

                case 3:
                    goto start;

                default:
                    cout << "\nInvalid choice\ntry again\n\n";
                }
            }

        case 3:
            while (1)

            {

                cout << "\n=====TOTAL INFORMATION=====\n\n";

                for (i = 0; i < count; i++)

                {

                    cout << endl;

                    teacher[i].getData();

                    cout << endl;
                }
                for (i = 0; i < count; i++)

                {

                    cout << endl;

                    labAssistant[i].getData();

                    cout << endl;
                }

                cout << "\n\nAre you Interested in entering data\n";

                cout << "Enter y or n:-";

                cin >> test;

                if (test == 'y' || test == 'Y')

                    continue;

                else
                    goto out3;
            }

        out3:

            break;

        case 4:
            goto end;
        }
    end:
        break;
    }

    return 0;
}
