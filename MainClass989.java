/*
 * MainClass989.java
 * Copyright (C) 2022 2022-02-03 10:09 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<Integer>();
        int n = num.length;
        for (int i = n - 1; i >= 0; --i) {
            int sum = num[i] + k % 10;
            k /= 10;
            if (sum >= 10) {
                k++;
                sum -= 10;
            }
            res.add(sum);
        }
        for (; k > 0; k /= 10) {
            res.add(k % 10);
        }
        Collections.reverse(res);
        return res;
    }
}


//kalipy一次过 送分题
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<Integer>();
        int p1 = num.length - 1;
        int carray = 0;
        while (p1 >= 0 || k != 0) {
            int a = p1 < 0 ? 0 : num[p1];
            int b = k % 10;
            int sum = carray + a + b;
            ans.add(sum % 10);
            carray = sum / 10;

            k /= 10;
            p1--;
        }

        if (carray == 1) ans.add(1);

        Collections.reverse(ans);

        return ans;
    }
}
