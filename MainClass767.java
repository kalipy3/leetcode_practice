1. 只有单个字母出现次数大于整体长度的一半时，才不能重新排布。其他情况都可以排
2. 贪心：排序时，出现次数多的字母先安排。 每次取两个字母。
3. 使用优先队列快速找到出现次数多的字母。

public String reorganizeString(String S) {
    char[] str= S.toCharArray();
    int[] cnt = new int[26];
    int maxCnt= 0;
    for(int i=0;i<str.length;++i){
        cnt[str[i]-'a']++;
        maxCnt = Math.max(maxCnt,cnt[str[i]-'a']);
    }
    //如果单个字母出现次数大于整体长度的一半，则不能重新排布
    if(maxCnt *2 > str.length+1){
        return "";
    }

    //优先队列
    PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->cnt[b-'a']-cnt[a-'a']);
    for(int i=0;i<cnt.length;++i){
        if(cnt[i]!=0) {
            pq.add((char)(i+'a'));
        }   
    }

    //开始重排： 每次取最出现次数最高的两个
    StringBuilder sb = new StringBuilder();
    while(pq.size() >=2){
        char a = pq.poll();
        char b=pq.poll();
        sb.append(a);
        sb.append(b);
        if(--cnt[a-'a'] !=0)  pq.add(a);
        if(--cnt[b-'a']!=0) pq.add(b);
    }
    //总长度为奇数时，最后会剩下一个
    if(pq.size() !=0){
        sb.append(pq.poll());
    }
    return sb.toString();
}

//官方题解 推荐看 讲得很好
class Solution {
    public String reorganizeString(String s) {
        if (s.length() < 2) {
            return s;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character letter1, Character letter2) {
                return counts[letter2 - 'a'] - counts[letter1 - 'a'];
            }
        });
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0) {
                queue.offer(letter1);
            }
            if (counts[index2] > 0) {
                queue.offer(letter2);
            }
        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}


