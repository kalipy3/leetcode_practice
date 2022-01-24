https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/dai-ma-sui-xiang-lu-jian-zhi-offer-38-zi-gwt6/

//先直接对照上面链接的图把这个代码看懂，然后再看上面链接的剪枝 剪枝请看写法二
class Solution {
    public String[] permutation(String s) {
        Set<String> list = new HashSet<>();
        char[] arr = s.toCharArray();
        boolean[] visited = new boolean[arr.length];
        dfs(arr, "", visited, list);
        return list.toArray(new String[0]);
    }
    public void dfs(char[] arr, String s,  boolean[] visited, Set<String> list)
    {
        if(s.length() == arr.length)
        {
            list.add(s);
            return;
        }
        for(int i=0; i<arr.length; i++)
        {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(arr, s+String.valueOf(arr[i]), visited, list);
            visited[i] = false;
        }

    }
}

//关于set.toArray(new String[0])的解释:
//
//Collection的公有方法中，toArray()是比较重要的一个。
//但是使用无参数的toArray()有一个缺点，就是转换后的数组类型是Object[]。 虽然Object数组也不是不能用，但当你真的想用一个具体类型的数组，比如String[]时，问题就来了。而把Object[]给cast成String[]还是很麻烦的,需要用到这个：
//
//String[] stringArray = Arrays.copyOf(objectArray, objectArray.length, String[].class);
//
//不管是从哪方面看还是一开始就弄成String[]比较好。
//
//具体怎么办呢？其实用带参数的toArray就好了。官方是这样给出的例子：
//String[] a = c.toArray(new String[0]);
//
//像 toArray 方法一样，此方法充当了基于数组的 API 与基于 collection 的 API 之间的桥梁。更进一步说，此方法允许在输出数组的运行时类型上进行精确控制，并且在某些情况下，可以用来节省分配开销。
//
//假定 l 是只包含字符串的一个已知 List。以下代码用来将该列表转储到一个新分配的 String 数组： 
//
//     String[] x = (String[]) v.toArray(new String[0]);
// 注意，toArray(new Object[0]) 和 toArray() 在功能上是相同的。 
//
//<T> T[] toArray(T[] a);
//泛型
//会返回你一个list长度的T 类型的数组
//
//需要一个T[] a,new String[0]相当于开辟了一个长度为0的String[],并且指定了泛型。这样函数的调用是将list转换了一个String的数组。
//
//这里的用new String[0]只是为了指定函数的形参数，最终返回的String[]的长度是由你的list存储内容的长度决定了。
//
//new String[0]就是起一个模板的作用，指定了返回数组的类型，0是为了节省空间，因为它只是为了说明返回的类型
//
//ArrayList.toArray()需要返回String [] “串对象数组” 类型，
//要求调用参数也必须是 “串对象数组”，
//new String[] 就是生生一个“串对象数组”，[0]表示元素个数为零。
//
//只是 一个类型标示，用来告诉toArray方法具体转化成什么类型。
//list.toArray(new String[0]);//转化成String数组
//
//list.toArray(new int[0]);//转化成int数组
//



class Solution {
    List<String> rec;
    boolean[] vis;

    public String[] permutation(String s) {
        int n = s.length();
        rec = new ArrayList<String>();
        vis = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer perm = new StringBuffer();
        backtrack(arr, 0, n, perm);
        int size = rec.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = rec.get(i);
        }
        return recArr;
    }

    public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        if (i == n) {
            rec.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            vis[j] = true;
            perm.append(arr[j]);
            backtrack(arr, i + 1, n, perm);
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }
    }
}


