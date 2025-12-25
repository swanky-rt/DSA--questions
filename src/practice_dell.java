import java.util.Arrays;

/**
 * case 1: implement add method which will add the element using fixed array or dynamic array - it will first check
 * whether the element is existing or not.o(n)
 * case 2: remove method - to remove the element if it is there else return false. - O(n)
 * case 3: implement contains method to check whether the element is present or not.
 *
 * corner case: 1. handle the duplicates
 * 2. don't allow duplicates
 * 3. if fixed arrays then handle index out of bound error.- behaviour on empty sets
 * 4. remove an element which doesn't exist.
 *
 */
public class practice_dell {

    int [] array;
    int size;

    public practice_dell(){
        this.array = new int[5];
        this.size = 0;
    }

    public boolean contains(int element){
        for(int i=0; i<size; i++){
            if(array[i]== element){
                return true;
            }
        }
        return false;
    }
    public boolean add(int element){
            if(contains(element)){
                return false;
            }
            ensureCapacity();
            array[size++] = element;
            return true;
    }

    public boolean remove(int element){
        for(int i=0; i<size; i++){
            if(array[i]== element){
//                int temp = array[i];
                array[i] = array[size-1];
                array[size-1] = 0;
                size--;
                return true;

            }
        }
        return false;
    }

    public void ensureCapacity(){
        if(size == array.length){
            int newSize = array.length*2;
            int [] newArray = new int[newSize];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public void showElements(int [] array){
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args){
        practice_dell p = new practice_dell();
        p.add(2);
        p.add(3);
        p.add(2);
        p.remove(3);
//        p.showElements(p.array);

        p.remove(3);

        p.add(3);
        p.add(4);
        p.add(5);
        p.add(6);
        p.add(7);
        p.add(8);

        p.showElements(p.array);

        p.contains(3);

    }


}
