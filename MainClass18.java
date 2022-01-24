// 思路:
// 四数之和与前面三数之和的思路几乎是一样的，嗝。（刚好前些天才写了三数之和的题解）
// 如果前面的三数之和会做了的话，这里其实就是在前面的基础上多添加一个遍历的指针而已。
// 会做三数之和的可以不用看下面的了。。
//  
// 使用四个指针(a<b<c<d)。固定最小的a和b在左边，c=b+1,d=_size-1 移动两个指针包夹求解。
// 保存使得nums[a]+nums[b]+nums[c]+nums[d]==target的解。偏大时d左移，偏小时c右移。c和d相
// 遇时，表示以当前的a和b为最小值的解已经全部求得。b++,进入下一轮循环b循环，当b循环结束后。
// a++，进入下一轮a循环。 即(a在最外层循环，里面嵌套b循环，再嵌套双指针c,d包夹求解)。
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) { // O(n^3)
        List<List<Integer>> res  =  new ArrayList<>();

        Arrays.sort(nums); // O(nlogn)
        int len = nums.length;
        for(int i = 0; i < len - 3; i++) {   // O(n^3)
            if (i > 0 && nums[i] == nums[i-1]) {
                continue; // 跳过重复 
            }
            for (int j = i + 1; j < len - 2; j++) { // same as threeSum  O(n^2)
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue; // 跳过重复
                }
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // 跳过重复, 可以先不看
                        while(left < right && nums[left+1] == nums[left]) left++;
                        while (left < right && nums[right-1] == nums[right]) right--;

                        // 逼近中间
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else { // sum < target
                        left++;
                    }
                }
            }
        }

        return res;
    }
}
