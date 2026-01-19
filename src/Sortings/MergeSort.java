package Sortings;

public class MergeSort {
    public static void merge(int [] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2= r-m;

        int [] L = new int[n1];
        int [] R = new int[n2];

        for(int i=0; i<n1; i++){
            L[i] = arr[l+i];
        }

        for(int j=0; j<n2; j++){
            R[j] = arr[m+1+j];
        }

        int i=0;
        int j = 0;
        int K = l;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[K] = L[i];
                i++;
            }
            else{
                arr[K] = R[j];
                j++;
            }
            K++;

        }

        while(i<n1){
            arr[K] = L[i];
            i++;
            K++;
        }
        while(j<n2){
            arr[K] = R[j];
            j++;
            K++;
        }

     }

     public static void mergeSort(int [] arr, int l, int r){
        if(l<r){
            int m = l +(r-l) /2; // middle point
            mergeSort(arr, l, m);

            mergeSort(arr, m+1, r);

            merge(arr, l, m, r);
        }
     }

     public static void main(String arg []) {
         int[] arr = new int[]{38, 27, 43, 10, 45};

         mergeSort(arr, 0, arr.length-1);
         for(int i=0; i<arr.length; i++){
             System.out.println(arr[i] + " ");
         }
     }
}
