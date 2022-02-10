/*
 * MainClass1361.java
 * Copyright (C) 2022 2022-02-08 16:55 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//方法一 先看官方题解
//链接：https://leetcode-cn.com/problems/validate-binary-tree-nodes/solution/tuo-bu-pai-xu-by-ohayoo-3ocu/
class Solution {
public:
    bool validateBinaryTreeNodes(int n, vector<int>& leftChild, vector<int>& rightChild) {
        vector<int> indegrees(n);
        for(int i=0;i<n;++i){
            if(leftChild[i]!=-1)
                indegrees[leftChild[i]]++;
            if(rightChild[i]!=-1)
                indegrees[rightChild[i]]++;
        }
        queue<int> q;
        for(int i=0;i<n;++i){
            if(indegrees[i]>1)return false;
            if(indegrees[i]==0)
                q.push(i);
        }
        if(q.size()>1)return false;
        int count=0;
        while(!q.empty()){
            count++;
            int k=q.front();
            q.pop();
            if(leftChild[k]!=-1){
                indegrees[leftChild[k]]--;
                if(indegrees[leftChild[k]]<0)return false;
                if(indegrees[leftChild[k]]==0)
                    q.push(leftChild[k]);
            }
            if(rightChild[k]!=-1){
                indegrees[rightChild[k]]--;
                if(indegrees[rightChild[k]]<0)return false;
                if(indegrees[rightChild[k]]==0)
                    q.push(rightChild[k]);
            }
        }
        if(count!=n)return false;
        return true;
    }
};




//方法二 不推荐 代码繁杂容易错
//链接：https://leetcode-cn.com/problems/validate-binary-tree-nodes/solution/java-bing-cha-ji-yi-ci-bian-li-xiang-xi-6450j/
class Solution {
    // 并查集用的集合列表
    List<Integer> p = new ArrayList<>();
    // 用于统计不相交的连通分支个数
    int cnt;
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // 用于标记各个孩子的父节点
        int[] father = new int[n];
        // 初始化
        Arrays.fill(father, -1);
        // 初始化并查集集合状态
        for(int i = 0; i < n; i++) p.add(i);
        // 初始化分支数
        cnt = n;
        // 遍历所有节点
        for(int i = 0; i < n; i++) {
            // 如果节点存在两个孩子，而且两个孩子相同，那么显然是错误的二叉树
            if(leftChild[i] == rightChild[i] && leftChild[i] != -1) return false;
            // 合并两个孩子
            if(!merge(father, i, leftChild[i]) || !merge(father, i, rightChild[i])) return false;
        }

        // 如果最后所有的节点组成一个连通分支，才是一棵树
        if(cnt == 1) return true;
        return false;

    }
    // 和并父亲和孩子节点，并判断逻辑
    private boolean merge(int[] father, int f, int c) {
        // 孩子是空的，直接返回
        if(c == -1) return true;
        // 孩子之前有爸爸了，就是错的
        if(father[c] != -1) return false;
        // 并查集查找两个集合的根
        int a = find(f), b = find(c);
        // 如果孩子和父亲已经存在于一个集合中，那么说明会产生环，返回错误
        if(a == b) return false;
        // 合并两个集合
        p.set(a, b);
        // 标记孩子的父亲是谁
        father[c] = f;
        // 连通分支数减一
        cnt --;
        return true;
    }
    // 并查集通用方法，找集合的根元素
    private int find(int x) {
        if(p.get(x) != x) {
            p.set(x, find(p.get(x)));
        }
        return p.get(x);
    }
}


