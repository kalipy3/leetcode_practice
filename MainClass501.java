/*
 * MainClass501.java
 * Copyright (C) 2022 2022-03-16 17:19 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//请直接看官方题解

//kalipy一次过
class Solution {
    List<Integer> answer = new ArrayList<Integer>();
    int pre, count, maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;

    }

    public void dfs(TreeNode o) {
        if (o == null) {
            return;
        }
        dfs(o.left);
        update(o.val);
        dfs(o.right);
    }

    public void update(int x) {
        if (x == pre) {
            count++;
        } else {
            count = 1;
            pre = x;
        }

        if (count == maxCount) {
            answer.add(x);
        }

        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(x);
            //answer.add(pre);//也ok
        }
    }
}
