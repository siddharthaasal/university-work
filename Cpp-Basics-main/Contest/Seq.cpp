#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

bool doesContainB(int a, int b, int c)
{
    if (a == b)
        return true;

    if ((b - a) * c > 0 && (b - a) % c == 0)
        return true;

    return false;
}

int main()
{ /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int t, a, b, c;
    cin >> t;
    while (t-- > 0)
    {
        cin >> a >> b >> c;
        if (doesContainB(a, b, c) == true)

        {
            cout << "Yes" << endl;
        }
        else
        {
            cout << "No" << endl;
        }
    }
    return 0;
}
