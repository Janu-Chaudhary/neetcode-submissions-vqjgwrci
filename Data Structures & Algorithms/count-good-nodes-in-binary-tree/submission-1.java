/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        // Start the recursion with the root node and its own value as the initial maximum
        return dfs(root, root.val);
    }

    public int dfs(TreeNode node, int maxSoFar) {
        // Base case: an empty node doesn't contribute any good nodes
        if (node == null) {
            return 0;
        }

        int count = 0;

        // If the current node's value is >= the max value seen on this path, it's a good node
        if (node.val >= maxSoFar) {
            count = 1;
            // Update the maximum value for the subsequent path
            maxSoFar = node.val;
        }

        // Recursively count good nodes in the left and right subtrees
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        return count;
    }
}

