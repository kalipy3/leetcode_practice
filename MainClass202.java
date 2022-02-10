//kalipy写法
class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getSum(n);
        while (slow != fast) {
            slow = getSum(slow);
            fast = getSum(fast);
            fast = getSum(fast);
        }

        return 1 == slow;
    }

    public int getSum(int n) {
        int res = 0;
        while (n != 0) {
            res += (n%10) * (n%10);
            n /= 10;
        }
        return res;
    }
}


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

//方法二 官方题解
class Solution {

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}



//方法二 写法二
class Solution {
    public:
        int bitSquareSum(int n) {
            int sum = 0;
            while(n > 0)
            {
                int bit = n % 10;
                sum += bit * bit;
                n = n / 10;
            }
            return sum;
        }

        bool isHappy(int n) {
            int slow = n, fast = n;
            do{
                slow = bitSquareSum(slow);
                fast = bitSquareSum(fast);
                fast = bitSquareSum(fast);
            }while(slow != fast);

            return slow == 1;
        }
};



