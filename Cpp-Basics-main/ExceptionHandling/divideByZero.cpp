#include <iostream>
#include <stdexcept>
using namespace std;

float CheckDenominator(float den)
{
    if (den == 0)
        throw "Error";
    else
        return den;
}

int main()
{
    float numerator, denominator, result;
    numerator = 2.5;
    denominator = 0;

    try
    {
        if (CheckDenominator(denominator))
        {

            result = (numerator / denominator);
            cout << "The quotient is "
                 << result << endl;
        }
    }

    catch (...)
    {
        cout << "Divide by Zero exception occurred" << endl;
    }
}
