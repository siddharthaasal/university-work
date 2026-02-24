#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int t;
    cin >> t;
    while (t-- > 0)
    {
        int bit = 1, nibble = 0, byte = 0;
        int n;
        cin >> n;
        for (int i = 1; i < n; i++)
        {
            if (i % 2 == 0)
            {
                bit--;
                nibble++;
            }
            if (i % 8 == 0)
            {
                nibble--;
                byte++;
            }
            if (i % 16 == 0)
            {
                byte--;
                bit += 2;
            }
        }
        cout << bit << " " << nibble << " " << byte << endl;
    }
    return 0;
}
