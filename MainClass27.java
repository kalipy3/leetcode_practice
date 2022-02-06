/*
 * MainClass27.java
 * Copyright (C) 2022 2022-01-31 10:57 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过
public int removeElement(int[] nums, int val) {
    int index = 0;
    for(int num : nums){
        if(num != val){
            nums[index++] = num;
        }
    }
    return index;
}
