//官方题解
class Solution {
    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        StringBuilder newline = new StringBuilder();
        List<String> ans = new ArrayList();
        for (String line: source) {
            int i = 0;
            char[] chars = line.toCharArray();
            if (!inBlock) newline = new StringBuilder();
            while (i < line.length()) {
                if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                    break;
                } else if (!inBlock) {
                    newline.append(chars[i]);
                }

                i++;
            }
            if (!inBlock && newline.length() > 0) {
                ans.add(new String(newline));
            }
        }
        return ans;
    }
}

//写法二
class Solution {
    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        StringBuilder newline = new StringBuilder();
        List<String> ans = new ArrayList();
        for (String line: source) {
            int i = 0;
            char[] chars = line.toCharArray();
            if (!inBlock) newline = new StringBuilder();
            while (i < line.length()) {
                if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    inBlock = true;
                    //i++;
                    i += 2;
                } else if (inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    inBlock = false;
                    //i++;
                    i += 2;
                } else if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                    break;
                } else if (!inBlock) {
                    newline.append(chars[i]);
                    i++;
                } else {
                    i++;
                }

                //i++;
            }
            if (!inBlock && newline.length() > 0) {
                ans.add(new String(newline));
            }
        }
        return ans;
    }
}

//方法二 写法一
//思路: 
//先把所有字符串组合成一个完整的字符串，之间用\n隔开，然后遍历字符串，遇到//时，删除到\n, 遇到/*，删除到*/，最后的字符串再用\n分割开。就是结果。
class Solution {
    public List<String> removeComments(String[] source) {
        String src = String.join("\n", source) + '\n';
        for (int i = 0; i < src.length() - 1; ) {
            int j = src.indexOf('/', i);
            if (j == -1) break;
            char ch = src.charAt(j + 1);
            if (ch == '*') {
                // 删除/*....*/ ，全删
                src = src.substring(0, j) + src.substring(src.indexOf("*/", j + 2) + 2);
                i = j;
            } else if (ch == '/') {
                // 删除//....\n ，换行符\n保留
                src = src.substring(0, j) + src.substring(src.indexOf('\n', j + 2));
                i = j + 1;
            } else {
                i = j + 2;
            }
        }
        List<String> target = new ArrayList<>(Arrays.asList(src.split("\n")));
        target.removeIf(String::isEmpty);
        return target;
    }
}


//方法二 写法二
class Solution {
    public List<String> removeComments(String[] source) {
        StringBuilder sb = new StringBuilder(String.join("\n", source)).append("\n");
        for (int i = 0; i < sb.length(); ) {
            int j = sb.indexOf("/", i);
            if (j == -1) break;
            char ch = sb.charAt(j + 1);
            if (ch == '/') {
                sb.delete(j, sb.indexOf("\n", j + 2));
                i = j;
            } else if (ch == '*') {
                sb.delete(j, sb.indexOf("*/", j + 2) + 2);
                i = j;
            } else {
                i = j + 2;
            }
        }
        List<String> res = new ArrayList<>();
        for (String line : sb.toString().split("\n")) {
            if (!line.isEmpty()) res.add(line);
        }
        return res;
    }
}


