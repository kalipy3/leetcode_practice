//先看官方题解的图，然后直接看这个代码
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;
        // 倒序遍历两个数组，将大的数从后往前插入nums1，并将指针向前移动一位，直至其中一个数组遍历完，将另一个未遍历完的数组全部插入到nums1
        while (i >= 0 && j >= 0){
            nums1[k--]=nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while(i>=0){
            nums1[k--]=nums1[i--];
        }
        while(j>=0){
            nums1[k--]=nums2[j--];
        }

    }
}

//kalipy一次过
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = nums1.length - 1;

        while (p1 >= 0 && p2 >= 0) {
           if (nums1[p1] > nums2[p2]) {//请不要犯这种错误：error:nums1[p1] > nums1[p2]！！！无数次死在这，还找不到错误所在
                nums1[tail--] = nums1[p1--];
            } else {
                nums1[tail--] = nums2[p2--];
            }
            
        }

        while (p1 >= 0) {
            nums1[tail--] = nums1[p1--];
        }

        while (p2 >= 0) {
            nums1[tail--] = nums2[p2--];
        }

       
    }
}
