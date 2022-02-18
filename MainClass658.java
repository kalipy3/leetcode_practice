/*
 * MainClass658.java
 * Copyright (C) 2022 2022-02-16 16:23 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
方法二其实没必要这样。。利用二分法找出与x最接近的元素的index后，令low=index-1,high=index+1，然后比较x-arr[low]和arr[high]-x的大小来选择high++或者low--，注意别让low和high越界就可以了。最后开区间(low,high)内的数就是答案了。

        int leftindex = index-1;
        int rightindex = index+1;
        while(rightindex-leftindex-1<k){
            if(leftindex<0){
                rightindex++;
                continue;
            } 
            if(rightindex>=len){
                leftindex--;
                continue;
            } 
            if(x-arr[leftindex]<=arr[rightindex]-x) leftindex--;
            else rightindex++;
        }


