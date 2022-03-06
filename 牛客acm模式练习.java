//牛客输入输出练习地址：
https://ac.nowcoder.com/acm/contest/5657#question

scanner可以允许输入多行，
next() 每次取到一个间隔符前面的数据 如： 输入 a b c 取值应该是a，因为a后面有空格
nextLine() 每次取一个换行符前面的数据 如：输入 a b c 回车，取值 就是a b c
nextInt() 是取next() 然后把字符串解析成一个int数字。
hasNextInt() 是判断下次调用next()是否可以得到一个可以安全解析成int的字符串。如果已经到达输入的结尾，或者下一个next()的返回值不能解析为一个数字，即不符合数字的格式，那么返回发false 

https://blog.csdn.net/tuke_tuke/article/details/47104993
https://zhuanlan.zhihu.com/p/392440391

/*
 * Main.java
 * Copyright (C) 2022 2022-03-06 10:21 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

/*
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(a + b);
        }
    }
}
*/

/*
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(a + b);
            }
        }
    }
}
*/

/*
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) return;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                 sum += a;

            }
            System.out.println(sum);
        }
    }
}
*/


/*
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int lineNum = sc.nextInt();
            for (int i = 0; i < lineNum; i++) {
                int n = sc.nextInt();
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += sc.nextInt();
                }
                      System.out.println(sum);
                
            }
      
        }
    }
}
*/


/*
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] s=sc.nextLine().split(" ");
            int n=s.length;
            int sum=0;
            for(int i=0;i<n;i++){
                sum=sum+Integer.parseInt(s[i]);
            }
            System.out.println(sum);
        }
    }
}
*/

/*
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            int num=sc.nextInt();
            sc.nextLine();//注意：这句不能少！！！！
            String[] s=sc.nextLine().split(" ");
            Arrays.sort(s);
            System.out.println(String.join(" ",s));
        }
    }
}


import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] str = sc.nextLine().split(" ");

            Arrays.sort(str);

            System.out.println(String.join(" ", str));
        }
    }
}
*/


/*
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] str = sc.nextLine().split(" ");
            
            Arrays.sort(str);
            
            System.out.println(String.join(" ", str));
        }
    }
}
*/

/*
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] str = sc.nextLine().split(",");
            
            Arrays.sort(str);
            
            System.out.println(String.join(",", str));
        }
    }
}
*/



