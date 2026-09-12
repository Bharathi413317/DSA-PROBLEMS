import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int key) {
        this.data = key;
    }
}

class Main {

    public static List<List<Integer>> levelorder(Node root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<Node> que = new LinkedList<>();

        que.offer(root);

        while (!que.isEmpty()) {

            int size = que.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                Node current = que.poll();

                level.add(current.data);

                if (current.left != null)
                    que.offer(current.left);

                if (current.right != null)
                    que.offer(current.right);
            }

            ans.add(level);
        }

        return ans;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(9);
        root.left.right = new Node(10);
        root.right.left = new Node(12);
        root.right.right = new Node(18);
        root.left.left.left = new Node(20);

        System.out.println(levelorder(root));
    }
}
