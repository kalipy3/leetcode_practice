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



