import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MW1 {
    //inefficient way to find the highest priority

    public int getMaximumSubsets(List<Integer> start, List<Integer> end){
        int n = start.size();
        int best = 0;

        for(int i=0; i<n; i++){
            int Li = start.get(i);
            int Ri = end.get(i);
            int count = 0;
            for(int j=0; j<n; j++){
                int Lj = start.get(j);
                int Rj = end.get(j);
                if(interact(Li, Ri, Lj, Rj)){
                    count++;
                }
            }
            best = Math.max(best, count);
        }
        return best;

    }

    public boolean interact(int L1, int R1, int L2, int R2){
        return (L1<=R2) && ( L2<=R1);
    }


    // efficient way O(nlogn)

    public int getMaxSubSets(List<Integer> start, List<Integer> finish) {
        int n = start.size();
        int[] S = new int[n];
        int[] F = new int[n];

        for (int i = 0; i < start.size(); i++) {
            S[i] = start.get(i);
        }
        for (int i = 0; i < start.size(); i++) {
            F[i] = finish.get(i);
        }

        Arrays.sort(S);
        Arrays.sort(F);

        int best = 0;

        for (int i = 0; i < n; i++) {
            int L = start.get(i);// L will have elements like 1, 2, 3, 4

            int R = finish.get(i); // R will have element like 2, 3 5, 5
            System.out.println("the values are "+ L + " "+ R);

            int a = upperBound(S, R); // the values of S = 1,2,3,4 and R = 2, 3, 5, 5
            int b = lowerBound(F, L); // the values of F = 2, 3, 5, 5 and L = 1, 2, 3, 4
            System.out.println("the values of a and b are "+ a + " "+ b);
            System.out.println("the values of a - b are "+ (a-b));
            best = Math.max(best, a - b);
        }
        return best;
    }
// the values of S = 1,2,3,4 and R = 2, 3, 5, 5
    //so need to find 2 in S for the intersect
    public int upperBound(int[] arr, int x){
        int low = 0;
        int high = arr.length;

        while(low<high){
            int mid = (low+high)>>>1;
            if(arr[mid]<= x){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        System.out.println(low);
        return low;
    }

    private int lowerBound(int[] arr, int x){
        int low =0;
        int high = arr.length;

        while(low<high){
            int mid = (low+high)>>1;
            if(arr[mid] <x){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        System.out.println(low);
        return low;
    }

    public static void main(String [] args){
        List<Integer> start = new ArrayList<>();
        start.add(1);
        start.add(2);
        start.add(3);
        start.add(4);

        List<Integer> end = new ArrayList<>();
        end.add(2);
        end.add(3);
        end.add(5);
        end.add(5);

        MW1 mw1 = new MW1();
       // System.out.println(mw1.getMaximumSubsets(start, end));
        System.out.println("the best is " + mw1.getMaxSubSets(start, end));

    }
}
