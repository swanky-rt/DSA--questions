package Sortings;

public class InsertionSort {

    // insertion sort
    public int[] insertionSort(int[] arr){
        int n = arr.length;
        for(int i=1; i<n; i++){
            int key = arr[i];
            System.out.println(" the key is " + key);
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }

        return arr;

    }
// bubble sort
    public int[] bubbleSort(int [] arr){

        for(int i=0; i<arr.length; i++){
            boolean swapped = false;

            for(int j=0; i<arr.length; i++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if(swapped){
                break;
            }
        }
        return arr;
    }

    // selection sort

    public int [] selectionSort(int [] arr){
        int n = arr.length;

        for(int i=0; i<arr.length; i++){
            int min_index = i;
            for(int j=0; j<arr.length; j++){
                if(arr[j]< arr[min_index]){
                    min_index = j;
                }

            }

            if(arr[min_index]>arr[i]){
                int temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
            }

        }
        return arr;
    }
    public static void main(String args[]){
        InsertionSort sort = new InsertionSort();

        int [] arr = new int[]{2,1,3,6,4};
        int [] output = sort.insertionSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.println(output[i]);
        }

        System.out.println("implementing bubbble sort");
        int [] bubbleSort = sort.bubbleSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(bubbleSort[i] + " ");
        }

        System.out.println("implementing selection sort");
        int [] selection = sort.selectionSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(selection[i] + " ");
        }


        int a = 2;
        int b = 3;

        a = a + b; // 5
        b = a - b; //5-3 = 2
        a = a - b; // 5-2

        System.out.println(a + " " + b);
    }
}
