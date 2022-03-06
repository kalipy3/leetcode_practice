//请直接先看方法一的代码 然后直接看方法终的代码
//
//方法一
public int compareVersion(String version1, String version2) {
    String[] a1 = version1.split("\\.");
    String[] a2 = version2.split("\\.");

    for(int n = 0; n < Math.max(a1.length, a2.length); n++){
        int i = (n < a1.length ? Integer.valueOf(a1[n]) : 0);
        int j = (n < a2.length ? Integer.valueOf(a2[n]) : 0);
        if(i < j) return -1;
        else if(i > j) return 1;
    }
    return 0;  
}

//写法终
public int compareVersion(String version1, String version2) {
    int index1 = 0;
    int index2 = 0;
    while (index1 < version1.length() || index2 < version2.length()) {
        int res1 = 0;
        //遍历第一个字符串，同时记录 . 分割的这个数字大小
        while (index1 < version1.length() && version1.charAt(index1) != '.') {
            res1 = res1 * 10 + (version1.charAt(index1) - '0');
            index1++;
        }
        int res2 = 0;
        //遍历第二个字符串，同时记录 . 分割的这个数字大小
        while (index2 < version2.length() && version2.charAt(index2) != '.') {
            res2 = res2 * 10 + (version2.charAt(index2) - '0');
            index2++;
        }
        //比较这两个数字大小，相等则进入下一个循环
        if (res1 > res2) {
            return 1;
        } else if (res1 < res2) {
            return -1;
        }
        index1++;
        index2++;
    }
    return 0;
}

