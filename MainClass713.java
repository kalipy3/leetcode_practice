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


//ans += r - l + 1的解释
//
//举例加深理解，还是例题这个例子： nums = [10,5,2,6], k = 100 每一轮都是right右移一个单位
//
//    第一轮：left=0 right=0 此时[10]满足
//    第二轮：left=0 right=1 此时新增[5] [10,5]
//    第三轮：left=0 right=2 此时不满足<k 因此left向左移动1个单位 left=1 right=2 此时新增[2] [5,2] 相当于由于left左移 使得排除了[10,2,5]这种情况
//    第四轮：left=1 right=3 此时新增[6] [2,6] [5,2,6]
//
//right=len-1 结束循环。 ans=1+2+2+3=8 每一轮新增的量=right-left+1
