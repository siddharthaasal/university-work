#include <iostream>
using namespace std;

int main() {
    cout << "Enter no. of subjects: \n";
    int s;
    cin >> s;
    float arr[s];
    float sum =0;
    for(int i=0; i<s; i++){
        cin >> arr[i];
        sum+=arr[i];
    }
    cout << "Average: " << sum/s;
}