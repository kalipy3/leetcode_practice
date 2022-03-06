/*
 * MainClass496.java
 * Copyright (C) 2022 2022-02-27 11:43 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//请先看503题 这两题都是送分题

//官方题解
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[m];
        for (int i = 0; i < m; ++i) {
            int j = 0;
            while (j < n && nums2[j] != nums1[i]) {
                ++j;
            }
            int k = j + 1;
            while (k < n && nums2[k] < nums2[j]) {
                ++k;
            }
            res[i] = k < n ? nums2[k] : -1;
        }
        return res;
    }
}

//方法二
//评论区
//通过Stack、HashMap解决
//
//    1.先遍历大数组nums2，首先将第一个元素入栈；
//    2.继续遍历，当当前元素小于栈顶元素时，继续将它入栈；当当前元素大于栈顶元素时，栈顶元素出栈，此时应将该出栈的元素与当前元素形成key-value键值对，存入HashMap中；
//    3.当遍历完nums2后，得到nums2中元素所对应的下一个更大元素的hash表；
//    4.遍历nums1的元素在hashMap中去查找‘下一个更大元素’，当找不到时则为-1。

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> hasMap = new HashMap<Integer, Integer>();
        
        int[] result = new int[nums1.length];
        
        for(int num : nums2) {
            while(!stack.isEmpty() && stack.peek()<num){
                hasMap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        for(int i = 0; i < nums1.length; i++) result[i] = hasMap.getOrDefault(nums1[i], -1);
            
        return result;
    }
}

//kalipy一次过
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int ans[] = new int[n1];
        Deque<Integer> st = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n2; i++) {
            while (!st.isEmpty() && nums2[i] > nums2[st.peek()]) {
                map.put(nums2[st.pop()], nums2[i]);
            }

            st.push(i);
        }

        for (int i = 0;  i < n1; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}
