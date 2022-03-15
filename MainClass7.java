//记 rev 为翻转后的数字，为完成翻转，我们可以重复「弹出」x 的末尾数字，将其「推入」rev 的末尾，直至 x 为 0。
//
//要在没有辅助栈或数组的帮助下「弹出」和「推入」数字，我们可以使用如下数学方法：
//// 弹出 x 的末尾数字 digit
//digit = x % 10
//x /= 10
//// 将数字 digit 推入 rev 末尾
//rev = rev * 10 + digit


//方法一
//可以直接存一个临时的翻转结果，如果这个翻转结果除以10不等于上一个结果，说明有溢出。 这种做法相对简洁易懂一些
class Solution {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = res * 10 + x % 10;
            if (tmp / 10 != res) { // 溢出!!!
                return 0;
            }
            res = tmp;
            x /= 10;
        }
        return res;
    }
}

//写法二 官方题解
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}

//kalipy一次过 送分题
class Solution {
    public int reverse(int x) {

        int digit = 0;
        int pre = 0;
        while (x != 0) {
            pre = digit;
            digit = digit * 10 + x % 10;

            if (digit / 10 != pre) return 0;

            x /= 10;
        }

        return digit;
    }
}
