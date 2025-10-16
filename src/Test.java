import java.util.*;

public class Test {


    //["aarti123@gmail.com", "amit@gmail.com", "aarti123@gmail.com"]

    public ArrayList<String> getUniqueList(String [] arrList){
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<arrList.length; i++){
            set.add(arrList[i]);
        }

        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String email = iterator.next();
            //System.out.println(email);
            list.add(email);
        }
        return list;
    }

    public static void main(String args []){
        String [] arr = new String[]{"aarti123@gmail.com", "amit@gmail.com", "aarti123@gmail.com"};
        Test test = new Test();
        ArrayList<String> arrList = test.getUniqueList(arr);

        for(String st : arrList){
            System.out.println(st);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            int x = entry.getKey();
            int y = entry.getValue();

        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int a = entry.getKey();
            int b = entry.getValue();
        }



    }


}
