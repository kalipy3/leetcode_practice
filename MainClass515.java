/*
 * MainClass515.java
 * Copyright (C) 2022 2022-02-18 15:01 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//方法一 bfs 送分 略

//方法二 dfs
//通过深度优先遍历算法，配合一个List集合来求每层最大值，这里巧妙利用索引来表示层数，list集合中索引为0的位置记录的是第1层最大值，以此类推。如果当前层数还没有添加过元素，就默认当前值为当前层数的最大值，如果有值就取出，和对应的层数最大值进行比较，如果当前值更大就更新对应层数最大值。
class Solution {
    //保存对应层数的最大值，第一层的最大值在索引为0处，第二层在1处
    private List<Integer> list = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        dfs(root,1);
        return list;
    }
    //深度遍历
    private void dfs(TreeNode node,int depth){
        if(node == null){
            return;
        }
        //如果当前层数还没有添加过值，就默认当前值是当前层数最大的值
        //如果当前层已经有最大值，就取出当前层最大值和当前值比较，如果当前值更大就更新对应层数的最大值
        if(depth > list.size()){
            list.add(node.val);
        }else if(depth <= list.size()){
            int max = list.get(depth-1);
            max = node.val > max ? node.val : max;
            list.set(depth-1,max);
        }
        //继续递归左右子树
        dfs(node.left,depth+1);
        dfs(node.right,depth+1);
    }
}

