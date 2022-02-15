/*
 * MainClass739.java
 * Copyright (C) 2022 2022-02-14 17:07 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//方法一 暴力破解 kalipy一遍过
public int[] dailyTemperatures(int[] T) {
    int length = T.length;
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
        int current = T[i];
        if (current < 100) {
            for (int j = i + 1; j < length; j++) {
                if (T[j] > current) {
                    result[i] = j - i;
                    break;
                }
            }
        }
    }
    return result;
}


//方法二 单调栈
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}


