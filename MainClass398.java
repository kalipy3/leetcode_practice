import java.util.Random;

//方法一
//class Solution {
//    Map<Integer, List<Integer>> indexes = new HashMap<>();
//    public Solution(int[] nums) {
//        for(int i = 0; i < nums.length; i++){
//            List<Integer> before = indexes.getOrDefault(nums[i],new ArrayList<>());
//            before.add(i);
//            indexes.put(nums[i],before);
//        }
//    }
//
//    public int pick(int target) {
//        List<Integer> items = indexes.get(target);
//        if(items!=null && items.size()>0){
//            int rand = new Random().nextInt(items.size());
//            return items.get(rand);
//        }
//        return -1;
//    }
//}

//方法二
//水塘抽样，参见知乎 https://zhuanlan.zhihu.com/p/29178293
//    核心思路
//        对于需要随机的数字做计数i，i=1，则概率就是1
//        i=2，概率就是 1/2
//        i=3, 概率就是 1/3
//        总结就是按照当前计数i，只取1/i的概率选择该结果，那么最后对于所有1-都是是平均1/i的概率
class Solution {
    private int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        Random r = new Random();
        int n = 0;
        int index = 0;
        for(int i = 0;i < nums.length;i++)
            if(nums[i] == target){
                //计算同一个target的个数
                n++;
                //我们以同一个数字的频数1/n的概率选出其中一个索引
                if(r.nextInt(n) == 0) index = i;
            }
        return index;
    }
}


public class MainClass398
{
    public static void main(String args[]) {
        int [] nums = {1, 2, 3, 3};
        int index = new Solution(nums).pick(3);
        System.out.println(index);
    }
}

