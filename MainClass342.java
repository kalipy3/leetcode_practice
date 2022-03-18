/*
 * MainClass342.java
 * Copyright (C) 2022 2022-02-16 13:32 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//官方题解
//方法一
class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}

//官方题解
//方法二
//num%3==1: (n&(n-1))的前提下，由于 4=3+1， 那么4的N次方就是（3+1）^N，尝试展开多项式，比如(3+1)^2 =(3+1)*(3+1)，除了1*1以外永远都有3相乘，再展开3次方，(3+1)*(3+1)*(3+1)，结论一致，除了结尾的1都有3相乘，因此可以有结论，一个数的N次方-1总能除尽比这个数小1的数。
class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }
}


//方法二
public boolean isPowerOfFour(int n) {
    if(n < 1) return false;
    while(n != 1) {
        if (n % 4 != 0) return false;
        n = n /4;
    }
    return true;
}
