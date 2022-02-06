/*
 * MainClass713.java
 * Copyright (C) 2022 2022-01-30 13:23 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

int numSubarrayProductLessThanK(int* nums, int numsSize, int k){
    /*每次r指针向右移动一位，并且计算sum*nums[r]，来计算left到right的所有数的乘积，如果sum>=k，sum/=nums[l]，并且将left右移，直到sum<k，此时相对于右指针right就有right-left+1个连续的子数组符合条件，从0到numsSize遍历一遍right即可得到所有的子数组的个数
    左指针右移递减，右指针右移递增，因此在right右移之后不会出现漏掉left左边元素的情况，因为对于当前left，最大的right指针就是右移之前的right*/
    if(k<=1)
        return 0;

    int l=0,r=0,sum=1,cnt=0;
    for(r=0;r<numsSize;r++){
        sum*=nums[r];
        while(sum>=k)
            sum/=nums[l++];

        cnt+=r-l+1;
        //当 nums[left] * nums[left + 1] ..nums[right-1] * nums[right] 都满足 < k 时，那么 nums[left + 1] ..nums[right-1] * nums[right] 和 nums[left+2] ..nums[right-1] * nums[right] ...... 都满足。其个数一共 right - left + 1个
    }
    return cnt;
}

