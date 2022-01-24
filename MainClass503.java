////暴力破解
//var nextGreaterElements = function(nums) {
//    //定义arr空数组接收结果
//    let arr = []
//    //for循环遍历数组,标记为it
//    it: for(let i = 0;i<nums.length;i++){
//        //定义当前元素为num
//        let num = nums[i]
//        //循环遍历当前元素之后的元素，如果有符合要求的数，将其放入arr,跳过当前循环
//        for(let j = i+1;j<nums.length;j++){
//            if(nums[j]>num){
//                arr.push(nums[j])
//                continue it
//            }
//        }
//        //循环遍历当前元素之前的元素，如果右符合要求的数，将其放入arr，跳过当前循环
//        for(let j = 0;j<i;j++){
//            if(nums[j]>num){
//                arr.push(nums[j])
//                continue it
//            }
//        }
//        //没有符合要求的数，放入-1
//        arr.push(-1)
//    }
//    //返回结果arr
//    return arr
//};
//


//暴力破解二

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int cur = nums[i];
            int nextBig = -1;
            for(int j=1;j<n;j++){
                if(nums[(i+j)%n]>cur){
                    nextBig = nums[(i+j)%n];
                    break;
                }
            }
            res[i] = nextBig;
        }


        return res;
    }
}

//https://leetcode-cn.com/problems/next-greater-element-ii/solution/dong-hua-jiang-jie-dan-diao-zhan-by-fuxu-4z2g/
//方法二
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}
