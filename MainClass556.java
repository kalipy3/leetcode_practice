//本题和31题一样

//官方题解 请看官方题解的图解 很好懂
public class Solution {
    public int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();
        int i = a.length - 2;
        while (i >= 0 && a[i + 1] <= a[i]) {
            i--;
        }
        if (i < 0)
            return -1;
        int j = a.length - 1;
        while (j >= 0 && a[j] <= a[i]) {
            j--;
        }
        swap(a, i, j);
        reverse(a, i + 1);
        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }
    private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

//写法二

//1 4 3 2
public class Solution {
    public int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();
        int i = a.length - 1;
        for (i = a.length - 1; i >= 1; i--) {
            if (a[i-1] < a[i]) {
                break;
            }
        }
        if (i == 0) return -1;
        i--;


        //if (i < 0)
            //return -1;
        int j = a.length - 1;
        while (j >= 0 && a[j] <= a[i]) {
            j--;
        }
        swap(a, i, j);
        reverse(a, i + 1);
        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }
    private void reverse(char[] a, int start) {
        int i = start, j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

//写法三
//下一个更大元素III ×
//下一个排列 √ 对应31题
class Solution {
    public int nextGreaterElement(int n) {
        char[] cs = (n + "").toCharArray();
        int[] nums = new int[cs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = cs[i] - '0';
        }

        //直接调用31题的答案
        nextPermutation(nums);
        
        int digit = 0;
        for (int i = 0; i < nums.length; i++) {
            digit = 10 * digit + nums[i];
        }

        return digit > n ? digit : -1;
        
    }

    public void nextPermutation(int[] nums) {
        int i = 0;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                break;
            }
        }
        if (i >= 0) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    break;
                }
            }
        }
        revesere(nums, i + 1, nums.length - 1);

    }

    private void revesere(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}


