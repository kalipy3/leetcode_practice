//方法一
class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        int index = 0;
        for (int i = 0; i != count[0]; ++i) {
            nums[index++] = 0;
        }
        for (int i = 0; i != count[1]; ++i) {
            nums[index++] = 1;
        }
        for (int i = 0; i != count[2]; ++i) {
            nums[index++] = 2;
        }
    }
}

//官方题解 方法二
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }
}


//推荐的方法三
https://www.bilibili.com/video/BV1Jg411M7Lp?p=2

https://leetcode-cn.com/problems/sort-colors/solution/kuai-su-pai-xu-partition-guo-cheng-she-ji-xun-huan/
public class Solution {

    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }

        // all in [0, zero) = 0
        // all in [zero, i) = 1
        // all in [two, len - 1] = 2

        // 循环终止条件是 i == two，那么循环可以继续的条件是 i < two
        // 为了保证初始化的时候 [0, zero) 为空，设置 zero = 0，
        // 所以下面遍历到 0 的时候，先交换，再加
        int zero = 0;

        // 为了保证初始化的时候 [two, len - 1] 为空，设置 two = len
        // 所以下面遍历到 2 的时候，先减，再交换
        int two = len;
        int i = 0;
        // 当 i == two 上面的三个子区间正好覆盖了全部数组
        // 因此，循环可以继续的条件是 i < two
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                swap(nums, i, two);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

//写法二
class Solution {
    public void sortColors(int[] nums) {
        int head = 0;
        int i = 0;
        int tail = nums.length - 1;
        
        while(i <= tail){
            if (nums[i] == 0) {
                swap(nums, i, head);
                i++;
                head++;
            }
            else if (nums[i] == 2) {
                swap(nums, i, tail);
                tail--;
            }
            else if (nums[i] == 1) {
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
}
