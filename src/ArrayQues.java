import java.util.*;

public class ArrayQues {

    /*
    need to remove duplicates from sorted array.

    1. we can iterate arrays from left- we can have 2 pointer- I can keep one pointer on the first element or
    first unique element and my second pointer will start moving and then the  moment second pointer and first pointer facing
    different element, assign first pointer to second pointer.

    algo:
    pointer 1, pointer 2 - arr[0]
    for(){
    pointer2 = arr[i]
    if(pointer1 == pointer[2]){
    remove the element from the array}
    else{
    pointer 2 = pointer 1
    }
     */
    public List<Integer> getUniqueArray(int [] num){
        List<Integer> arrayList = new ArrayList<>();
        for(int i=0; i<num.length; i++){
            arrayList.add(num[i]);
        }
        int pointer1 =0;
        int pointer2;
        for(int i=0; i<arrayList.size(); i++){
            pointer2 = arrayList.get(i);
            if( pointer2 == pointer1){
                arrayList.set(i,  -1);
            }
            else{
                pointer1 = arrayList.get(i);
            }

        }
        for(int i=arrayList.size()-1; i>=0; i--){
            if(arrayList.get(i)==-1){
                arrayList.remove(i);
            }
        }
        return arrayList;
    }

    /*
    Two sum: given number and array, find all the pairs whose sum is equal to given sum.
    iterate through array, and find pairs, sum it and then check.
    we can use hashmap. put all the number and then check the sum of it.
     */

    public List<List<Integer>> findPairs(int sum, int[] num){
        List<List<Integer>> output = new ArrayList<>();

        Map<Integer, Integer> map1 = new HashMap<>();
        for(int i=0; i<num.length; i++){
            map1.put(i, num[i]);
        }
        for(int i=0; i<num.length; i++){
            if(map1.get(num[i])!=null && map1.containsValue(sum- map1.get(num[i]))){
                List<Integer> pairs = new ArrayList<>();
                pairs.add(sum - map1.get(num[i]));
                pairs.add(map1.get(num[i]));
                output.add(pairs);
            }
        }
        return output;
    }

    /*
    Best Time to Buy and Sell Stock: Find the maximum profit from buying and selling a stock.

    given an array, you need to find the maximum profit, need to decide when to buy and sell it off.
    first find the minimum and profit in one iteration.
    key thing: take one pointer, point to first element and check the profit too.
     */

    public int sellAndBuy(int[] num){
        int min_price =Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;

        for(int i=0; i<num.length; i++){
            min_price = Math.min(num[i], min_price);
            profit = Math.max(profit, num[i]-min_price);
        }
        return profit;
    }

    /*
    rotate the array by given number of times either clock wise or anti-clock wise

    example = [1,2,3] if k=2 then output would be [3,1,2]-> [[2,3,1]( clockwise)

    lets use recursion:
    first reverse d elements of array, then reverse subarray containing (n-d)
    and then reverse entire array.
    reverse function which will swap two elements.
    we are using recursion so we will call it 3 times - for 0 - d-1( first d elements), d - n-1( for d to n elementd), 0 - n-1
    then for full array
     */

    public void rotateArray(int [] arr, int d){

        int n = arr.length;
        d %= n;

        reverse(0, d-1, arr);

        reverse(d,n-1, arr);

        reverse(0, n-1, arr);
    }

    public void reverse(int start, int end, int[]arr){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /*
    Move zeros: Move all zeros to the end of an array while maintaining the relative order of non-zero elements.

    I can use hashmap, save elements with its index, and find number of zeros and then who ever element has more than that
    index then subtract the position by its number of zeros, and zeros will have its last array's position one by one
     */

    public void moveZeros(int [] num){
        int counter =0;
        for(int i=0; i<num.length; i++){
            if(num[i]!= 0){
                int temp = num[i];
                num[i] = num[counter];
                num[counter] = temp;
                counter ++;
            }
        }
    }

    /*
    three number product.
    given an array, need to multiply every numbers except that number and it has to be done in O(n) without using the division operation.
    case1: if there is no zero, then multiply all elements and divide it by that number to return the product.
    case 2: if there is one zero, then logic will be changed as dividing by zero will be undefined so - here the product will be
    rest of the other elements.
    case 3: if there are more than one zero then product will always be zero.
     */

    public int [] getProduct(int [] nums){
        int count = 0;
        int product = 1;
        int idx = -1;
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                idx = i;
            }
            else {
                product = product * nums[i];
            }
        }
        System.out.println(" product" + product);

        for(int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                count += 1;
                if (count > 1) {
                    System.out.println("code is coming here");
                    result[i] = 0;
                }
            }
        }

        for(int i=0; i<nums.length; i++){
            if(count==1 && nums[i] == 0){
                result[i] = product;
            }
            else if(count==0){
                result[i] = product/nums[i];
            }
            else{
                 result[i] = 0;
            }

                }

        return result;


    }


    public static void main(String[] arg){
        ArrayQues arrayQues= new ArrayQues();
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1,1,2));
        int [] num = {2,3,5,6,8,0};
        List<List<Integer>> output = arrayQues.findPairs(8, num);
        //System.out.println(output);
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        //System.out.println(arrayQues.getUniqueArray(arr));
        int [] nums = new int[]{7, 1, 5, 3, 6, 4};
        //System.out.println(arrayQues.sellAndBuy(nums));
        int[] rotate = new int[]{1,2,3,4,5, 6};

        arrayQues.rotateArray(rotate, 2);
        for(int i=0; i<rotate.length; i++){
            System.out.print(rotate[i] + " ");
        }

        int [] moveZeros = new int[]{1,0,3,4,0,0,2};
        arrayQues.moveZeros(moveZeros);
        System.out.println("Here the move zeros elements");
        for(int i=0; i<moveZeros.length; i++){
            System.out.print(moveZeros[i] + " ");
        }

        int [] input = new int[]{10, 3, 5, 6, 2, 0};
        int [] getProduct = arrayQues.getProduct(input);

        System.out.println("Here the products");

        for(int i=0; i<input.length; i++){
            System.out.print(getProduct[i] + " ");
        }
    }

    public void getNames(String name){
        System.out.print("my name is " + name);
    }
}
