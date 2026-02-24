package SearchingAndSorting;

import java.util.Scanner;
class ArrayCRUD{

    public static void createArray(int arr[]){
        Scanner kb = new Scanner(System.in);
        for(int i=0; i<arr.length; i++){
            System.out.println("Enter element "+ (i+1));
            arr[i] = kb.nextInt();
        }
        System.out.println("Array created successfully");
    }
    public static void printArray(int arr[]){
        System.out.print("Array -> ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
    public static int[] insert(int arr[], int element, int index){
        if(index<0 || index>=arr.length){
            System.err.println("Invalid index");
            return arr;
        }
        else{
            int newArr[] = new int[arr.length+1];
            int i=0;
            for(i=0; i<index; i++){
                newArr[i] = arr[i];
            }
            newArr[i] = element;
            for(i=index+1; i<newArr.length; i++){
                newArr[i] = arr[i-1];
            }
            System.out.println("Element inserted successfully");
            return newArr;
        }
    }
    public static int[] delete(int arr[], int index){
         if(index<0 || index>=arr.length){
            System.err.println("Invalid index");
            return arr;
        }
        else{
            int newArr[] = new int[arr.length-1];
            int i=0;
            for(i=0; i<index; i++){
                newArr[i] = arr[i];
            }
            for(i=index; i<newArr.length; i++){
                newArr[i] = arr[i+1];
            }
            System.out.println("Element deleted successfully");
            return newArr;
        }
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        boolean flag = true;
        int arr[] = null;
        while(flag){
            System.out.println("Enter Choice: \n 1 - Create Array \n 2 - Print Array \n 3 - Insert Elemet \n 4 - Delete Element \n 5 - Exit");
            int choice = kb.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Enter size");
                    int size = kb.nextInt();
                    arr = new int[size];
                    createArray(arr);
                    break;
                case 2:
                    printArray(arr);
                    break;
                case 3:
                    System.out.println("Enter the element you want to insert");
                    int element = kb.nextInt();
                    System.out.println("Enter the index where you want to insert it");
                    int index = kb.nextInt();
                    arr = insert(arr, element, index);
                    break;
                case 4:
                    System.out.println("Enter the index of the element you want to delete");
                    int idx = kb.nextInt();
                    arr = delete(arr, idx);
                    break;
                case 5:
                    flag = false;
                    System.out.println("Programs ended");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
    }
}