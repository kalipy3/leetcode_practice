//这道题最先是在bili看到up正月点灯笼学到的。 「递归练习」汉诺塔
//
//调用递归函数move的关键在于理解参数含义，即从source柱经由temp柱移动到target柱
class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int N = A.size();
        move(N, A, B, C);
    }

    // 将N个圆盘从A柱经由B柱移动到C柱!!!!!!!
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
/*
class Solution {
public:
    void hanota(vector<int>& A, vector<int>& B, vector<int>& C) {
        int n = A.size();
        move(n, A, B, C);
    }

    void move(int n, vector<int>& A, vector<int>& B, vector<int>& C){
        if (n < 1){
            return;
        }
        move(n-1, A, C, B);    // 将A上面n-1个通过C移到B
        C.push_back(A.back());  // 将A最后一个移到C
        A.pop_back();          // 这时，A空了
        move(n-1, B, A, C);     // 将B上面n-1个通过空的A移到C
    }
};
*/
