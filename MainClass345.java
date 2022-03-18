/*
 * MainClass345.java
 * Copyright (C) 2022 2022-02-10 22:18 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//请直接看代码即可 送分题
class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !isVowel(arr[i])) {
                ++i;
            }
            while (j > 0 && !isVowel(arr[j])) {
                --j;
            }
            if (i < j) {
                swap(arr, i, j);
                ++i;
                --j;
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//写法二 kalipy一次过 送分题
class Solution {
           String t = "aiueoAIUEO";
    public String reverseVowels(String s) {
 
        char[] str = s.toCharArray();

        int l = 0;
        int r = s.length() - 1;
        while (l < r) {

            while (l < r && !isCheck(s.charAt(l))) {
                l++;
            }
            while (r > l && !isCheck(s.charAt(r))) {
                r--;
            }

            if (l < r) {
                char c = str[l];
                str[l] = str[r];
                str[r] = c;
                l++;
                r--;
            }
        }

        return new String(str);
    }

    private boolean isCheck(char c) {
        return t.indexOf(c) >= 0;
    }
}

