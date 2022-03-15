/*
 * MainClass863.java
 * Copyright (C) 2022 2022-01-26 13:05 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//请看官方题解 讲得很好
//方法一
class Solution {
    Map<Integer, TreeNode> parents = new HashMap<Integer, TreeNode>();
    List<Integer> ans = new ArrayList<Integer>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 从 root 出发 DFS，记录每个结点的父结点
        findParents(root);

        // 从 target 出发 DFS，寻找所有深度为 k 的结点
        findAns(target, null, 0, k);

        return ans;
    }

    public void findParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    public void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            ans.add(node.val);
            return;
        }
        if (node.left != from) {
            findAns(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            findAns(node.right, node, depth + 1, k);
        }
        if (parents.get(node.val) != from) {
            findAns(parents.get(node.val), node, depth + 1, k);
        }
    }
}


//先看这个题解：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/solution/gong-shui-san-xie-yi-ti-shuang-jie-jian-x6hak/
//方法二(看完评论区的代码后，再去看题解的代码)
//评论区 看不懂建图的可以看看这里，用一个map来表达邻接表，键是节点，值是该节点的邻接节点
class Solution {
    Map<Integer,List<Integer>> adj = new HashMap<>();//邻接表，键为节点，值为节点的邻接节点
    Set<Integer> visit = new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode t, int k) {
        List<Integer> ans = new ArrayList<>();
        dfs(root);//构建无向图
        //图的BFS遍历
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(t.val);
        visit.add(t.val);
        while (!d.isEmpty() && k >= 0) {
            int size = d.size();//一次遍历一层
            for(int i = 0;i < size;i++) {
                int cur = d.pollFirst();
                if (k == 0) {
                    ans.add(cur);
                    continue;
                }
                //把邻接节点放入队列
                List<Integer> adjNodes = adj.get(cur);
                if(adjNodes == null) continue;
                for (int node:adjNodes) {
                    if (!visit.contains(node)) {
                        d.addLast(node);
                        visit.add(node);
                    }
                }
            }
            k--;
        }
        return ans;
    }

    public void add(int a, int b){
        if(adj.get(a) == null){
            List<Integer> list = new ArrayList<>();
            list.add(b);
            adj.put(a,list);
        }else{
            List<Integer> list = adj.get(a);
            list.add(b);
            adj.put(a,list);
        }
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            //构建无向图的边
            add(root.val, root.left.val);
            add(root.left.val, root.val);
            dfs(root.left);
        }
        if (root.right != null) {
            add(root.val, root.right.val);
            add(root.right.val, root.val);
            dfs(root.right);
        }
    }
}

//方法二 写法二 bfs
class Solution {
    // 根据数据范围最多有 501 个点，每个点最多有 2 条无向边（两个子节点）
    int N = 510, M = N * 4;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int idx;
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }
    boolean[] vis = new boolean[N];
    public List<Integer> distanceK(TreeNode root, TreeNode t, int k) {
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(he, -1);
        dfs(root);
        Deque<Integer> d = new ArrayDeque<>();
        d.addLast(t.val);
        vis[t.val] = true;
        while (!d.isEmpty() && k >= 0) {
            int size = d.size();
            for (int ii = 0; ii < size; ii++) {
            // (size-- > 0) {
                int poll = d.pollFirst();
                if (k == 0) {
                    ans.add(poll);
                    continue;
                }
                for (int i = he[poll]; i != -1 ; i = ne[i]) {
                    int j = e[i];
                    if (!vis[j]) {
                        d.addLast(j);
                        vis[j] = true;
                    }
                }
            }
            k--;
        }
        return ans;
    }
    void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            add(root.val, root.left.val);
            add(root.left.val, root.val);
            dfs(root.left);
        }
        if (root.right != null) {
            add(root.val, root.right.val);
            add(root.right.val, root.val);
            dfs(root.right);
        }
    }
}

//方法三 dfs
class Solution {
    // 根据数据范围最多有 501 个点，每个点最多有 2 条无向边（两个子节点）
    int N = 510, M = N * 4;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int idx;
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }
    boolean[] vis = new boolean[N];
    public List<Integer> distanceK(TreeNode root, TreeNode t, int k) {
        List<Integer> ans = new ArrayList<>();
        Arrays.fill(he, -1);
        dfs(root);
        vis[t.val] = true;
        find(t.val, k, 0, ans);
        return ans;
    }
    void find(int root, int max, int cur, List<Integer> ans) {
        if (cur == max) {
            ans.add(root);
            return ;
        }
        for (int i = he[root]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!vis[j]) {
                vis[j] = true;
                find(j, max, cur + 1, ans);
            }
        }
    }
    void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            add(root.val, root.left.val);
            add(root.left.val, root.val);
            dfs(root.left);
        }
        if (root.right != null) {
            add(root.val, root.right.val);
            add(root.right.val, root.val);
            dfs(root.right);
        }
    }
}
