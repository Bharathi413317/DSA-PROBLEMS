import java.util.*;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Solution {

    // Find maximum distance from target node
    private static int findMaxDistance(
            HashMap<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap,
            BinaryTreeNode<Integer> target) {

        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        HashMap<BinaryTreeNode<Integer>, Boolean> visited = new HashMap<>();

        q.offer(target);
        visited.put(target, true);

        int maxTime = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            int flag = 0;

            for (int i = 0; i < size; i++) {

                BinaryTreeNode<Integer> node = q.poll();

                // Burn left child
                if (node.left != null &&
                    visited.get(node.left) == null) {

                    flag = 1;
                    visited.put(node.left, true);
                    q.offer(node.left);
                }

                // Burn right child
                if (node.right != null &&
                    visited.get(node.right) == null) {

                    flag = 1;
                    visited.put(node.right, true);
                    q.offer(node.right);
                }

                // Burn parent
                if (parentMap.get(node) != null &&
                    visited.get(parentMap.get(node)) == null) {

                    flag = 1;
                    visited.put(parentMap.get(node), true);
                    q.offer(parentMap.get(node));
                }
            }

            // If at least one new node was burned,
            // one unit of time has passed.
            if (flag == 1) {
                maxTime++;
            }
        }

        return maxTime;
    }


    // Create parent mapping and find target node
    private static BinaryTreeNode<Integer> bfsToMapParents(
            BinaryTreeNode<Integer> root,
            HashMap<BinaryTreeNode<Integer>,
                     BinaryTreeNode<Integer>> parentMap,
            int start) {

        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();

        q.offer(root);

        BinaryTreeNode<Integer> target = new BinaryTreeNode<>(-1);

        while (!q.isEmpty()) {

            BinaryTreeNode<Integer> node = q.poll();

            // Find the target node
            if (node.data == start) {
                target = node;
            }

            // Process left child
            if (node.left != null) {

                parentMap.put(node.left, node);

                q.offer(node.left);
            }

            // Process right child
            if (node.right != null) {

                parentMap.put(node.right, node);

                q.offer(node.right);
            }
        }

        return target;
    }


    // Main function
    public static int timeToBurnTree(
            BinaryTreeNode<Integer> root,
            int start) {

        // Map each node to its parent
        HashMap<BinaryTreeNode<Integer>,
                BinaryTreeNode<Integer>> parentMap = new HashMap<>();

        // Find target node and create parent map
        BinaryTreeNode<Integer> target =
                bfsToMapParents(root, parentMap, start);

        // Start burning from target
        int maxTime = findMaxDistance(parentMap, target);

        return maxTime;
    }
}
