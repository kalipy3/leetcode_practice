/*
 * MainClass658.java
 * Copyright (C) 2022 2022-02-16 16:23 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//方法一 大根堆
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            int[] nums = new int[2];
            nums[0] = arr[i];
            nums[1] = Math.abs(arr[i]-x);
            queue.add(nums);
        }
        for (int i = k; i < arr.length; i++) {
            int abs = Math.abs(arr[i]-x);
            int[] top = queue.peek();
            if (top[1]>abs){
                queue.poll();
                int[] temp = new int[2];
                temp[0] = arr[i];
                temp[1] = abs;
                queue.offer(temp);
            }
        }
        for (int[] t:queue){
            list.add(t[0]);
        }
        Collections.sort(list);
        return list;
    }
}

//方法一 写法二 官方题解 不推荐
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(ret, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        ret = ret.subList(0, k);
        Collections.sort(ret);
        return ret;
    }
}

//方法二 推荐
链接：https://leetcode-cn.com/problems/find-k-closest-elements/solution/pai-chu-fa-shuang-zhi-zhen-er-fen-fa-python-dai-ma/
public class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;

        int left = 0;
        int right = size - 1;

        int removeNums = size - k;
        while (removeNums > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            removeNums--;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}

//kalipy一次过 不推荐
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
            }
        });

        for (int i = 0; i < arr.length; i++) {
            pq.offer(new int[]{arr[i], Math.abs(arr[i] - x)});
        }

        for (int i = 0; i < k; i++) {
            ans.add(pq.poll()[0]);
        }
        Collections.sort(ans);

        return ans;
    }
}

//kalipy一次过 推荐
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int removedCnt = 0;
        int l = 0;
        int r = arr.length - 1;
        int n = arr.length;

        while (removedCnt != (n - k)) {
            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                r--;
            } else {
                l++;
            }

            removedCnt++;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = l; i < l + k; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}
