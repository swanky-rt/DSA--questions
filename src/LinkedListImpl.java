public class LinkedListImpl {
    static Node head;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

        public void addNode(LinkedListImpl list, int data){
            Node node = new Node(data);

            if(LinkedListImpl.head == null){
                head = node;
            }
            else{
                Node lastNode = head;
                while(lastNode.next!= null){
                    lastNode = lastNode.next;
                }
                lastNode.next = node;
            }

        }

        public void showLinkedList(LinkedListImpl list){
            Node currentNode = head;
            while(currentNode!= null){
                System.out.print(currentNode.data + "-> ");
                currentNode = currentNode.next;
            }
        }

        public static void main(String [] args){
            LinkedListImpl list = new LinkedListImpl();
            list.addNode(list, 2);
            list.addNode(list, 4);
            list.addNode(list, 6);
            list.addNode(list, 8);

            list.showLinkedList(list);
        }

}
