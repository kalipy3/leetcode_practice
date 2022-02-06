/*
 * MainClass1424.java
 * Copyright (C) 2022 2022-02-02 16:04 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//链接：https://leetcode-cn.com/problems/diagonal-traverse-ii/solution/treemapan-dui-jiao-xian-ju-he-zhi-by-zuo-zhou-ren/
//请先看该题解 如果代码理解不了，请跟着走一遍就懂了
/*
map:
0:{[1]}
1:{[2]}
2:{[3]}

1:{2,4}
2:{[3, 5]}
3:{[6]}

2:{[3,5,7]}
3:{[6,8]}
4:{[9]}
*/
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int len = 0;
		Map<Integer,List<Integer>> map = new TreeMap<>();
		for(int i = 0;i < nums.size();i++) {
			len += nums.get(i).size(); // 获取最后要返回的数组的长度，即元素个数
			for(int j = 0;j < nums.get(i).size();j++) {
				if(map.containsKey(i + j)) {
					map.get(i + j).add(nums.get(i).get(j));
				}
				else {
					List<Integer> list = new ArrayList<>();
					list.add(nums.get(i).get(j));
					map.put(i + j, list);
				}
			}
		}
		int[] ans = new int[len];
		int index = 0;
		for(int key : map.keySet()) { // 遍历map
			List<Integer> list = map.get(key);
			for(int j = list.size() - 1;j >= 0;j--) { // 根据题目的输出要求确定生成数组中元素的顺序
				ans[index] = list.get(j);
				index++;
			}
		}
        return ans;
    }
}


//为什么HashMap不行？
//因为哈希表是无序的，在组合最后的结果时可能会出现问题。使用有序的TreeMap和LinkedHashMap就不会出现这样的问题。
//这题里面其实也可以用HashMap；因为i+j的和是连续的且最大值max可以求得，i+j的范围是[0,max]
//写法二
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int cnt=0,ij_max=0;
        for(int i=nums.size()-1;i>=0;i--){
            cnt+=nums.get(i).size();
            ij_max=Math.max(ij_max,i+nums.get(i).size()-1);
            for(int j=0;j<nums.get(i).size();j++){
            //for(int j = nums.get(i).size()-1;j>=0;j--){//也ok
                if(map.containsKey(i+j)){
                    map.get(i+j).add(nums.get(i).get(j));
                }else{
                    List<Integer> tmp=new LinkedList<>();
                    tmp.add(nums.get(i).get(j));
                    map.put(i+j,tmp);
                }
            }
        }
        int[] res=new int[cnt];
        int index=0;
        for(int ij=0;ij<=ij_max;ij++){
            List<Integer> tmp=map.get(ij);
            for(int j=0;j<tmp.size();j++){
                res[index++]=tmp.get(j);
            }
        }
        return res;
    }
}

//写法三
public int[] findDiagonalOrder(List<List<Integer>> nums) {
    List<List<Integer>> lists = new ArrayList<>();
    int len = 0;
    for(int i = 0;i<nums.size();i++){
        len+= nums.get(i).size();
        for(int j = 0;j<nums.get(i).size();j++){
            if(i+j>=lists.size()){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(0, nums.get(i).get(j));
                lists.add(tmp);
            }else {
                lists.get(i+j).add(0, nums.get(i).get(j));
            }
        }
    }

    int[] res = new int[len];
    int index = 0;
    for(List<Integer> list:lists){
        for(Integer l:list) {
            res[index++] = l;
        }
    }
    return res;
}
