class Solution {

    int postindex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postindex = postorder.length - 1;

        return build(inorder, 0, inorder.length - 1, postorder);
    }

    public TreeNode build(int[] inorder, int is, int ie,
                          int[] postorder) {

        if (is > ie) {
            return null;
        }

        // Last unused element of postorder is root
        TreeNode root = new TreeNode(postorder[postindex]);

        // Find root in inorder
        int index = is;

        while (index <= ie && inorder[index] != root.val) {
            index++;
        }

        // Move backwards in postorder
        postindex--;

        // RIGHT FIRST because we are going backwards
        root.right = build(
            inorder,
            index + 1,
            ie,
            postorder
        );

        // LEFT SECOND
        root.left = build(
            inorder,
            is,
            index - 1,
            postorder
        );

        return root;
    }
}