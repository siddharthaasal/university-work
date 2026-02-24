package SearchingAndSorting;

class BinarySearch{
    public static int binarySearch(int arr[], int key){
        int si = 0, ei = arr.length-1;
        while(si<=ei){
            int mid = (si+ei)/2;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]>key){
                ei = mid-1;
            }
            else{
                si = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println(binarySearch(arr, 2));
    }
}