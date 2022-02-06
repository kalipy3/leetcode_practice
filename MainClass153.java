//请对比剑指offer11题,offer11题只需在这153题基础上加一行代码`r--`即可

//用互为旋转的[1,2]和[2,1]去理解最方便

//写法二
作者：armeria-program
链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/er-fen-cha-zhao-wei-shi-yao-zuo-you-bu-dui-cheng-z/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    //用互为旋转的[1,2]和[2,1]去理解最方便
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {          
                left = mid + 1;
            } else {//这里直接写else if(nums[mid] < nums[right])也行   <=也行                             
                right = mid;
            }
        }
        return nums[left];//nums[right]也行
    }
}


