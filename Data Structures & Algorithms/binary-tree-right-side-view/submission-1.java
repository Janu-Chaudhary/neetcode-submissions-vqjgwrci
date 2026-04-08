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
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {

        List<TreeNode> frontier = new ArrayList<>();

        frontier.add(root);

        while (!frontier.isEmpty()){

            int size = frontier.size();
            result.add(frontier.get(size-1).val);

            for (int i= 0; i < size; i++){

                TreeNode node = frontier.remove(0);

                if (node.left != null){
                    frontier.add(node.left);

                }
                
                if(node.right !=null){
                    frontier.add(node.right);
                }
                
            }
        }
        return result;
    }
}
