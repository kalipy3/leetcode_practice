//这道题最先是在bili看到up正月点灯笼学到的。 「递归练习」汉诺塔
//
//调用递归函数move的关键在于理解参数含义，即从source柱经由temp柱移动到target柱
class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int N = A.size();
        move(N, A, B, C);
    }

    // 将N个圆盘从A柱经由B柱移动到C柱
    void move(int N, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (N == 1) { // 直接将A柱的圆盘移动到C柱
            C.add(0, A.remove(0));
            return;
        }

        move(N - 1, A, C, B);
        C.add(0, A.remove(0));
        move(N - 1, B, A, C);
    }
}

//写法二
class Solution {
    public void hanota(List<Integer> origin, List<Integer> buffer, List<Integer> destination) {
        // 使用递归函数来完成,需要计数
        move(origin.size(), origin, destination, buffer);
    }

    private void move(int n, List<Integer> origin, List<Integer> destination, List<Integer> buffer) {
        // 如果碰到了一个栈的底,那么说明这个位置上已经没有盘子移动了
        if (n <= 0) return;
        // 从 origin 移动到 buffer 上
        move(n - 1, origin, buffer, destination);
        // 从 origin 移动到 destination 上
        destination.add(origin.get(origin.size() - 1));
        origin.remove(origin.size() - 1);
        // 从 buffer 移动到 destination 上
        move(n - 1, buffer, destination, origin);
    }
}


