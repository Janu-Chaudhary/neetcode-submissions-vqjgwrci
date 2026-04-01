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
    boolean res = true; 
    public boolean isSameTree(TreeNode p, TreeNode q) {
        check(p, q);
        return res;
    }

    void check(TreeNode p, TreeNode q) {
        if (res != true) return;

        if (p == null && q == null) return;

        if (p == null || q == null) {
            res = false;
            return;
        }

        if (p.val != q.val) {
            res = false;
            return;
        }

        check(p.left, q.left);
        check(p.right, q.right);
    }
}
