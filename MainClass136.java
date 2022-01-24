//kalipy 请重点关注下map怎么遍历key
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }

        }
        //// 1. entrySet遍历，在键和值都需要时使用（最常用）
        //for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //    System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        //}
        //// 2. 通过keySet或values来实现遍历,性能略低于第一种方式
        //// 遍历map中的键
        //for (Integer key : map.keySet()) {
        //    System.out.println("key = " + key);
        //}
        //// 遍历map中的值
        //for (Integer value : map.values()) {
        //    System.out.println("key = " + value);
        //}
        //// 4. java8 Lambda
        //// java8提供了Lambda表达式支持，语法看起来更简洁，可以同时拿到key和value，
        //// 不过，经测试，性能低于entrySet,所以更推荐用entrySet的方式
        //map.forEach((key, value) -> {
        //    System.out.println(key + ":" + value);
        //});

        // 遍历map中的键
        for (Integer key : map.keySet()) {
            System.out.println("key = " + key);
            if (map.get(key) == 1) return key;
        }
        return ans;
    }
}


//写法一
class Solution {
    public int singleNumber(int[] nums) {

        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }

        return ans;
    }
}

//官方题解 写法二
class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}


