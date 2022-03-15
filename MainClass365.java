/*
 * MainClass365.java
 * Copyright (C) 2022 2022-02-09 16:57 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//方法一 官方题解 推荐!! 通俗易懂
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {//不加这个if判断也ok
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }

    public int gcd(int x, int y) {//记忆方法 [x] [y] remainder  [x%y] 相邻的两个元素，后面的赋值给前面的
        int remainder = x % y;
        while (remainder != 0) {
            x = y;
            y = remainder;
            remainder = x % y;
        }
        return y;
    }
}


https://leetcode-cn.com/problems/water-and-jug-problem/solution/tu-de-yan-du-you-xian-bian-li-by-liweiwei1419/

https://leetcode-cn.com/problems/water-and-jug-problem/solution/shui-hu-wen-ti-de-jie-ti-si-kao-java-by-wang-code-/

https://leetcode-cn.com/problems/water-and-jug-problem/solution/fei-gcdshu-xue-bfsdfsxiao-xue-sheng-du-n-neo2/

//可以参考这个图 https://leetcode-cn.com/problems/water-and-jug-problem/solution/tu-jie-bfs-c-jie-zhu-unordered_set-queue-shi-xian-/
这道题目一眼看过去可以用BFS。Java没有原生的Pair，所以我用Map.Entry替代了。leetcode上需要额外加上import语句。 注意到这道题操作水壶的时候，两个水壶不可能同时都是半满的。如果某个水壶是半满的，另外一个肯定是满的或者空的。而且如果某个水壶是半满的（此时另外一个就是空的或者满的），就不能直接把这个水壶填满，也不能把这个半满的水倒掉，因为这会回到初始状态，这么做没有意义。

import java.util.*;

class Solution {
  public boolean canMeasureWater(int x, int y, int z) {
    if (z == 0) {
      return true;
    }
    if (x + y < z) {
      return false;
    }
    Queue<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
    AbstractMap.SimpleEntry<Integer, Integer> start = new AbstractMap.SimpleEntry<>(0, 0);
    queue.add(start);
    Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
    visited.add(start);
    while (!queue.isEmpty()) {
      Map.Entry<Integer, Integer> entry = queue.poll();
      int curX = entry.getKey();
      int curY = entry.getValue();
      if (curX == z || curY == z || curX + curY == z) {
        return true;
      }
      if (curX == 0) {
        // 把第一个桶填满
        addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(x, curY));
      }
      if (curY == 0) {
        // 把第二个桶填满
        addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX, y));
      }
      if (curY < y) {
        // 把第一个桶倒空
        addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(0, curY));
      }
      if (curX < x) {
        // 把第二个桶倒空
        addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX, 0));
      }

      // y - curY是第二个桶还可以再加的水的升数，但是最多只能加curX升水。
      int moveSize = Math.min(curX, y - curY);
      // 把第一个桶里的curX升水倒到第二个桶里去。
      addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX - moveSize, curY + moveSize));
      // 反过来同理，x - curX是第一个桶还可以再加的升数，但是最多只能加curY升水。
      moveSize = Math.min(curY, x - curX);
      // 把第一个桶里的curX升水倒到第二个桶里去。
      addIntoQueue(queue, visited, new AbstractMap.SimpleEntry<>(curX + moveSize, curY - moveSize));
    }
    return false;
  }

  private void addIntoQueue(Queue<Map.Entry<Integer, Integer>> queue,
                            Set<Map.Entry<Integer, Integer>> visited,
                            Map.Entry<Integer, Integer> newEntry) {
    if (!visited.contains(newEntry)) {
      visited.add(newEntry);
      queue.add(newEntry);
    }
  }
}
小Tips：如果某天你写了一个BFS版本的搜索，如何最快的速度再写一份DFS版本发的呢？只需要把queue改为stack就可以了~

还有，visited这个set的更新，一定要在入queue的时候，而不是在queue取出元素的时候，否则队列里会塞很多很多已经遍历过的状态~（某个状态可能是由多个之前的状态转移过来的，会导致该状态的被多次加到queue里去），这点非常重要！！在某些题目的情况下BFS没写好，性能差距是很大的！！
