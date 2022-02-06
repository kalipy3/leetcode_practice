/*
 * MainClass67.java
 * Copyright (C) 2022 2022-02-03 11:09 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//简单 请直接看代码
class Solution {
    public String addBinary(String aa, String bb) {
        int carry = 0;
        int n1 = aa.length() - 1;
        int n2 = bb.length() - 1;
        int i = n1;
        int j = n2;
        StringBuilder ans = new StringBuilder("");
        while (i>=0 || j>=0) {
            int a = i>=0 ? aa.charAt(i)-'0' : 0;
            int b = j>=0 ? bb.charAt(j)-'0' : 0;
            int sum = a + b + carry;
            carry = sum / 2;
            sum = sum % 2;
            ans.append(sum);
            i--;
            j--;
        }

        if (carry == 1) {
            ans.append(1);
        }

        return ans.reverse().toString();
    }
}
