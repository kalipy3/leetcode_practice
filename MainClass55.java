//推荐方法三

//kalipy一次过 在45题基础上修改少量代码即可，关键是第10行
class Solution {
    public boolean canJump(int[] nums) {
//2 1 1 0 4
        int end = 0;
        int maxPosition = 0; 
        //int steps = 0;
        //for(int i = 0; i < nums.length-1; i++){
        for(int i = 0; i < nums.length; i++){
            if (i > end) return false;
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i); 
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                //steps++;
            }
        }
        return true;

    }
}

//写法二
//1. 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
//2. 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
//3. 如果可以一直跳到最后，就成功了

class Solution {
public:
//2 1 1 0 4
    bool canJump(vector<int>& nums) {
        int k = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i > k) return false;
            k = max(k, i + nums[i]);
        }
        return true;
    }
};

//方法三 评论区
//想象你是那个在格子上行走的小人，格子里面的数字代表“能量”，你需要“能量”才能继续行走。
//每次走到一个格子的时候，你检查现在格子里面的“能量”和你自己拥有的“能量”哪个更大，取更大的“能量”！ 如果你有更多的能量，你就可以走的更远啦！~
class Solution {
public:
    bool canJump(vector<int>& nums)
    {
        if(nums.size() == 0)
            return true;

        int cur = nums[0], i = 1;
        for(; cur != 0 && i < nums.size(); i++)
        {
            cur--;
            if(cur < nums[i])
                cur = nums[i];
        }
        return i == nums.size();
    }
};


//kalipy一次过 非常推荐 送分题
//想象你是那个在格子上行走的小人，格子里面的数字代表“能量”，你需要“能量”才能继续行走。
class Solution {
    public boolean canJump(int[] nums) {
        int cur = nums[0];//当前能量
        for (int i = 1; i < nums.length; i++) {
            cur--;//每跳一下能量减1
            if (cur < 0) return false;

            cur = Math.max(cur, nums[i]);//选取大的能量
        }

        return true;
    }
}
