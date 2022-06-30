//官方题解 请直接看代码即可 简单
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}

//kalipy一次过
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new LinkedList<>();

        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c - 'a'] = i;
        }

        int l = 0;
        int r = 0;
        int maxLen = 0;
        while (l <= r && r < s.length()) {
            char c = s.charAt(r);
            if (map[c - 'a'] > maxLen) {
                maxLen = map[c - 'a'];
            }
            if (r == maxLen) {
                ans.add(r - l + 1);
                l = r + 1;
            }

            r++;
        }

        return ans;
    }
}
