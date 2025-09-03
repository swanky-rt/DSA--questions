//https://www.geeksforgeeks.org/top-50-string-coding-problems-for-interviews/

import java.util.*;

public class StringQues{
    public int countString(String s){
        int count = 0;
        boolean flag = true;
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i) == s.charAt(s.length()-1-i)){
                flag = true;
            }
            else{
                flag = false;
                break;
            }
        }
        System.out.print("String is Plaindrome: " + flag);
        return count;
    }
// Anagram: 2 strings are anagrams if they contain same elements with same frequency.
    // check1: it should contain same number of elements - check the string length.
    // check2: number of elements should be equal
    // frequency of elements should be same.
    public boolean isAnagram(String s1, String s2){
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        if(s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (map1.containsKey(s1.charAt(i))) {
                    map1.put(s1.charAt(i), map1.get(s1.charAt(i)) + 1);
                } else {
                    map1.put(s1.charAt(i), 1);
                }

            }
            for (int i = 0; i < s2.length(); i++) {
                if (map2.containsKey(s2.charAt(i))) {
                    map2.put(s2.charAt(i), map2.get(s2.charAt(i)) + 1);
                } else {
                    map2.put(s2.charAt(i), 1);
                }
            }
            if (map1.equals(map2)) {
                //System.out.println("both the strings " + s1 + " and " + s2 + " are anagram ");
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

  //let's use sliding window first.
    // we are gonna use two pointers, left and right. left and right will start pointing from zero
    //right will move and once it counters duplicate element then left will also move in right direction.

    public String findLongestSubstring(String s){

        Set<Character> hashSet = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()){
            char temp = s.charAt(right);
            if(!hashSet.contains(temp)){
                hashSet.add(temp);
                max = Math.max(max, right - left +1);
                right++;
            }
            else{
                hashSet.remove(temp);
                left++;
            }

        }
        return hashSet.toString();
        //return max;

    }

    /**
     * Valid parentheses/bracket matching
     * check1: number of similar brackets should be equal.
     * check2: open and close bracket should be simultaneouly [], {}, ()
     * check3: order should be same so [{()}]
     *
     */

    public boolean checkParanthesis(String str){
        boolean flag = false;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            switch(str.charAt(i)){
                case '(': case '{': case '[':
                    st.push(str.charAt(i));
                    break;
                case '}':
                    if (st.isEmpty() || st.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (st.isEmpty()  || st.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (st.isEmpty() || st.pop() != '(') {
                        return false;
                    }
                    break;
            }
        }
        return st.isEmpty();
    }

    // group the anagram together
    // lets check one by one if 2 string are anagrams or not,  and if yes then start putting it together.
    // if not then start putting in different list.
    //but how can we compare it with other string, that's need to be figured out.-> [[],[],[]]

    /**
     * we need 1 element, then compare with all elements, and find its anagrams and keep all in list- fixed one and compare woth
     * others. and then who ever is qualifying then keep putting in the list.
     * then take next left put element and then let it take its anagrams
     * and so on.....
     * iterate through the list and compare
     * output : aet = [eat, tea, ate]
     * @param list
     * @return
     */

    public List<List<String>> groupAnagrams(List<String> list){
        List<List<String>> anagramList = new ArrayList<>();
        Map<String, List<String>> map1 = new HashMap<>();
        for(int i=0; i<list.size(); i++){
            char [] chars = list.get(i).toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);

            if(!map1.containsKey(str)){
                List<String> list1 = new ArrayList<>();
                list1.add(list.get(i));
                map1.put(str, list1);
            }
            else{
                List<String> list1 = map1.get(str);
                list1.add(list.get(i));
                map1.put(str, list1);
            }

        }
        for(Map.Entry<String, List<String>> entry: map1.entrySet()){
            List<String> anaList = entry.getValue();
            anagramList.add(anaList);
        }
        return anagramList;
    }

    /**
     * Let's solve string compression i.e. s = aaabccccdd then output is a3b1c4d2
     * I can keep count of a till it goes and counter then put it next to the character.
     * may be add all character to make it output
     * @param str
     * @return
     */

    public String StringCompress(String str){
        StringBuilder str1 = new StringBuilder();
        char[] chars = new char[str.length()];
        Map<Character, Integer> map1 = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            if(!map1.containsKey(str.charAt(i))){
                map1.put(str.charAt(i), 1);

            }
            else{
                map1.put(str.charAt(i), (map1.get(str.charAt(i))+1));

            }
        }
        int j =0;
        for(Map.Entry<Character, Integer> entry: map1.entrySet()){
            str1.append(entry.getKey());
            str1.append(entry.getValue());
        }
        return String.valueOf(str1);

    }

    public boolean isPalindrome(String s){
        boolean flag = false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(s.length()-1-i)){
                flag = true;
            }
            else{
                flag = false;
                break;
            }

        }
        return flag;
    }



    public static void main(String[] args){
        StringQues stringQues = new StringQues();
       // System.out.println(stringQues.findLongestSubstring("abcabcd"));
        //List<List<String>> output = stringQues.groupAnagrams(Arrays.asList("cba", "ate", "eat", "acab", "tea", "abc"));
        //System.out.println(output);

        //System.out.println(stringQues.StringCompress("aaaabbbbcccddeeeeea"));
        //System.out.println(stringQues.checkParanthesis("[{()}]"));
        //System.out.println(stringQues.checkParanthesis("[]{}()"));
        //System.out.println(stringQues.checkParanthesis("{[()]}"));
        System.out.println(stringQues.checkParanthesis("{[()}"));


        //stringQues.isAnagram("listen", "silent");
        //stringQues.countString("AartiitraA");

        //System.out.println("the given string is palindrome? " + stringQues.isPalindrome("AartiitraA"));
        //System.out.printlm("the count is "+ stringQues.countString("ABAAAC"));
    }

}
