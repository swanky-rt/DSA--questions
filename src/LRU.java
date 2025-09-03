import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRU {
    private int capacity;
    private Map<Integer, Integer> map;
    private LinkedList<Integer> linkedList;

    LRU(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.linkedList = new LinkedList<>();

    }

    public int getKey(int key){
        //verify if the key is present in hashmap
        if(!map.containsKey(key))
            return -1;
        // move
        linkedList.remove(Integer.valueOf(key));
        linkedList.addFirst(key);
        return map.get(key);
    }

    // method to put the key and value
    public void putKey(int key, int value){
        if(map.containsKey(key)){
            map.put(key, value);
            linkedList.remove(Integer.valueOf(key));
        }
        else{
            // if map reaches more than or equal to it's capacity
            // we need to remove the least used data from the list.
            if(map.size()>= capacity){
                int leastUsedKey = linkedList.removeLast();
                map.remove(leastUsedKey);
            }
            map.put(key, value);
        }
        linkedList.addFirst(key);
    }
}
