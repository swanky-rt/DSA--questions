import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class LutronsSpecificQuestions {
    // lets remove the duplicate email address from the array


    //brute force
    public String[] removeDuplicates(String[] emailLists) {
        int write =0;
        for (int i = 0; i < emailLists.length; i++) {
            for (int j = 0; j < i; j++) {
                if (emailLists[i].equals(emailLists[j])) {
                  System.out.println(emailLists[j]);
                    emailLists[j] = "null";
                }
            }
        }
        return emailLists;
    }

    public String[] removeZeros(String[] emailsLists){
        int write = 0;
        for(int i=0; i<emailsLists.length; i++){
            if(!emailsLists[i].equals("null")){
                emailsLists[write++] = emailsLists[i];
            }
        }
        return Arrays.copyOf(emailsLists, write);
    }

    // efficient way

    public void removeDuplicatesEfficiently(String[]emailLists){
        int count = 0;
        LinkedHashSet<String> nonDuplicateEmailLists = new LinkedHashSet<>();
        for(int i=0; i<emailLists.length; i++){
            if(nonDuplicateEmailLists.contains(emailLists[i])){
                count++;
            }
            nonDuplicateEmailLists.add(emailLists[i]);

        }
        System.out.println("there are total " + count + " duplicates email address");
        Iterator<String> iterator = nonDuplicateEmailLists.iterator();
        while(iterator.hasNext()){
            String email = iterator.next();
            System.out.println(email);
        }
    }

    public static void main(String args[]) {

        String[] emailLists = new String[]{
                "alex.jordan23@gmail.com",
                "mia_lee89@yahoo.com",
                "mia_lee89@yahoo.com",
                "rohit.kumar@outlook.com",
                "jackson.brown@students.edu",
                "sophie.tanaka@protonmail.com",
                "daniel.martins@icloud.com",
                "nina.patel@example.com",
                "michael_ross123@hotmail.com",
                "emily.wu@company.org",
                "jackson.brown@students.edu",
                "olivia.green@myemail.net",
                "nina.patel@example.com",
                "michael_ross123@hotmail.com"};

        LutronsSpecificQuestions lutronsSpecificQuestions = new LutronsSpecificQuestions();

        // undo below lines for brute force
        //String[] updatedEmailLists = lutronsSpecificQuestions.removeDuplicates(emailLists);
        //String[] nonDuplicatesEmailLists = lutronsSpecificQuestions.removeZeros(updatedEmailLists);
        //System.out.println(Arrays.toString(nonDuplicatesEmailLists));
        lutronsSpecificQuestions.removeDuplicatesEfficiently(emailLists);

    }
}
