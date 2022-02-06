/*
 * MainClass429.java
 * Copyright (C) 2022 2022-01-26 09:29 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//kalipy一次过 bfs
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {

        if (root == null) return ans;
        Deque<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i< size; i++) {
                Node n = q.poll();
                levelList.add(n.val);

                for (int j = 0; j < n.children.size(); j++) {
                    q.offer(n.children.get(j));
                }
            }
            ans.add(levelList);
        }

        return ans;
    }

}



//官方题解 方法二 dfs
class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) traverseNode(root, 0);
        return result;
    }

    private void traverseNode(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            traverseNode(child, level + 1);
        }
    }
}
