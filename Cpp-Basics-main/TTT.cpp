#include <iostream>
using namespace std;

void printBoard(char arr[])
{
    cout << "______" << endl;
    cout << "" << endl;
    for (int i = 0; i < 9; i += 3)
    {
        cout << arr[i] << " " << arr[i + 1] << " " << arr[i + 2] << " " << endl;
    }
    cout << "______" << endl;
    cout << "" << endl;
}
bool wonOrNot(char arr[])
{
    // 1
    if (arr[0] == arr[1])
    {
        if (arr[1] == arr[2])
        {
            return true;
        }
    }

    // 2
    if (arr[0] == arr[3])
    {
        if (arr[3] == arr[6])
        {
            return true;
        }
    }

    // 3
    if (arr[0] == arr[4])
    {
        if (arr[4] == arr[8])
        {
            return true;
        }
    }

    // 4
    if (arr[1] == arr[4])
    {
        if (arr[4] == arr[7])
        {
            return true;
        }
    }

    // 5
    if (arr[2] == arr[5])
    {
        if (arr[5] == arr[8])
        {
            return true;
        }
    }

    // 6
    if (arr[2] == arr[4])
    {
        if (arr[4] == arr[6])
        {
            return true;
        }
    }

    // 7
    if (arr[3] == arr[4])
    {
        if (arr[4] == arr[5])
        {
            return true;
        }
    }

    // 8
    if (arr[6] == arr[7])
    {
        if (arr[7] == arr[8])
        {
            return true;
        }
    }

    return false;
}
int main()
{
    char square[9] = {'0', '1', '2', '3', '4', '5', '6', '7', '8'};

    int turn = 0; // 0--> X  1-->Y
    bool win = false;
    bool play = true;

    while (play == true)
    {
        printBoard(square);

        for (int i = 0; i < 9; i++)
        {

            if (turn == 0)
            {
                cout << "X-Turn" << endl;
                turn = 1;
                cout << "Write the number of the place where you want to insert X" << endl;
                int input;
                cin >> input;
                square[input] = 'X';
                cout << "Now the game looks like:" << endl;
                printBoard(square);
                if (wonOrNot(square) == true)
                {
                    win = true;
                    cout << "X won" << endl;
                    break;
                }
            }
            else
            {
                cout << "Y-Turn" << endl;
                turn = 0;
                cout << "Write the number of the place where you want to insert O" << endl;
                int input;
                cin >> input;
                square[input] = 'O';
                cout << "Now the game looks like:" << endl;
                printBoard(square);
                if (wonOrNot(square) == true)
                {
                    win = true;
                    cout << "Y won" << endl;
                    break;
                }
            }
        }

        if (win == false)
        {
            cout << "It's a Tie" << endl;
        }

        cout << "Do you want to play again: "
             << "Enter 1 if yes, 0 if No" << endl;
        int check;
        cin >> check;
        if (check == 1)
        {
            char ch = '0';
            for (int i = 0; i <= 8; i++)
            {
                square[i] = ch;
                ch++;
            }
            turn = 0;
            win = false;
            play = true;
        }
        else if (check == 0)
        {
            cout << "Thank you for playing";
            play = false;
        }
        else
        {
            "Invalid Choice";
            break;
        }
    }
}