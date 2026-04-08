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
    boolean result = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        checkSameTree(p,q);
        return result;
        
    }

    public void checkSameTree(TreeNode p, TreeNode q){
        if ((p == null && q == null) || result != true){
            return;
        }

        if (p == null || q == null){
            result = false;
            return;
        }

        if (p.val != q.val){
            result = false;
            return;
        }

        checkSameTree(p.left, q.left);
        checkSameTree(p.right, q.right);


    }
}
