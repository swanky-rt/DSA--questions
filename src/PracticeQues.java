import java.util.*;

public class PracticeQues {
    public int binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length;

        if(array.length == 0 || target <0){
            return -1;
        }

        while(left<=right){

            int mid = left + (right - left)/2;
            // 2, 3,4 ,5,6 target = 5 and mid = 4
//            if(array[mid]== target){
//                return mid;
            if(array[mid] <= target){
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }

        if(left == array.length){
            return -1;
        }
        return left;
    }



    public static void main(String args[]) {

        PracticeQues practiceQues = new PracticeQues();
        System.out.print("the found index is " + practiceQues.binarySearch(new int []{2,3,4,5,6,7}, 8));
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(2, 3);
        mp.put(4, 7);
        mp.put(3,9);

        for(Map.Entry<Integer, Integer> entry: mp.entrySet()){
            int element = entry.getKey();
            int value = entry.getValue();
            System.out.println("key is :" + element + " value is: " + value);
        }

        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3);
        set.add(4);

        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            int value = it.next();
            System.out.println(value);
        }

    }


}
