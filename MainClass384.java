/*
 * MainClass384.java
 * Copyright (C) 2022 2022-02-17 23:57 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

class Solution {
    int[] nums;
    int[] original;

    public Solution(int[] nums) {
        this.nums = nums;
        this.original = new int[nums.length];
        System.arraycopy(nums, 0, original, 0, nums.length);
    }

    public int[] reset() {
        System.arraycopy(original, 0, nums, 0, nums.length);
        return nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < nums.length; ++i) {
            int j = i + random.nextInt(nums.length - i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}

链接：https://leetcode-cn.com/problems/shuffle-an-array/solution/gong-shui-san-xie-xi-pai-suan-fa-yun-yon-0qmy/
class Solution {
    int[] nums;
    int n;
    Random random = new Random();
    public Solution(int[] _nums) {
        nums = _nums;
        n = nums.length;
    }
    public int[] reset() {
        return nums;
    }
    public int[] shuffle() {
        int[] ans = nums.clone();
        for (int i = 0; i < n; i++) {
            swap(ans, i, i + random.nextInt(n - i));
        }
        return ans;
    }
    void swap(int[] arr, int i, int j) {
        int c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}

//证明
https://leetcode-cn.com/problems/shuffle-an-array/solution/wei-rao-li-lun-jing-dian-xi-pai-suan-fa-11ona/

//写法三
借鉴Collections.shuffle()方法，从后向前遍历洗牌，可以更方便的限定交换范围
class Solution {

    int[] array;
    int[] original;

    private Random rand = new Random();

    private void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public Solution(int[] nums) {
        array = nums;
        original = array.clone();
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }
    //Jdk  Collections.shuffle()方法 
    public int[] shuffle() {
        for(int i=array.length;i>1;i--){
            swap(i-1, rand.nextInt(i));
        }

        return array;
    }
}


