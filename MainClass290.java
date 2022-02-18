/*
 * MainClass290.java
 * Copyright (C) 2022 2022-02-16 13:14 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//评论区
//java+hashMap 这道题说的是对应关系，那首先想到的集合就是Map，将key（a）-value（dog）存在一起，每当遇到一个字母就去查看对应的单词。 失败有两种情况： 1.key存在，经过查找字母对应的单词和这个单词不匹配； 2.key不存在，但是这个单词已经被存了；

public static boolean wordPattern(String pattern, String str) {
    if(pattern == null || str==null) return false;
    String[] string = str.split(" ");
    if(pattern.length() != string.length) return false;
    HashMap<Character,String> map = new HashMap<>();

    for(int i=0; i<pattern.length(); i++){
        char tmp = pattern.charAt(i);
        //key已经在
        if(map.containsKey(tmp)){
            //不对应就失败
            if(!map.get(tmp).equals(string[i])) return false;
        }
        //key不存在
        else{
            //两个value的值一样 a-dog b-dog->false
            if (map.containsValue(string[i])) return false;
            else
                //添加k-v值
                map.put(tmp,string[i]);
        }
    }
    return true;
}

