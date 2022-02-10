//请直接看这个代码 kalipy用一下午选出来的最好的写法
class Solution {
    public int compress(char[] chars) {
        if(chars.length==0) return 0;
        int k=0;  //当前需要更新的位置
        int p=0,q=0;  //双指针统计一段字符出现的频数
        while (q<chars.length){
            while (q<chars.length&&chars[q]==chars[p]){
                q++;
            }
            chars[k++]=chars[p];
            if(q-p>1){
                for(char c: String.valueOf(q - p).toCharArray()){ //频数可能大于9
                    chars[k++]=c;
                }
            }
            p=q;
        }
        return k;
    }
}

