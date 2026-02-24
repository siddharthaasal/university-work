package Recursion;

public class occurence {

    public static int firstOccurence(int arr[], int idx, int key){
        if(idx == arr.length){
            return -1;
        }
        if(arr[idx]==key){
            return idx;
        }
        return firstOccurence(arr, idx+1, key);
    }

     public static int lastOccurence(int arr[], int idx, int key){
        if(idx<0){
            return -1;
        }
        if(arr[idx]==key){
            return idx;
        }
        return lastOccurence(arr, idx-1, key);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 4, 3};
        System.out.println(firstOccurence(arr, 0, 4));
        System.out.println(lastOccurence(arr, arr.length-1, 4));
    }
}
