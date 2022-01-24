//kalipy一次过
//由小胃口到大胃口一个一个满足孩子,为避免饼干重复分配，分配后饼干置位为0
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n1 = g.length;
        int n2 = s.length;
//g:7 8 9 10
//s:5 6 7 8
        if (n2==0) return 0;

        int l1 = 0;//l1指向g
        int l2 = 0;//l2指向s
        int cnt = 0;
        while (l1<n1 && l2<n2) {
            while (l1<n1 && l2<n2 && g[l1]>s[l2]) {
                l2++;
            }
            if (l2>=n2) return cnt;

            //s[l2]=0;
            cnt++;
            l1++;
            l2++;
        }

        return cnt;
    }
}

//写法二 推荐
class Solution{
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        //g的索引
        int i = 0;
        //s的索引
        int j = 0;
        while (i < g.length && j < s.length) {
            //只有满足条件，才能喂好孩子
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
