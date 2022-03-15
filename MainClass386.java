/*
 * MainClass386.java
 * Copyright (C) 2022 2022-02-15 15:36 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//先看这个题解 链接：https://leetcode-cn.com/problems/lexicographical-numbers/solution/java-zi-dian-xu-de-bian-li-by-ppppjqute/
//方法一
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++){
             dfs(n, i, list);
        }
        return list;
    }
    private void dfs(int n,int i,List<Integer>list){
        if(i>n){
            return ;
        }
        list.add(i);
        for(int j=0;j<=9;j++){
            dfs(n,i*10+j,list);
        }
    }

}

//方法一 写法二
public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if (i > n) break;
            dfs(n, i, list);
        }
        return list;
    }

    private void dfs(int n, int i, List<Integer> list) {
        if (i > n) {
            return;
        }
        list.add(i);
        for (int j = 0; j <= 9; j++) {
            int k = i * 10 + j;
            if (k > n) break;
            dfs(n, k, list);
        }
    }
}
//方法一 写法三
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        dfs(n, 0, list);
        list.remove(0);
        return list;
    }

    private void dfs(int n, int i, List<Integer> list) {
        if (i > n) {
            return;
        }
        list.add(i);
        for (int j = 0; j <= 9; j++) {
            int k = i * 10 + j;
            if (k == 0) continue;
            if (k > n) break;
            dfs(n, k, list);
        }
    } 
}



//再看这个题解 https://leetcode-cn.com/problems/lexicographical-numbers/solution/386-zi-dian-xu-pai-shu-o1-kong-jian-fu-z-aea2/
//方法二
class Solution {
    public List<Integer> lexicalOrder(int n) {

        List<Integer> res = new ArrayList<>();
        int num = 1;
        while(res.size() < n){
            while(num<=n){
                res.add(num);
                //*10相当于 遍历子节点
                num *= 10;
            }
            while(num % 10 == 9 || num > n){
                //如果当前层子节点 遍历完了，或者 是不存在的节点(因为已经大于n了)，则返回上一层(/=10)
                num /= 10;
            }
            //当前层的下一个节点
            num += 1;
        }
        return res;
    }
}

//kalipy一次过 推荐
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {


        for (int i = 1; i <= 9; i++) {
            dfs(n, i);
        }
        return ans;
    }

    private void dfs(int n, int idx) {
        if (idx > n) return;

        ans.add(idx);

        for (int i = 0; i <= 9; i++) {
            dfs(n, idx * 10 + i);
        }
    }
}

