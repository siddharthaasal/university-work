#include<iostream>
using namespace std;

int main(){

    int rows, columns, baseAdress, sizeOfElement;
    int lr = 0, lc = 0; //Lower Bounds of rows and columns

    cout<<"Enter the dimensions of a matrix: ";
    cin>>rows>>columns;
    int arr[rows][columns];

    cout<<"Enter the elements of the matrix: \n";
    for(int i=0; i<rows; i++){
        for(int j=0; j<columns; j++){
            cin>>arr[i][j];
        }
    }

    cout<<"Enter the base adress: ";
    cin>>baseAdress;
    cout<<"Enter the size of an element: ";
    cin>>sizeOfElement;

    int i = rows-1;
    int j = columns-1;

    int adress = baseAdress + sizeOfElement*(columns*(i-lr) + (j-lc));

    cout<<"Required adress is: "<<adress;


}