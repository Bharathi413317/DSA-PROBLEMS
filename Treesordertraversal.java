// Online Java Compiler
// Use this editor to write, compile and run your Java code online
class Node{
    int data;
    Node left;
    Node right;
    public Node(int key){
        this.data=key;
    }
}
class Main {
    public static void main(String[] args) {
       Node root=new Node(1);
       root.left=new Node(2);
       root.right=new Node(3);
       root.left.left=new Node(9);
       root.left.right=new Node(10);
       root.right.left=new Node(12);
       root.right.right=new Node(18);
       root.left.left.left=new Node(20);
       preorder(root);

    }
public static void preorder(Node root){
    if (root == null)
    return;
    System.out.println(root.data);
    preorder(root.left);
    preorder(root.right);
}
}
