package DataStructures;

public class QuickSort {
    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei]; //last
        int i = si-1;  //swap location
        for(int j=si; j<=ei-1; j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[ei]; //pivot
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }
    public static void quickSort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
        int pivotIndex = partition(arr,si,ei);
        quickSort(arr,si,pivotIndex-1);//left sub-array
        quickSort(arr,pivotIndex+1,ei);//right sub-array

    }
    public static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++)
        System.out.print(arr[i]+" ");
    }
    public static void main(String[] args) {
        int arr[] = {3,8,5,7,4,6};
        quickSort(arr,0,arr.length-1);
        printArray(arr);
    }
}


/*
 * quickSort(array, leftmostIndex, rightmostIndex)
  if (leftmostIndex < rightmostIndex)
    pivotIndex <- partition(array,leftmostIndex, rightmostIndex)
    quickSort(array, leftmostIndex, pivotIndex - 1)
    quickSort(array, pivotIndex, rightmostIndex)

partition(array, leftmostIndex, rightmostIndex)
  set rightmostIndex as pivotIndex
  storeIndex <- leftmostIndex - 1
  for i <- leftmostIndex + 1 to rightmostIndex
  if element[i] < pivotElement
    swap element[i] and element[storeIndex]
    storeIndex++
  swap pivotElement and element[storeIndex+1]
return storeIndex + 1

 */