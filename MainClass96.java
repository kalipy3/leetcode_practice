//官方题解 直接看这里的题解，你可以看懂
//给定一个有序序列1...n，为了构建出一棵二叉搜索树，我们可以遍历每个数字 i，将该数字作为树根，将 1⋯(i−1) 序列作为左子树，将 (i+1)⋯n序列作为右子树。接着我们可以按照同样的方式递归构建左子树和右子树。

//结题思路：假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}

//方法二 推荐 比较直观
public int numTrees(int n) {
    if (n == 1 || n == 0)
        return 1;
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum = sum + numTrees(i) * numTrees(n - i - 1);
    }
    return sum;
}
