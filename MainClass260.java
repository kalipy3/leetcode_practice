//kalipy一次过
class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {


            if (set.contains(nums[i]))
                set.remove(nums[i]);
            else
                set.add(nums[i]);
        }

        //或者这样遍历set,不能set.get(index),set没有get()方法
        //int res[] = new int[2];
        //int i=0;
        //for (Integer s : s1) {
        //    res[i++]=s;
        //}
        Object[] list = set.toArray();
        return new int[]{(int)list[0], (int)list[1]};
    }
}

//方法二 请一定要看下面的方法二易错点
//先看这个题解 然后直接看代码
//https://leetcode-cn.com/problems/single-number-iii/solution/czhi-chu-xian-yi-ci-de-shu-zi-jin-jie-ji-trtq/
class Solution {
    public int[] singleNumber(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        //int k = 1;
        //while (true) {//不知道为什么这样会死循环
        //    if ((ans & k) == 1) break;
        //    k <<= 1;
        //}
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}

//方法二易错点 注释掉的写法都是错误的写法，比特位的比较建议无脑和0比较，不要和1比较
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int p = 1;
        //while ((xor&p) != 1) {
        while ((xor&p) == 0) {
            p = (p << 1);//不要去掉括号
        }

        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            //if ((p&nums[i]) == 1) {
            if ((p&nums[i]) != 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
            }

        return new int[]{a, b};
        }
        }
