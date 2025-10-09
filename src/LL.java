import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class LL {
    static Node head;

    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public LL addNode(LL list, int data){
        Node newNode = new Node(data);

        if(list.head==null){
            head = newNode;
        }
        else{
            Node last = head;
            while(last.next!= null){
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public static void printList(LL list){
        Node current = head;
        while(current!= null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    // to check whether linked list is palindrome or not
    // use brute force

    public void checkPalindrome(LL ll){
        boolean checkPalindrome = false;
        Node current = head;
        Node check = head;
        Stack<Integer> stack = new Stack<>();
        while(current!= null){
            stack.push(current.data);
            current = current.next;
        }

        while(check!= null){
            int data = stack.pop();
            if(data == check.data){
                checkPalindrome = true;
                System.out.println("yes it is matching");
            }
            else{
                System.out.println("yes it is not matching");
                checkPalindrome = false;
                break;
            }
            check = check.next;
        }
        System.out.println("this linkedlist is palindrome " + checkPalindrome);
    }

    //efficient approach = find the middle of linked list, reverse it and then compare the element from 1st and middle till last

    public void checkPalindromeEfficient(LL list){

        boolean check = true;
        Node pointer1 = head;
        Node pointer2 = head;
        Node startingPointer = head;

        while(pointer2!= null && pointer2.next!= null){
            pointer1 = pointer1.next; // pointer1 is at middle point
            pointer2 = pointer2.next.next;
        }

        //reverse the half linked list;
        Node current = pointer1;
        Node prev = null;
        Node next = null;

        while(current!= null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        printList(list);

        while(prev!= null){
            if(prev.data!= startingPointer.data) {
                System.out.println(prev.data);
                check = false;
                break;

            }
            prev = prev.next;
            startingPointer = startingPointer.next;
        }
        System.out.println("the linked list is palindrome " + check);

    }


    public static void main(String args[]){
        LL list = new LL();

        list.addNode(list, 2);
        list.addNode(list, 3);
        list.addNode(list, 4);
        list.addNode(list, 3);
        list.addNode(list, 2);

       // list.checkPalindrome(list); // uncomment for brute force

        list.checkPalindromeEfficient(list);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,4);

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> map1 = iterator.next();
            int k = map1.getKey();
            System.out.println(k);
            int v = map1.getValue();
        }
    }
}
