//先看这个题解
https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/tu-jie-wo-men-zhi-qian-ke-neng-mei-you-g-gcr3/

//写法二 自己实现排序
class Solution {
    public String minNumber(int[] nums) { 
        String[] arr = new String[nums.length];
        //解决大数问题，将数字转换为字符串
        for (int i = 0 ; i < nums.length; ++i) {
            arr[i] = String.valueOf(nums[i]);
        }

        quickSort(arr,0,arr.length-1);
        StringBuffer str = new StringBuffer();
        
        for (String x : arr) {
            str.append(x);
        }
        return str.toString();
    }
    public void quickSort(String[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int low = left;
        int hight = right;
        int i = low+1;
        String pivot = arr[low];

        while (i <= hight) {
             //比较大小
            if ((pivot+arr[i]).compareTo(arr[i]+pivot) > 0 ) {
                 swap(arr,i++,low++);
            } else if ((pivot+arr[i]).compareTo(arr[i]+pivot) < 0) {
                 swap(arr,i,hight--);
            } else {
                 i++;
            }
        }
        
        quickSort(arr,left,low-1);
        quickSort(arr,hight+1,right);
        
    }
    public void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}



//写法一 自己实现排序
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);

        return res.toString();
    }
    void quickSort(String[] strs, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }
}

//写法二 api排序
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        //https://blog.csdn.net/weixin_41922289/article/details/90463971
        //Arrays.sort(arr, new Comparator<String>() {
        //    @Override
        //    public int compare(String o1, String o2) {
        //        return (o1 + o2).compareTo(o2 + o1);
        //    }
        //});
        //按字典顺序比较两个字符串
        //如果参数字符串等于此字符串，则返回值 0；
        //如果此字符串小于字符串参数，则返回一个小于 0 的值(即o1<o2,不动,保持有小到大的顺序)
        //如果此字符串大于字符串参数，则返回一个大于 0 的值(即o1>o2,交换位置,这样才是有小到大的顺序)
        
//输入: [3,30,34,5,9]
//输出: "3033459"
//3 && 30  330>303 [30, 3]
//a && b   ab>ba   [b,  a]
//即数字a和数字b拼接成字符串ab 和数字b和数字a拼接成字符串ba后
//字符串ab和ba谁的字典序小，数字a和数字b谁就排在前面
//此时o1+o2(ab)>o2+o1(ba),所以strs数组中交换o1(a)和o2(b)的位置
//[3,30,34,5,9]变为[30,3,34,5,9]
//继续以此排序，最后为[30,3,34,5,9]
        StringBuilder res = new StringBuilder();

        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}




