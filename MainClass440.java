作者：venturekwok
链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/solution/java-zi-dian-xu-si-lu-qing-xi-dai-ma-jia-2ugh/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public int findKthNumber(int n, int k) {
        long cur = 1;
        k -= 1;

        while(k > 0){
            int nodes = getNodes(n, cur);
            if(k >= nodes){
                k -= nodes;
                cur++;      //go right
            }else{
                k -= 1;
                cur *= 10;  //go down
            }
        }

        return (int)cur;
    }

    private int getNodes(int n, long cur){
        long next = cur + 1;
        long totalNodes = 0;

        while(cur <= n){
            totalNodes += Math.min(n - cur + 1, next - cur);

            next *= 10;
            cur *= 10;
        }

        return (int)totalNodes;
    }
}

//写法二
class Solution {
	public int findKthNumber(int n, int k) {
    	int cur=1;//第一字典序小的(就是1)
    	int prefix=1;// 前缀从1开始
    	while(cur<k) {
    		int tmp=count(n,prefix); //当前prefix峰的值
    		if(tmp+cur>k) {// 找到了
    			prefix*=10; //往下层遍历
    			cur++;//一直遍历到第K个推出循环
    		}else {
    			prefix++;//去下个峰头(前缀)遍历
    			cur+=tmp;//跨过了一个峰(前缀) 
    		}
    	}//退出循环时 cur==k 正好找到
    	return prefix;
    }

	private int count(int n, int prefix) {
          	//不断向下层遍历可能一个乘10就溢出了, 所以用long
		long cur=prefix;
		long next=cur+1;//下一个前缀峰头
		int count=0;
		while(cur<=n) {
			count+=Math.min(n+1,next)-cur;//下一峰头减去此峰头
			 // 如果说刚刚prefix是1，next是2，那么现在分别变成10和20
	        // 1为前缀的子节点增加10个，十叉树增加一层, 变成了两层
	        
	        // 如果说现在prefix是10，next是20，那么现在分别变成100和200，
	        // 1为前缀的子节点增加100个，十叉树又增加了一层，变成了三层
			cur*=10;
			next*=10; //往下层走
		}
		return count;
	}
}
