#include<iostream>
using namespace std;

int* create_array(int size){
    int* arr = new int[size];
    cout<<"Enter "<<size<<" elements: ";
    for(int i=0; i<size; i++){
        cin>>arr[i];
    }
    return arr;  //returns pointer to the first element
}

void print_array(int arr[], int size){
    cout<<"The array is: ";
    for(int i=0; i<size; i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}

int* insert_element(int arr[], int& size, int element, int index){  //size as a reference

    if(index<0 || index>size){
        cout << "Invalid position!" << endl;
        return arr;
    }

    int* new_arr = new int[size+1];
    for(int i=0; i<index; i++){
        new_arr[i] = arr[i]; //copy prev
    }
    new_arr[index]  = element; //insert
    for(int i=index; i<size; i++){
        new_arr[i+1] = arr[i]; //copy rest
    }

    delete[] arr;
    size++;
    return new_arr;

}

int* delete_element(int arr[], int& size, int index){

     if(index<0 || index>size){
        cout << "Invalid position!" << endl;
        return arr;
    }

    int* new_arr = new int[size-1];
    for (int i = 0; i < index; i++) {
        new_arr[i] = arr[i]; //copy prev
    }
    for (int i = index; i < size - 1; i++) {
        new_arr[i] = arr[i + 1];  //copy rest (except index)
    }

    delete[] arr;
    size--;
    return new_arr;
}

int main(){
    int size;
    cout << "Enter the size of array: ";
    cin >> size;

    int* arr = create_array(size);

    print_array(arr, size);

    int element, index;
    cout << "Enter the element that you want to enter: ";
    cin >> element;
    cout << "Enter the index where you want to enter: ";
    cin >> index;

    arr = insert_element(arr, size, element, index);
    print_array(arr, size);

    cout << "Enter the index of the element you want to delete (0-based index): ";
    cin >> index;

    arr = delete_element(arr, size, index);
    print_array(arr, size);

    delete[] arr;
    return 0;
}