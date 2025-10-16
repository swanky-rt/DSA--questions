import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MiscellaneousQues {
    //Fibanocci series

    // iterative way
    public void fibonacciSeries(int n){
        int a =0;
        int b = 1;
        for(int i=0; i<n; i++){
            System.out.println(a);
            int c = a+b;
            a = b;
            b = c;
        }
    }

    // prefix sum
    public ArrayList<Integer> sumPrefix(int[] arr){
        ArrayList<Integer> sum = new ArrayList<>();
        sum.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            sum.add(sum.get(i-1) + arr[i]);
        }
        return sum;
    }

    // recursive way

    public int fibonacciSeriesRecursive(int n){
        if(n<=1){
            return n;
        }
        return fibonacciSeriesRecursive(n-1) + fibonacciSeriesRecursive(n-2);
    }

    // dynamic array

    public int dynamicFibnacciSeries(int n){
        int [] f = new int[n+2];
        f[0] = 0;
        f[1] = 1;

        for(int i=2; i<=n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    // minimum swapping to make it sorting
    public int sortArrayWithMinSwap(int[] arr){
        HashMap <Integer, Integer> map = new HashMap<>();
        int[] tempArray = arr.clone();
        Arrays.sort(tempArray);

        for(int i=0; i<arr.length; i++){
            map.put(arr[i], i);
        }

        int countSwap = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i]!= tempArray[i]){
                int index = map.get(tempArray[i]);

                //swapping
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;

                // updating hash map
                map.put(arr[i], i);
                map.put(arr[index], index);
                countSwap++;
            }
        }
        return countSwap;

    }

    public int[][] maxDuration(int [][] pairs){
        int maxDuration = pairs[0][1];
        int longestCharId = pairs[0][0];
        int previousTime = pairs[0][1];
        int[][] output = new int[2][2];
        for(int i=1; i<pairs.length; i++){
            int currentTime = pairs[i][1] - previousTime;
            if(currentTime>maxDuration|| currentTime== maxDuration && pairs[i][0] > longestCharId){
                maxDuration = Math.max(currentTime, maxDuration);
                longestCharId = pairs[i][0];
            }
            previousTime = pairs[i][1];
        }
        output[0][0] = maxDuration;
        output[0][1] = longestCharId;

        return output;
    }

    // inefficient way

    public boolean getPair(int [] arr, int sum){
        boolean value = false;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i] + arr[j]== sum){
                    return true;
                }
            }
        }
        return false;
    }

    // efficient way

    public boolean getPairs(int[] arr, int sum){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], i);
            }
        }
        for (int j : arr) {
            if (map.containsKey(sum - j)) {
                return true;
            }
        }
        return false;
    }

// find the elements less than or equal in other unsorted array

    public int[] getNumbers(int[]a, int []b){

        int [] output = new int[b.length];
        int count;
        for(int i=0; i<a.length; i++){
            count = 0;
            for(int j=0; j<b.length; j++){
                if(b[j]<=a[i]){
                    count++;
                }
                output[i] = count;
            }
        }
        return output;
    }

    public int[] getNumberEfficient(int[] a, int[]b){
        Arrays.sort(b);
        int[] result = new int[a.length];
        for(int i=0; i<a.length; i++){
            result[i] = upperBoundBinarySearch(b, a[i], b.length-1, 0);
        }
        return result;
    }

    public int upperBoundBinarySearch(int [] arr, int data, int high, int low){
        while(low<high) {
            int mid = low + (high - low)/2;
            if (arr[mid] <= data) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String args[]){
        int n = 10;
        MiscellaneousQues miscellaneousQues = new MiscellaneousQues();
        //miscellaneousQues.fibonacciSeries(n);

//        for(int i=0; i<n; i++){
//            System.out.println(miscellaneousQues.fibonacciSeriesRecursive(i));
//        }

        for(int i=0; i<n; i++){
            //System.out.println(miscellaneousQues.dynamicFibnacciSeries(i));
        }
        int [] num = new int[] {10, 19, 6, 3, 5};
        //System.out.println(miscellaneousQues.sortArrayWithMinSwap(num));

        int [][] pairs = new int[][]{{0,5}, {2,20}, {1,22}};
        int [][] output = miscellaneousQues.maxDuration(pairs);
        System.out.println(output[0][0]);
        int number = output[0][1];
        char ch = (char) ('a' + number);
        System.out.println(ch);
        ArrayList<Integer> output1 = miscellaneousQues.sumPrefix(num);
        for(int i=0; i<num.length; i++) {
            System.out.println(output1.get(i) + " ");
        }
        System.out.println(miscellaneousQues.getPair(num, 39));
        System.out.println(miscellaneousQues.getPairs(num, 18));

        int [] a = new int[]{4, 8, 7, 5, 1};
        int [] b = new int[]{4, 48, 3, 0, 1, 1, 5};
        int [] numbers = miscellaneousQues.getNumberEfficient(a, b);
        System.out.println("the numbers are: ");
        for(int i=0; i<a.length; i++) {
            System.out.print(numbers[i] + " ");
        }

    }
}
