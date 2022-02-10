//推荐先看这个题解 链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal/solution/gong-shui-san-xie-mo-ni-shu-shi-ji-suan-kq8c4/
//写法一
public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) {
        return "0";
    }
    StringBuilder fraction = new StringBuilder();
    // If either one is negative (not both)
    //等价于if (a > 0 && b < 0 || a < 0 && b > 0) sb.append('-');
    if (numerator < 0 ^ denominator < 0) {
        fraction.append("-");
    }
    // Convert to Long or else abs(-2147483648) overflows
    long dividend = Math.abs(Long.valueOf(numerator));
    long divisor = Math.abs(Long.valueOf(denominator));
    fraction.append(String.valueOf(dividend / divisor));
    long remainder = dividend % divisor;
    if (remainder == 0) {
        return fraction.toString();
    }
    fraction.append(".");
    Map<Long, Integer> map = new HashMap<>();
    while (remainder != 0) {
        if (map.containsKey(remainder)) {
            fraction.insert(map.get(remainder), "(");
            fraction.append(")");
            break;
        }
        map.put(remainder, fraction.length());
        remainder *= 10;
        fraction.append(String.valueOf(remainder / divisor));
        remainder %= divisor;
    }
    return fraction.toString();
}

//写法二
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // 转 long 计算，防止溢出
        long a = numerator, b = denominator;
        // 如果本身能够整除，直接返回计算结果
        if (a % b == 0) return String.valueOf(a / b);
        StringBuilder sb = new StringBuilder();
        // 如果其一为负数，先追加负号
        if (a * b < 0) sb.append('-');
        a = Math.abs(a); b = Math.abs(b);
        // 计算小数点前的部分，并将余数赋值给 a
        sb.append(String.valueOf(a / b) + ".");
        a %= b;
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            // 记录当前余数所在答案的位置，并继续模拟除法运算
            map.put(a, sb.length());
            a *= 10;
            sb.append(a / b);
            a %= b;
            // 如果当前余数之前出现过，则将 [出现位置 到 当前位置] 的部分抠出来（循环小数部分）
            if (map.containsKey(a)) {
                int u = map.get(a);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
        }
        return sb.toString();
    }
}


