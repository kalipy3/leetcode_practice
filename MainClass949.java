/*
 * MainClass949.java
 * Copyright (C) 2022 2022-02-09 11:17 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
// Solution inspired by @rock
//官方题解
class Solution {
    public String largestTimeFromDigits(int[] A) {
        int ans = -1;

        // Choose different indices i, j, k, l as a permutation of 0, 1, 2, 3
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (j != i) {
                    for (int k = 0; k < 4; ++k) {
                        if (k != i && k != j) {
                            int l = 6 - i - j - k;

                            // For each permutation of A[i], read out the time and
                            // record the largest legal time.
                            int hours = 10 * A[i] + A[j];
                            int mins = 10 * A[k] + A[l];
                            if (hours < 24 && mins < 60) {
                                ans = Math.max(ans, hours * 60 + mins);
                            }
                        }
                    }
                }
            }
        }

        return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";
    }
}

//方法三
链接：https://leetcode-cn.com/problems/largest-time-for-given-digits/solution/leetcodebi-ji-java-py-si-ke-yi-dao-ti-907-zi-shu-2/
/*
    剪枝
        第一个if条件排除这种情况 {0,1}[9]:23,当第一位是0时，第二位最多不能超过9
        第二个elif 条件排除的是{2}[3]:47,当第一位是2时，第二位最多不能超过3，最大值是23:59,这个条件不写，试下//[1,2,3,4] 24:31 这个例子

if (index == 1) {
            if (cur[0] == 0 || cur[0] == 1) max[1] = 9;
            else if (cur[0] == 2) max[1] = 3;//[1,2,3,4] 24:31
        }

*/
class Solution {
String res;
    int[] max = {2, 3, 5, 9};

    public String largestTimeFromDigits(int[] A) {
        int[] cur = new int[4];
        Arrays.fill(cur, -1);
        helper(A, new boolean[4], cur, 0);
        return res == null ? "" : res;
    }

    /**
     * @param A     数组
     * @param used  A[i]元素是否被使用过
     * @param cur   当前组成的结果集
     * @param index cur的索引
     */
    public void helper(int[] A, boolean[] used, int[] cur, int index) {
        if (index == 4) {
            String tmp = "" + cur[0] + cur[1] + ":" + cur[2] + cur[3];
//            System.out.println(tmp);
            if (res == null || res.compareTo(tmp) < 0) {
                res = tmp;
            }
            return;
        }

        if (index == 1) {
            if (cur[0] == 0 || cur[0] == 1) max[1] = 9;
            else if (cur[0] == 2) max[1] = 3;//[1,2,3,4] 24:31
        }
        for (int i = 0; i < 4; i++) {
            if (used[i] || A[i] > max[index]) continue;
            cur[index] = A[i];
            used[i] = true;
            helper(A, used, cur, index + 1);
            cur[index] = -1;
            used[i] = false;
        }

    }
}


//方法二 kalipy一次过 推荐 
class Solution {
    String ans = "";
    boolean[] used = new boolean[4];

    public String largestTimeFromDigits(int[] arr) {

        dfs(arr, 0, "");

        return ans.equals("") ? "" : ans.substring(0, 2) + ":" + ans.substring(2, 4);
    }

    private void dfs(int[] arr, int idx, String str) {
        if (idx == 4) {
            if (str.substring(0, 2).compareTo("24") < 0 && str.substring(2, 4).compareTo("60") < 0 && ans.compareTo(str) < 0) {
                ans = str;
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (used[i]) continue;

            //if (i > 0 && !used[i-1] && arr[i-1] == arr[i]) continue;//加上也ok

            used[i] = true;
            dfs(arr, idx + 1, str + arr[i]);
            used[i] = false;
        }
    }
}
