//nums = "----->-->"; k =3
//result = "-->----->";
//
//reverse "----->-->" we can get "<--<-----"
//reverse "<--" we can get "--><-----"
//reverse "<-----" we can get "-->----->"
class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;//这里一定要mod
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    private void reverse(int[] nums,int a,int b){
        //用双指针好了
        int i=a,j=b;
        while(i<j){
            int t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            i++;
            j--;
        }
    }
}

//kalipy一次过
class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0) return;

        k = (k % nums.length);

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}

//1 2 3 4 5 6 7
//7 6 5 4 3 2 1
//5 6 7
//      1 2 3 4
