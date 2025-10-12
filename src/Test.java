import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

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


    }


}
