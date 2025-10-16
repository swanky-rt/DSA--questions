public class TreeQues {
    Node root;
    public static class Node {
        int data;
        Node left = null;
        Node right = null;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
        public int mirrorAndHeight(Node root){
            if(root == null){
                return 0;
            }
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;

            int h1 = mirrorAndHeight(root.left);
            int h2 = mirrorAndHeight(root.right);
            return 1 + (Math.max(h1, h2));
        }

        public void traverseTree(Node root){ // level order
            if(root == null){
                return;
            }
            traverseTree(root.left);
            System.out.print(root.data+ " ->");
            traverseTree(root.right);
        }
    public static void main(String args[]){
        TreeQues treeQues = new TreeQues();
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left= new Node(5);
        root.left.right = new Node(1);
        root.right.right = new Node(17);
        root.right.left = new Node(21);

        treeQues.traverseTree(root);
        System.out.println("after mirroring");
        System.out.println("the height is " + treeQues.mirrorAndHeight(root));
        treeQues.traverseTree(root);
    }

}
