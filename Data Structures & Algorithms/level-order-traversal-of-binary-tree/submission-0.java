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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){return result;}

        List<TreeNode> frontier = new ArrayList<>();

        frontier.add(root);

        while(!frontier.isEmpty()){
            int size = frontier.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++){
                TreeNode node = frontier.remove(0);

                level.add(node.val);

                if(node.left != null){
                    frontier.add(node.left);
                }

                if(node.right != null){
                    frontier.add(node.right);
                }
            }

            result.add(level);
        }

        return result;
        
    }
}
