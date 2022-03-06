//方法一 官方题解
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        //判断是不是因为 1 引起的循环，是的话就是快乐数，否则不是快乐数
        return n == 1;
    }

    // 取数值各个位上的单数之和
    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}

//写法三
class Solution {
    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;
        do
        {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int getNext(int n) {
        int ans = 0;
        
        while (n != 0) {
        int t = n % 10;
        ans += t*t;
        n = n / 10;
        }


        return ans;
    }
}

//写法四
class Solution {
    public boolean isHappy(int n) {

        int slow = n;
        //int fast = getNext(n);//也ok
        int fast = getNext(getNext(n));
        while (slow != fast) 
        {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }

        return slow == 1;
    }

    private int getNext(int n) {
        int ans = 0;
        
        while (n != 0) {
        int t = n % 10;
        ans += t*t;
        n = n / 10;
        }


        return ans;
    }
}
