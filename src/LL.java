import java.util.*;

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

    public int findKthElement(LL list, int k){
        Node pointer1 = head;
        Node pointer2 = head;
        int i=0;
        while(i<k){
            pointer1 = pointer1.next;
            i++;
        }

        while(pointer1!= null && pointer1.next!= null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        System.out.println("the kth element from the end " + pointer2.data);
        return pointer2.data;
    }

    public boolean palindrome(LL list){
        Stack<Integer> stack = new Stack<>();

        Node currentNode = head;
        while(currentNode!= null){
            stack.push(currentNode.data);
            currentNode = currentNode.next;
        }

        Node current = head;
        while(current!= null){
            if(current.data != stack.pop()){
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public boolean palidromeEfficientWay(LL list){
        Node pointer1 = head;
        Node pointer2 = head;

        while(pointer1!= null && pointer1.next!= null){
            pointer1 = pointer1.next.next;
            pointer2 = pointer2.next;
        }

        Node current = pointer2;
        Node prev = null;
        Node next = null;

        while(current!= null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        Node middlePoint = prev;
        Node startingPoint = head;

        while(middlePoint!= null && middlePoint.next!= null){
            if(startingPoint.data!= middlePoint.data){
                System.out.println(startingPoint.data + " " + middlePoint.data);
                return false;
            }
            middlePoint = middlePoint.next;
            startingPoint = startingPoint.next;
        }
        return true;

    }

    // Array questions

    // reverse an array

    public int[] reverseArray(int [] array){
        int n = array.length-1;
        int temp =0;
        for(int i=0; i<n/2; i++){
            temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
//            array[i] = array[array.length-1-i];
        }
        return array;
    }


    public static void main(String args[]){
        LL list = new LL();

        list.addNode(list, 2);
        list.addNode(list, 3);
        list.addNode(list, 4);
        list.addNode(list, 3);
        list.addNode(list, 2);

       // list.checkPalindrome(list); // uncomment for brute force
        list.findKthElement(list, 2);
        boolean result = list.palindrome(list);
        System.out.println("the linked list is palidrome " + result);
        list.checkPalindromeEfficient(list);
        boolean resultEfficientWay = list.palidromeEfficientWay(list);
        System.out.println("the efficient linked list is palidrome : " + resultEfficientWay);


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

        int [] reversedArray = list.reverseArray(new int [] {1,2,3,4,5});
        System.out.println("the reverse array is " + Arrays.toString(reversedArray));

    }
}
