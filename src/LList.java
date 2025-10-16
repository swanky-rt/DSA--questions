public class  LList {
    Node head;
    static class Node{
        private int data;
        private Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    public LList addNode(LList node, int data){
        Node newNode = new Node(data);
        if(node.head == null){
            node.head= newNode;
        }
        else{
            Node last = head;
            while(last.next!= null){
                last = last.next;
            }
            last.next = newNode;

        }
        return node;
    }

    public LList removeNode(LList node, int data){
        Node current = head;
        Node prev;
        while(current.data!= data){
            current = current.next;
        }
        prev = current.next;
        current.next = prev.next;
        prev.next = null;

        return node;

    }

    public void traverseLinkedList(LList node){
        Node current = head;
        while(current!= null){
            System.out.println(current.data);
            current = current.next;
        }
    }
   public static void main(String args[]){
        LList list = new LList();
        list.addNode(list,3);
       list.addNode(list,2);
       list.addNode(list,8);
       list.traverseLinkedList(list);
       System.out.println("removing the element");
       list.removeNode(list, 2);
       list.traverseLinkedList(list);
   }





}
