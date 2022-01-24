//作者：hxz1998
//链接：https://leetcode-cn.com/problems/random-pick-with-weight/solution/java-qian-zhui-he-er-fen-cha-zhao-zhu-xi-v6u2/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    int[] prefix;   // 前缀和数组
    int sum = 0;    // 总和
    Random random = new Random(); // 随机数产生器

    public Solution(int[] w) {
        int n = w.length;
        prefix = new int[n];
        prefix[0] = w[0];
        // 建立前缀和数组
        for (int i = 1; i < n; ++i)
            prefix[i] = prefix[i - 1] + w[i];
        // 求和
        sum = prefix[n - 1];
    }

    public int pickIndex() {
        // 先使用随机数产生器来得到需要的前缀和
        int target = random.nextInt(sum);
        // 然后使用二分查找来逐步搜索
        int left = 0, right = prefix.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果前缀和偏小了，就需要把左指针往右移动，这里需要注意的是，
            // 等于情况也不行，因为这样等于是碰到了下一个区间的起始位置
            if (prefix[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}


//对于w[i][1,3,5,6]我们需要根据权重获取随机数，所以需要从头开始将权重值进行逐步累积，累积后数组为：[1,4,9,15]，然后使用Random产生一个[1,15]之间的随机数，如果随机数落在[1]，对应元素为0(下标)，如果随机数落在[2,4]区间，对应元素为1，如果随机数落在[5,9]区间，对应元素为2，如果随机数落在[10,15]，对应元素为4。在得出随机数后如果顺序遍历效率比较低，这里的权重累积数组是递增的，所以可以考虑使用二分法，找到随机数对应的区间。
//写法二
class Solution {
    //权重累加数组
    int[] arr;

    public Solution(int[] w) {
        arr = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            arr[i] = sum;
        }
    }

    public int pickIndex() {
        //产生随机数
        Random random = new Random();
        int randomNum = random.nextInt(arr[arr.length - 1]) + 1;
        //二分查找随机数所在的区间
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == randomNum) {
                return mid;
            } else if (arr[mid] > randomNum) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

//二分法一时间短路时可以:
//kalipy
public int pickIndex() {
    // 先使用随机数产生器来得到需要的前缀和
    int target = random.nextInt(sum) + 1;
    // 然后使用二分查找来逐步搜索
    for (int i = 0; i < prefix.length; i++) {
        if (prefix[i] < target) {
            continue;
        }
        return i;
    }
    return 0;
}
//kalipy or
public int pickIndex() {
    // 先使用随机数产生器来得到需要的前缀和
    int target = random.nextInt(sum);
    // 然后使用二分查找来逐步搜索
    for (int i = 0; i < prefix.length; i++) {
        if (prefix[i] <= target) {
            continue;
        }
        return i;
    }
    return 0;
}
