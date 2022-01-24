//官方题解 方法一 str+=效率低 不推荐(推荐方法一的写法二)
public class Codec {
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }
  
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }
  
    public TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }
  
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);
    
        return root;
    }
}

//方法一的写法二 StringBuilder比+=快很多
public class Codec {

    public String serialize(TreeNode root) {      //用StringBuilder
        StringBuilder res = ser_help(root, new StringBuilder());
        return res.toString();
    }

    public StringBuilder ser_help(TreeNode root, StringBuilder str){
        if(null == root){
            str.append("null,");
            return str;
        }
        str.append(root.val); 
        str.append(",");
        str = ser_help(root.left, str);
        str = ser_help(root.right, str);
        return str;
    }

    public TreeNode deserialize(String data) {
        String[] str_word = data.split(",");
        List<String> list_word = new LinkedList<String>(Arrays.asList(str_word));
        return deser_help(list_word);
    }

    public TreeNode deser_help(List<String> li){
        if(li.get(0).equals("null")){//疑惑，这里get(0)为什么不会爆空指针异常
            li.remove(0);
            return null;
        }
        TreeNode res = new TreeNode(Integer.valueOf(li.get(0)));
        li.remove(0);
        res.left = deser_help(li);
        res.right = deser_help(li);
        return res;
    }
}

推荐阅读:
https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/shou-hui-tu-jie-gei-chu-dfshe-bfsliang-chong-jie-f/
