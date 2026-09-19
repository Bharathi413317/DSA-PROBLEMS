class Solution {
    class NodeValue {
        public int maxNode, minNode, maxSize;

        NodeValue(int minNode, int maxNode, int maxSize) {
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }
    }

    int ans = 0;

    private NodeValue largestBSTSubtreeHelper(TreeNode root) {

        if (root == null) {
            return new NodeValue(
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                0
            );
        }

        NodeValue left = largestBSTSubtreeHelper(root.left);
        NodeValue right = largestBSTSubtreeHelper(root.right);

        if (left.maxNode < root.val && root.val < right.minNode) {

            int sum = left.maxSize + right.maxSize + root.val;

            ans = Math.max(ans, sum);

            return new NodeValue(
                Math.min(root.val, left.minNode),
                Math.max(root.val, right.maxNode),
                sum
            );
        }

        return new NodeValue(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            0
        );
    }

    public int maxSumBST(TreeNode root) {
        largestBSTSubtreeHelper(root);
        return ans;
    }
}
