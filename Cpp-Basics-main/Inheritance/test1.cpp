#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    long long t;
    cin >> t;
    while (t-- > 0)
    {
        int sum = 0;
        string s;
        cin >> s;
        // s = transform(s.begin(), s.end(), s.begin(), ::tolower);
        for (unsigned long long i = 0; i < s.length(); i++)
        {
            if (s[i] >= 'A' && s[i] <= 'Z')
            {
                s[i] = s[i] + 32;
            }
            int ascii = s[i];
            if (ascii % 3 == 1)
                sum += 1;
            else if (ascii % 3 == 2)
                sum += 2;
            else
                sum += 3;
        }
        cout << sum << endl;
    }
    return 0;
}
