//推荐方法三
//kalipy一次过
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int t = map.get(nums[i]);
                map.put(nums[i], ++t);
            }

            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) > nums.length/2) return nums[i];
            }

        }

        return 0;
    }
}

//方法二
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length/2];
    }
}

//方法三 类比消消乐
作者：gfu
链接：https://leetcode-cn.com/problems/majority-element/solution/3chong-fang-fa-by-gfu-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
//1 2 1
    public int majorityElement(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i])
                ++count;
            else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }
}


//方法三 kalipy一次过 推荐
class Solution {
    public int majorityElement(int[] nums) {
        int candi = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (candi == nums[i]) {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    candi = nums[i];
                    cnt = 1;
                }
            }
        }
        return candi;
    }
}

