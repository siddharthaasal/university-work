package Java;

public class MergeSort {
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
    public static void mergeSort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = (si+ei)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i=si, j=mid+1, k=0;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            }
            else{
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        while(i<=mid){
            temp[k] = arr[i];
            i++;
            k++;
        }
        while(j<=ei){
            temp[k]=arr[j];
            j++;
            k++;
        }

        i = si;
        for(k=0; k<temp.length; k++){
            arr[i] = temp[k];
            i++;
        }


    }
    public static void main(String[] args) {
        int arr[] = {5,4,2,3,1};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
