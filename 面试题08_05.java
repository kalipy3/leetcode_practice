/*
 * 面试题08_05.java
 * Copyright (C) 2022 2022-02-17 23:30 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

int multiply(int A, int B){
    if(B==0)
        return 0;
    return A+multiply(A,B-1);
}

//写法二
class Solution {
    private int sum = 0;

    public int multiply(int A, int B) {
        if(B!=0){
            sum+=A;
            multiply(A, B-1);  //recursion  递归
        }
        return sum;
    }


}
