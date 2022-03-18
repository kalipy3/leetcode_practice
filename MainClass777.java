/*
 * MainClass777.java
 * Copyright (C) 2022 2022-03-18 18:21 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//方法一 评论区 推荐 请直接看文字和代码 很好理解
//XL->LX
//RX->XR
//"LX"替换一个"XL"，或者用一个"XR"替换一个"RX".所以L只能玩左移动，R只能往右边移动
//根据题意，R只能向右移动，L只能向左移动，且必须借助于X，这说明，R和L的相对位置是无法交换的
//start中R的位置索引不能比end中相应的R的大，因为它不能左移
//start中L的位置索引不能比end中相应的L的小，因为它不能右移
class Solution {
    public boolean canTransform(String start, String end) {
        int n1 = start.length();
        int n2 = end.length();
        if(n1 != n2){
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        char c1;
        char c2;
        while(true){
            //start中的非X字符
            while(index1 < n1 && start.charAt(index1) == 'X'){
                index1++;
            }
            //end中的非X字符
            while(index2 < n2 && end.charAt(index2) == 'X'){
                index2++;
            }
            if(index1 == n1 && index2 == n2){   //大家都安全地找完了，退出循环返回true即可
                break;
            }else if( index1 < n1 && index2 < n2){  //大家都找到了下一个非X字符
                c1 = start.charAt(index1);
                c2 = end.charAt(index2);
                if(c1 != c2){   //字符不相同，由于R和L的相对位置是没有办法发生变化的，返回false
                    return false;
                }
                //字符相同，根据是R还是L进行位置索引条件的判断
                if(c1 == 'R'){
                    if(index1 > index2){
                        return false;
                    }
                }else{
                    if(index1 < index2){
                        return false;
                    }
                }
            }else{  //一个找完了，还有一个没找完，说明R\L的字符数量是不一致的，返回false
                return false;
            }
            index1++;
            index2++;
        }
        return true;
    }
}

//写法二 推荐 请先看写法一
class Solution {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;

        int t = 0;
        for (int i = 0; i < start.length(); ++i)
            if (start.charAt(i) == 'L') {
                while (end.charAt(t) != 'L') t++;
                if (i < t++) return false;
            }

        t = 0;
        for (int i = 0; i < start.length(); ++i)
            if (start.charAt(i) == 'R') {
                while (end.charAt(t) != 'R') t++;
                if (i > t++) return false;
            }

        return true;
    }
}
