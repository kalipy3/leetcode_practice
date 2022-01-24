//作者：carlsun-2
//链接：https://leetcode-cn.com/problems/subsets/solution/dai-ma-sui-xiang-lu-78-zi-ji-hui-su-sou-6yfk6/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//方法一 回溯
class Solution {
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0){
            result.add(new ArrayList<>());
            return result;
        }
        subsetsHelper(nums, 0);
        return result;
    }

    private void subsetsHelper(int[] nums, int startIndex){
        result.add(new ArrayList<>(path));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        if (startIndex >= nums.length){ //终止条件可不加
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.removeLast();
        }
    }
}

//方法二 转化为二叉树的遍历,即dfs或bfs
作者：dao-fa-zi-ran-2
链接：https://leetcode-cn.com/problems/subsets/solution/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
/**
 * DFS，前序遍历
 */
public static void preOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
    if (i >= nums.length) return;
    // 到了新的状态，记录新的路径，要重新拷贝一份
    subset = new ArrayList<Integer>(subset);

    // 这里
    res.add(subset);
    preOrder(nums, i + 1, subset, res);
    subset.add(nums[i]);
    preOrder(nums, i + 1, subset, res);
}

/**
 * DFS，中序遍历
 */
public static void inOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
    if (i >= nums.length) return;
    subset = new ArrayList<Integer>(subset);

    inOrder(nums, i + 1, subset, res);
    subset.add(nums[i]);
    // 这里
    res.add(subset);
    inOrder(nums, i + 1, subset, res);
}

/**
 * DFS，后序遍历
 */
public static void postOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
    if (i >= nums.length) return;
    subset = new ArrayList<Integer>(subset);

    postOrder(nums, i + 1, subset, res);
    subset.add(nums[i]);
    postOrder(nums, i + 1, subset, res);
    // 这里
    res.add(subset);
}

