import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//        链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-bai-liao-9983de-javayong-hu-by-reedfan/
class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {//等号一定不能少
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}

//很多人问，那里为什么是小于等于。其实就是为了最后只剩两个数的时候，怎么和我那个逻辑匹配。用小于也可以，参考下面的写法。
//写法二
public int search(int[] nums, int target) {
    if(nums == null || nums.length == 0){
        return -1;
    }
    int start = 0;
    int end = nums.length - 1;

    while (start <= end){
        int mid = start + (end -start)/2;
        if (nums[mid] == target){
            return mid;
        }

        //后半部分有序
        if(nums[mid] < nums[end]){
            if(nums[mid] < target && target <= nums[end]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        } else {
            if(nums[mid] > target && target >= nums[start]){
                end = mid - 1;

            } else {
                start = mid + 1;

            }


        }
    }
    return -1;

}
