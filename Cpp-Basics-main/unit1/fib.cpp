#include<iostream>
using namespace std;

int main(){
    int n;
    cout<< "Enter number of elements in fib series\n";
    cin >> n;
    int arr[n];
    arr[0] = 0;
    arr[1] = 1;
    for(int i=2; i<n; i++){
        arr[i] = arr[i-1] + arr[i-2];
    }
    for(int i=0; i<n; i++){
        cout << arr[i] << " ";
    }

    //missing terms
    cout << "\nMissing terms: ";
    for(int i=0; i<n-1; i++){
        if(arr[i+1]-arr[i]==0 || arr[i+1]-arr[i]==1){
            continue;
        }
        else{
            cout << arr[i] + 1 << " ";
            arr[i] = arr[i] + 1;
            i--;
        }
    }
}