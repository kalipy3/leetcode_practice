/*
 * 补充题_求区间最小数乘区间和的最大值.java
 * Copyright (C) 2022 2022-02-11 21:40 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//题目请见 补充题:求区间最小数乘区间和的最大值 (2022_2_11 下午9_49_01).html

//方法一 暴力破解
设第i个点为最小值，往两边扩展，直到左右两端触碰到比它更小的值；则找到了该点为区间内最小点并且区间和为最大的情形，遍历即可。
/*
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:

	void getAns(int N, vector<int> nums, int &ans) {
		// 以每个点为起点，往后寻找区间，累加和直到遇到一个比它小的数或者到尽头
		int sum = 0;
		for (int i = 0; i < nums.size(); ++i) {
			sum=nums[i];//假设该点为最小值，则求该点为最小值时的最大区间和
			int j=i+1;
			while (nums[j]>=nums[i] &&j<nums.size() ){
				sum+=nums[j++];
			}
			int k=i-1;
			while (nums[k]>=nums[i] && k>=0){
				sum+=nums[k--];
			}
			ans = max(ans,sum*nums[i]);
		}
	};
};


int main()
{
    int N;
#if 0
     cin>>N;
     vector<int> nums;

     for(int i=0;i<N;i++){
         int x;
         cin >> x ;
         nums.push_back(x);
     }
#elif 1
    N = 10;
    vector<int> nums={81,87,47,59,81,18,25,40,56,0};
#elif 0
     N = 3;
     vector<int> nums={6,2,1};
#endif

    int ans = 0;
	Solution solu;
	solu.getAns(N,nums,ans);

    cout<<ans<<endl;

    return 0;
}
*/



//方法二
//单调栈，时间复杂度O(N)
/*
#include <iostream>
#include <vector>
#include <stack>
using namespace std;
const int N = 500000+10;
int a[N];
int dp[N];
stack<int> s;
int main()
{
    int n,res=0;
    cin >> n;
    for(int i = 0; i < n; i ++) cin >> a[i];
    //前缀和便于快速求区间和，例如求[l,r]区间和=dp[r+1]-dp[l]。l和r的取值范围是[0,n)
    for(int i = 1; i <= n; i ++) dp[i] = dp[i-1] + a[i-1]; 
    for(int i = 0; i < n; i ++) {
        while(!s.empty() && a[i] <= a[s.top()]) {
            int peak = a[s.top()];
            s.pop();
            int l = s.empty()? -1 : s.top();
            int r = i; 
            //l和r是边界，因此区间是[l+1,r-1]，其区间和dp[r+1]-dp[l]
            int dist = dp[r] - dp[l+1];
            res = max(res,peak*dist);
        }
        s.push(i);
    }
    while(!s.empty())
    {
        int peak = a[s.top()];
        s.pop();
        int l = s.empty()? -1 : s.top();
        int r = n; 
        
        int dist = dp[r] - dp[l+1];
        res = max(res,peak*dist);
    }
    cout << res << endl; 
}
*/
