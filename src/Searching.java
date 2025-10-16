public class Searching {
    //linear search which takes time complexity as O(n)
    public int linearSearch(int [] arr, int data){
        for(int i=0; i<arr.length; i++){
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }

    // binary search recursive way

    public int binaryRecursive(int low, int high, int arr[], int data){
        int mid = low + (high-low)/2;

        if(arr[mid]==data){
            return mid;
        }
        if(arr[mid]> data){
            return binaryRecursive(low, mid-1, arr, data);
        }
        else{
            return binaryRecursive(mid+1, high, arr, data);
        }
    }

    public int binarySearchOtherWay(int []arr, int data){
        int low = 0;
        int high = arr.length-1;
        while(low<= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == data){
                return mid;
            }
            else{
                if(arr[mid]> data){
                    high = mid -1;
                }
                else{
                    low = mid + 1;
                }
            }
        }
        return low;
    }
    // Binary search

    public int binarySearch(int [] arr, int data){
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == data){
                return mid;
            }
            if(arr[mid]>= arr[low]){
                if(data >= arr[low]&& data < arr[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                if(data > arr[mid]&& data <= arr[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String arg[]){
        int[] arr = new int[]{4,2,3,7,9, 12, 54};
        Searching searching = new Searching();
       // System.out.println(searching.linearSearch(arr, 3));
        //System.out.println(searching.binarySearch(arr, 7));
        //System.out.println(searching.binarySearchOtherWay(arr, 54));
        System.out.println(searching.binaryRecursive(0, arr.length-1, arr, 54));
    }

}
