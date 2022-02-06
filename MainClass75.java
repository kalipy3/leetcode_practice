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

//方法二
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
