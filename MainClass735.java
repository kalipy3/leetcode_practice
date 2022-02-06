/*
 * MainClass735.java
 * Copyright (C) 2022 2022-02-02 10:28 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//请直接看代码
class Solution {
    public:
        vector<int> asteroidCollision(vector<int>& asteroids) {
            vector<int> res;                //我们用数组模拟栈

            for (int &item : asteroids)     //遍历小行星
            {
                //栈不为空，栈顶小行星向右飞行，当前小行星向左飞行且栈顶小行星较小的情况，栈顶小行星爆炸
                while (!res.empty() && res.back() > 0 && res.back() < -item)
                {
                    res.pop_back();
                }

                //栈不为空，当前小行星向左飞行，且俩行星大小相同的情况，同时爆炸
                if (!res.empty() && item < 0 && res.back() == -item)
                {
                    res.pop_back();
                }

                //1、若当前小行星向右飞行，不用管栈顶小行星的飞行方向，它肯定不会与栈顶小行星相撞；
                //2、栈为空时，当前小行星入栈；
                //3、若栈顶小行星向左飞行，不用管当前小行星的飞行方向，它肯定不会与栈顶小行星相撞；
                else if (item > 0 || res.empty() || res.back() < 0)
                {
                    res.push_back(item);
                }
            }

            return res;
        }
};

//java
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
                        while (!s.isEmpty() && s.peek()>0 && asteroids[i]<0 && s.peek()<-asteroids[i]) {
                s.pop();
            }

            if (s.isEmpty() || asteroids[i] > 0 || s.peek() < 0) {
                s.push(asteroids[i]);
            }
            else if (!s.isEmpty() && s.peek()>0 && asteroids[i]<0 && s.peek()==-asteroids[i]) {
                s.pop();
            }

        }

        int[] ans = new int[s.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = s.pop();
        }
        return ans;
    }
}
