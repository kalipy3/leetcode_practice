/*
 * MainClass380.java
 * Copyright (C) 2022 2022-02-02 12:39 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//直接看官方题解替课
class RandomizedSet {
  Map<Integer, Integer> map;
  List<Integer> list;
  Random rand = new Random();

  /** Initialize your data structure here. */
  public RandomizedSet() {
    map = new HashMap();
    list = new ArrayList();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    if (map.containsKey(val)) return false;

    map.put(val, list.size());
    list.add(list.size(), val);
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    if (! map.containsKey(val)) return false;

    // move the last element to the place idx of the element to delete
    int lastElement = list.get(list.size() - 1);
    int idx = map.get(val);
    list.set(idx, lastElement);
    // delete the last element
    list.remove(list.size() - 1);

    map.put(lastElement, idx);
    map.remove(val);
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    return list.get(rand.nextInt(list.size()));
  }
}

//实际面试时，为防止出错，按照如下例子来写删除的代码
/*
 list:1 val last
 map: {1,0} {val, 1} {last, 2}

 remove(val)

 list:1 last
 map: {1,0} {3,1}
*/
