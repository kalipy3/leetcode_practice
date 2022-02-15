//kalipy一次过
class Solution {
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();

        if (needle.equals("")) return 0;

        //for (int i = 0; i + n2 <= n1; i++) {//也ok
        for (int i = 0; i < n1-n2+1; i++) {
            int p1 = i;
            int j = 0;
            for (j = 0; j < n2; j++) {
                if (haystack.charAt(i+j) != (needle.charAt(j)))
                    break;
            }
            if (j == n2)
                return i;
        }

        return -1;
    }
}

//写法二
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}

//方法三 官方题解
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}

