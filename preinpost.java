import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

class Solution {

    public void preInPost(TreeNode root) {

        if (root == null) return;

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();

        while (!st.isEmpty()) {

            Pair it = st.pop();

            // Preorder
            if (it.num == 1) {
                pre.add(it.node.val);
                it.num++;
                st.push(it);

                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            }

            // Inorder
            else if (it.num == 2) {
                in.add(it.node.val);
                it.num++;
                st.push(it);

                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            }

            // Postorder
            else {
                post.add(it.node.val);
            }
        }

        System.out.println("Preorder  : " + pre);
        System.out.println("Inorder   : " + in);
        System.out.println("Postorder : " + post);
    }
}

public class Main {
    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \   /
            4   5 6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        Solution obj = new Solution();
        obj.preInPost(root);
    }
}
