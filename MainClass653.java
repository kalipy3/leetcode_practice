/*
 * MainClass653.java
 * Copyright (C) 2022 2022-01-27 13:13 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//请直接看代码 简单

//评论区 
public boolean findTarget(TreeNode root, int k) {
    HashSet<Integer> hashset = new HashSet<Integer>();
    return preOrder(root,hashset,k);     
}
public boolean preOrder(TreeNode root,HashSet<Integer> hashset,int k){
    if(root == null)
        return false;
    if(hashset.contains(k - root.val)){
        return true;
    }
    hashset.add(root.val);        
    return preOrder(root.left,hashset,k) || preOrder(root.right,hashset,k);
}

//评论区
//中序遍历数到数组里，在双指针找
class Solution {
public:
    bool findTarget(TreeNode* root, int k) {
        vector<int> res;
        inorder(root,res);
        int left = 0;
        int right = res.size()-1;
        while(left<right)
        {
            int sum = res[left] + res[right];
            if(sum == k) return true;
            else if(sum < k) //和比目标值小，则移动左指针 
            {
                left++;
            }
            else 
            {
                right--; //和比目标值大，则移动右指针 
            }
        }
        return false;
        
    }
    void inorder(TreeNode *root,vector<int> &res)
    {
        if(root)
        {
            inorder(root->left,res);
            res.push_back(root->val);
            inorder(root->right,res);
        }
    }
};

