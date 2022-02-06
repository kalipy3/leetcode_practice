/*
 * MainClass381.java
 * Copyright (C) 2022 2022-02-02 11:48 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//官方题解
class RandomizedCollection {
    //储存每个数字的索引
    Map<Integer, Set<Integer>> index = new HashMap<>();
    //数字集合
    List<Integer> list = new ArrayList<>();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> set = index.getOrDefault(val, new HashSet<Integer>());
        list.add(val);
        //添加索引
        set.add(list.size() - 1);
        index.put(val, set);
        //不是第一次插入为false
        return set.size() == 1;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!index.containsKey(val)) return false;
        //获取list集合中val出现的一个位置
        //使用迭代器获取一个set集合中的元素
        Set<Integer> set = index.get(val);
        int valIndex = set.iterator().next();
        int last = list.get(list.size() - 1);
        //交换val和最后一个元素,
        list.set(valIndex, last);
        //删除val储存的位置
        set.remove(valIndex);
        //删除list中最后一个元素的位置
        Set<Integer> lastSet = index.get(last);
        lastSet.remove(list.size() - 1);
        //如果删除元素恰好就是最后一个元素,避免添加错误元素
        if (valIndex != list.size() - 1) {
            lastSet.add(valIndex);
        }
        //删除最后一个元素
        list.remove(list.size() - 1);
        if (set.size() == 0) {
            index.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
