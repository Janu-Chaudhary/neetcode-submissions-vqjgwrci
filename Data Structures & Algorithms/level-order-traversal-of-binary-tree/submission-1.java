class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelView = new ArrayList<>();
        
        // Guard clause: Handle empty tree safely
        if (root == null) {
            return levelView;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            levelView.add(level);
        }

        return levelView;
    }
}
