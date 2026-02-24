package Java;

public class SelectionSort {
    static void selectionSort(int arr[], int n) {
        int i, j, min_idx, temp = 0;

        for (i = 0; i < n - 1; i++) {
            min_idx = i;
            for (j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }

            if (min_idx != i)
                temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    static void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int arr[] = { 64, 25, 12, 22, 11 };
        int n = arr.length;

        // Function Call
        selectionSort(arr, n);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }

}
