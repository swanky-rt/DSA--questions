import java.util.Arrays;

public class HashMapImpl {
    int [] hashMap;
    int size;
    public HashMapImpl(){
        this.hashMap = new int[3];
        Arrays.fill(hashMap, -1);
        this.size = 0;
    }

    public void put(int key, int value) {
        if(key<0){
            throw new IllegalArgumentException("key must be non-negative");
        }
        ensureCapacity(key);
        if(hashMap[key]== -1){
            size++;
        }
        hashMap[key] = value;
    }

    public int get(int key){
        if(key<0 || key>= hashMap.length) return -1;
        return hashMap[key];
    }

    public boolean remove(int key){
        if(key<0 || key >= hashMap.length) return false;
        if(hashMap[key] == -1) return false;
        hashMap[key] = -1;
        size--;
        return true;
    }

    public Boolean contains(int key){
        return key>=0 && key< hashMap.length && hashMap[key]!= -1;
    }

    public void showHashMap(int [] arr){
        System.out.print(Arrays.toString(arr));
    }

    public void ensureCapacity(int key){
        if(key < hashMap.length) return;
        int newSize = hashMap.length;
        while(newSize<=key){
            newSize*=2;
        }
        int[] newArray = new int[newSize];
        System.arraycopy(hashMap, 0, newArray, 0, hashMap.length);
        hashMap = newArray;
    }

    public static void main(String [] args){
        try {
            HashMapImpl hashMap1 = new HashMapImpl();
            hashMap1.put(1, 2);
            hashMap1.put(2, 4);
            hashMap1.put(5, 7);

            //hashMap1.showHashMap(hashMap1.hashMap);

            hashMap1.put(3, 8);
            hashMap1.remove(3);
            hashMap1.put(2, 8);
            hashMap1.showHashMap(hashMap1.hashMap);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }


}
