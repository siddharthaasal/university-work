#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
int sumofoddFactors(int n)
{
    // Traversing through all
    // prime factors.
    int res = 1;

    // ignore even factors by
    // removing all powers of
    // 2
    while (n % 2 == 0)
        n = n / 2;

    for (int i = 3; i <= sqrt(n); i++)
    {

        // While i divides n, print
        // i and divide n
        int count = 0, curr_sum = 1;
        int curr_term = 1;
        while (n % i == 0)
        {
            count++;

            n = n / i;

            curr_term *= i;
            curr_sum += curr_term;
        }

        res *= curr_sum;
    }

    // This condition is to handle
    // the case when n is a prime
    // number.
    if (n >= 2)
        res *= (1 + n);

    return res;
}
int main()
{
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int t, n, sum = 0;
    cin >> t;
    while (t-- > 0)
    {
        cin >> n;
        sum = sumofoddFactors(n);
        cout << sum << endl;
    }
    return 0;
}