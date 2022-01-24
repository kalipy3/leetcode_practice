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
