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
    int Diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculate(root);
        return Diameter;
        
    }

    public int calculate(TreeNode root){
        if(root == null){return 0;}

        int leftH = calculate(root.left);
        int rightH = calculate(root.right);

        Diameter = Math.max(Diameter, leftH+rightH);

        return 1 + Math.max(leftH, rightH);
    }
}
