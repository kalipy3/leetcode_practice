/*
 * MainClass530.java
 * Copyright (C) 2022 2022-01-26 18:03 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//请直接看这里的文字题解和代码即可

//评论区
//遇到在二叉搜索树上求什么最值啊，差值之类的，就把它想成在一个有序数组上求最值，求差值，这样就简单多了。
//最直观的想法，就是把二叉搜索树转换成有序数组，然后遍历一遍数组，就统计出来最小差值了。
//方法一
class Solution {
    private:
        vector<int> vec;
        void traversal(TreeNode* root) {
            if (root == NULL) return;
            traversal(root->left);
            vec.push_back(root->val); // 将二叉搜索树转换为有序数组
            traversal(root->right);
        }
    public:
        int getMinimumDifference(TreeNode* root) {
            vec.clear();
            traversal(root);
            if (vec.size() < 2) return 0;
            int result = INT_MAX;
            for (int i = 1; i < vec.size(); i++) { // 统计有序数组的最小差值
                result = min(result, vec[i] - vec[i-1]);
            }
            return result;
        }
};

//评论区
//以上代码是把二叉搜索树转化为有序数组了，其实在二叉搜素树中序遍历的过程中，我们就可以直接计算了。
//需要用一个pre节点记录一下cur节点的前一个节点。
//一些同学不知道在递归中如何记录前一个节点的指针，其实实现起来是很简单的，大家只要看过一次，写过一次，就掌握了。
//方法二
class Solution {
    private:
        int result = INT_MAX;
        TreeNode* pre;
        void traversal(TreeNode* cur) {
            if (cur == NULL) return;
            traversal(cur->left);   // 左
            if (pre != NULL){       // 中
                result = min(result, cur->val - pre->val);
            }
            pre = cur; // 记录前一个
            traversal(cur->right);  // 右
        }
    public:
        int getMinimumDifference(TreeNode* root) {
            traversal(root);
            return result;
        }
};
