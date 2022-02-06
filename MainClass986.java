/*
 * MainClass986.java
 * Copyright (C) 2022 2022-01-31 17:54 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy差点一次过 关键在于23-26行的指针移动
class Solution {
  public int[][] intervalIntersection(int[][] A, int[][] B) {
    List<int[]> ans = new ArrayList();
    int i = 0, j = 0;

    while (i < A.length && j < B.length) {
      // Let's check if A[i] intersects B[j].
      // lo - the startpoint of the intersection
      // hi - the endpoint of the intersection
      int lo = Math.max(A[i][0], B[j][0]);// 交集区间的左端，取它们的较大者
      int hi = Math.min(A[i][1], B[j][1]);// 交集区间的右端，取它们的较小者
      if (lo <= hi)// 形成了交集区间
        ans.add(new int[]{lo, hi});

      // Remove the interval with the smallest endpoint
      if (A[i][1] < B[j][1])// 谁先结束，谁的指针就步进，考察下一个子区间
        i++;
      else
        j++;
    }

    return ans.toArray(new int[ans.size()][]);
  }
}
