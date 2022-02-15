//推荐看这个代码和注释题解描述
//从后往前维护一个单调栈 若出现了栈顶元素比当前元素小的情况 说明找到了一个中间元素 大于它后面的元素 与此同时由于单调栈的特性我们维护的这个“后面的元素”会尽可能大，只要存在一个前面的元素比它小即可

//eg:
//官方题解讲得太多了，没看懂，这个看懂了 说下理解，就是单调栈维护的是3，max_k维护的是2，枚举的是1， max_k来源与单调栈，所以其索引一定大于栈顶的元素，但其值一定小于栈顶元素，故栈顶元素就是3，即找到了对“32”。 于是当出现nums[i] < max_k时，即找到了"12"，这个时候一定会有3个元素的，而栈顶3必定大于2，故也大于1，即满足“132”
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int last = Integer.MIN_VALUE; // 132中的2
        Stack<Integer> sta = new Stack<>();// 用来存储132中的3
        if(nums.length < 3)
            return false;
        for(int i=n-1; i>=0; i--){

            if(nums[i] < last) // 若出现132中的1则返回正确值
                return true;

            // 若当前值大于或等于2则更新2（2为栈中小于当前值的最大元素,之所以要在2小于3的前提下保持2尽可能大，是因为接下来让1有更大的可能小于3）
            while(!sta.isEmpty() && sta.peek() < nums[i]){
                last = Math.max(last, sta.pop());
                // 事实上，k 的变化也具有单调性，直接使用 last=sta.pop() 也是可以的
            }

            // 将当前值压入栈中
            sta.push(nums[i]);
        }
        return false;
    }
}




//方法三
class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        for(int k=nums.length - 1;k >= 0;k--){
           //寻找大于和小于的数
           int i, j, index = 0;
           boolean findLow = false;
            while(index < k){
                //如果没找到小的
                if(!findLow && nums[index] < nums[k]){
                    i = index;
                    findLow = true;
                }
                //如果找到小的且满足大的，直接返回
                if(findLow && nums[index] > nums[k]){
                    return true;
                }
                index++;
            }
        }
        return false;
    }
}


