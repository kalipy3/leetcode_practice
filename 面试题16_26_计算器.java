/*
 * 面试题16_26_计算器.java
 * Copyright (C) 2022 2022-02-11 11:04 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//请直接看代码 简单


//写法二 评论区 推荐
public int calculate(String s) {
    //记录每个数字前面的符号，如果是乘法和除法就直接和前面的数字运算，
    //然后在存放到栈中，如果是加法和减法直接存放到栈中
    int preSign = '+';
    Stack<Integer> stack = new Stack<>();
    int length = s.length();
    for (int i = 0; i < length; i++) {
        int ch = s.charAt(i);
        if (ch == ' ')//过滤掉空格
            continue;
        //如果是数字
        if (ch >= '0' && ch <= '9') {
            //找到连续的数字字符串，把它转化为整数
            int num = 0;
            while (i < length && (ch = s.charAt(i)) >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
                i++;
            }
            //这个是为了抵消上面for循环中的i++
            i--;
            //乘法和除法，运算之后在存放到栈中。加法和减法直接存放到栈中
            if (preSign == '*') {
                stack.push(num * stack.pop());
            } else if (preSign == '/') {
                stack.push(stack.pop() / num);
            } else if (preSign == '+') {
                stack.push(num);
            } else if (preSign == '-') {
                stack.push(-num);
            }
        } else {//记录前一个的符号
            preSign = ch;
        }
    }
    //把栈中的所有元素都取出来，计算他们的和
    int res = 0;
    while (!stack.empty()) {
        res += stack.pop();
    }
    return res;
}



//写法一 评论区 不推荐
public int calculate(String s) {

    Stack<Integer> stack = new Stack<>();
    char opt = '+';
    int num = 0;

    for (int i = 0; i < s.length(); i++) {

        char ch = s.charAt(i);

        if (Character.isDigit(ch))
            num = num * 10 + (ch - '0');

        if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

            if (opt == '+')
                stack.push(num);
            else if (opt == '-')
                stack.push(-num);
            else if (opt == '*') 
                stack.push(stack.pop() * num);
            else    
                stack.push(stack.pop() / num);

            num = 0;
            opt = ch;
        }
    }

    int res = 0;
    while (!stack.isEmpty())
        res += stack.pop();

    return res;
}
