//先看正月点灯笼的归并排序，然后看这个题解，再看代码
//作者：jyd
//链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/jian-zhi-offer-51-shu-zu-zhong-de-ni-xu-pvn2h/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//写法一
class Solution {
    int[] nums, tmp;
    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }
    private int mergeSort(int l, int r) {
        // 终止条件
        if (l >= r) return 0;
        // 递归划分
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++)
            tmp[k] = nums[k];
        for (int k = l; k <= r; k++) {
            if (i == m + 1)
                nums[k] = tmp[j++];
            else if (j == r + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else {
                nums[k] = tmp[j++];
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }
}


//写法二
int count;
public int reversePairs(int[] nums) {
    this.count = 0;
    merge(nums, 0, nums.length - 1);
    return count;
}

public void merge(int[] nums, int left, int right) {
    int mid = left + ((right - left) >> 1);
    if (left < right) {
        merge(nums, left, mid);
        merge(nums, mid + 1, right);
        mergeSort(nums, left, mid, right);
    }
}

public void mergeSort(int[] nums, int left, int mid, int right) {
    int[] temparr = new int[right - left + 1];
    int index = 0;
    int temp1 = left, temp2 = mid + 1;

    while (temp1 <= mid && temp2 <= right) {
        if (nums[temp1] <= nums[temp2]) {
            temparr[index++] = nums[temp1++];
        } else {
            //用来统计逆序对的个数
            count += (mid - temp1 + 1);
            temparr[index++] = nums[temp2++];
        }
    }
    //把左边剩余的数移入数组
    while (temp1 <= mid) {
        temparr[index++] = nums[temp1++];
    }
    //把右边剩余的数移入数组
    while (temp2 <= right) {
        temparr[index++] = nums[temp2++];
    }
    //把新数组中的数覆盖nums数组
    for (int k = 0; k < temparr.length; k++) {
        nums[k + left] = temparr[k];
    }
}

//写法三 请直接看视频讲解
//作者：venturekwok
//链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/java-gui-bing-pai-xu-ji-chu-shang-liang-pewvg/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    int count = 0;
    int[] aux;
    public int reversePairs(int[] nums) {
        aux = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return count;
    }
    
    public void sort(int[] nums, int lo, int hi){
        if(hi <= lo)    return;
        
        int mid = (lo + hi) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for(int k = lo; k <= hi; k++)
            aux[k] = nums[k];
        
        int index = lo;
        while(i <= mid || j <= hi){
            if(i > mid)                 nums[index++] = aux[j++];
            else if(j > hi)             nums[index++] = aux[i++];
            else if(aux[i] <= aux[j])   nums[index++] = aux[i++];
            else                        {nums[index++] = aux[j++];  count += mid - i + 1;}
        }
    }
}


