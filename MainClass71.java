//作者：spark-
//链接：https://leetcode-cn.com/problems/simplify-path/solution/shuang-duan-dui-lie-linuxde-si-lu-by-sik-lt4h/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
//注意: Deque中的push和pop和poll和pollLast和offer是完全不同的效果
class Solution {
    public String simplifyPath(String path) {
        // 双端队列
        Deque<String> queue = new LinkedList<>();
        // 分割字符,比如String path = "/12//3/4/5/6//7///",split("/")后为{"",12,i,"",3,4,5,6,"",7}
        String[] res = path.split("/");
        for(int i = 0; i < res.length; i++){
            String s = res[i];
            if(s.equals(".") || s.equals("")) continue;
            //else if (!queue.isEmpty() && str[i].equals("..")) {//error 这种写法会导致进入最后的else分支
            else if (s.equals("..")){//ok
                if(!queue.isEmpty()){
                    queue.pollLast();
                }
            }else{
                queue.offer(s);
            }
        }
        // 拼接
        StringBuilder sb = new StringBuilder("/");
        while(!queue.isEmpty()){
            sb.append(queue.poll());//pollFirst()
            if(!queue.isEmpty()){
                sb.append("/");
            }
        }
        // 判空
        return sb.toString().equals("") ? "/" : sb.toString();
    }
}



