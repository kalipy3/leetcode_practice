//kalipy
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        if (root == null) return ans;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tNode = q.poll();
                level.add(tNode.val);

                if (tNode.left != null) q.offer(tNode.left);
                if (tNode.right != null) q.offer(tNode.right);
            }
            ans.add(level);
        }

        return ans;
    }
}
