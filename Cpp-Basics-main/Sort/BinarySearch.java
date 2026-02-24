package DataStructures;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the no. of elements of the array: ");
        int n = kb.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter "+n+" elements of the array in sorted fashion: ");
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        System.out.println("Enter the element to be searched: ");
        int search_item = kb.nextInt();

        int low = 0;
        int high = arr.length-1;
        int index = -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==search_item){
                index = mid;
                break;
            }
            else if(arr[mid]>search_item){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        if(index==-1){
            System.out.println("Element not found");
        }
        else{
            System.out.println("Element found at index "+index);
        }



    }
}
