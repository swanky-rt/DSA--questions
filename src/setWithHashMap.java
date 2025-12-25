import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class setWithHashMap {
    Map<Integer, Boolean> map;
    public setWithHashMap(){
        this.map = new HashMap<>();
    }

    public boolean add(int element){
        if(!map.containsKey(element)){
            map.put(element, true);
            return true;
        }
        return false;
    }

    public boolean remove(int element){
        map.remove(element);
        return true;
    }

    public boolean contains(int element){
        if(map.containsKey(element)){
            return true;
        }
        else{
            return false;
        }
    }

    public void showSet(Map<Integer, Boolean> mp){
        Iterator hm = mp.entrySet().iterator();
        while(hm.hasNext()){
            Map.Entry map = (Map.Entry) hm.next();
            int element = (int) map.getKey();
            System.out.println(element);
        }
    }

    public void printSet(Map<Integer, Boolean> mp){
        for(Map.Entry<Integer, Boolean> entry: mp.entrySet()){
            int element = entry.getKey();
            System.out.println(element);
        }
    }

    public static void main(String [] args){
        setWithHashMap set = new setWithHashMap();
        set.add(2);
        set.add(3);

        set.showSet(set.map);
        set.remove(2);

        set.printSet(set.map);
        System.out.println(set.contains(3));
    }
}
