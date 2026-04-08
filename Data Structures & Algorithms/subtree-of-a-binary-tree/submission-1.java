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
    boolean result = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        locateSameRoot(root, subRoot);
        return result;
    }

    public void locateSameRoot(TreeNode root, TreeNode subRoot){
        if (root == null || result == true){
            return;
        }

        if (root.val == subRoot.val){
            if(checkSameTree (root, subRoot)){
                result = true;
                return;
            }
        }

        locateSameRoot(root.left,subRoot);
        locateSameRoot(root.right, subRoot);

    }

    boolean checkSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){ 
            return true;
        }

        if (p == null || q == null){

         return false;}

        if (p.val != q.val) {
            return false;
        }
        
        return checkSameTree(p.left, q.left) && checkSameTree(p.right, q.right);
    }
}
