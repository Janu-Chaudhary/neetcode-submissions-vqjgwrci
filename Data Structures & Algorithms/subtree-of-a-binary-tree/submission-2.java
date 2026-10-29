class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case: If the main tree is empty, subRoot cannot be inside it
        if (root == null) {
            return false;
        }

        // Even if the current node values match, we use || (OR) 
        // because if check() fails, the subtree might still be hidden deeper down.
        if (root.val == subRoot.val && check(root, subRoot)) {
            return true;
        }

        // Return the boolean results of checking the left OR right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean check(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null){
            return true;
        }

        if (root == null || subRoot == null || root.val != subRoot.val){
            return false;
        }

        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }
}
