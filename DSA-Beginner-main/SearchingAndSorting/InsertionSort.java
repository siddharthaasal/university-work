package SearchingAndSorting;

class InsertionSort{
    public static void insertionSort(int arr[]){
        for (int i = 1; i < arr.length; i++) { // current element
            int currentElement = arr[i];
            int j = i - 1;
            while (j >= 0 && currentElement < arr[j]) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = currentElement;
        }
            
    }
    public static void print(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {3,1,4,5,2};
        insertionSort(arr);
        print(arr);
    }
}
