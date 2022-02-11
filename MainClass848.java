/*
 * MainClass848.java
 * Copyright (C) 2022 2022-02-11 15:11 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy一次过 推荐
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] cs = s.toCharArray();
        long temp = 0;
        for(int j = shifts.length-1; j >= 0; j--){
            temp+=shifts[j];
            cs[j] = (char)((cs[j] + temp - 97)%26 + 97);
        }
        return new String(cs);
        
    }
}

//官方题解
class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        StringBuilder ans = new StringBuilder();
        int X = 0;
        for (int shift: shifts)
            X = (X + shift) % 26;

        for (int i = 0; i < S.length(); ++i) {
            int index = S.charAt(i) - 'a';
            ans.append((char) ((index + X) % 26 + 97));
            X = Math.floorMod(X - shifts[i], 26);
        }

        return ans.toString();
    }
}

