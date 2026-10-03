class Solution {

    List<Integer> succPredBST(TreeNode root, int key) {

        List<Integer> lst = new ArrayList<>();

        int succ = Successor(root, key);
        int pred = Predecessor(root, key);

        lst.add(pred);
        lst.add(succ);

        return lst;
    }

    public int Successor(TreeNode root, int p) {

        TreeNode succ = null;

        while (root != null) {

            if (p >= root.data) {
                root = root.right;
            } 
            else {
                succ = root;
                root = root.left;
            }
        }if (succ == null)
            return -1;

        return succ.data;
    }

    public int Predecessor(TreeNode root, int p) {

        TreeNode pred = null;

        while (root != null) {

            if (p <= root.data) {
                root = root.left;
            } 
            else {
                pred = root;
                root = root.right;
            }
        }if (pred == null)
            return -1;

        return pred.data;
    }
}
