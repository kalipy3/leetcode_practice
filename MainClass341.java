/*
 * MainClass341.java
 * Copyright (C) 2022 2022-02-12 13:51 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//面试时要写出方法二

//官方题解 方法一
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> vals;
    private Iterator<Integer> cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        vals = new ArrayList<Integer>();
        dfs(nestedList);
        cur = vals.iterator();
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                vals.add(nest.getInteger());
            } else {
                dfs(nest.getList());
            }
        }
    }
}


//方法二 这题题解通俗易懂
//链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator/solution/fu-xue-ming-zhu-xiang-jie-ti-yi-shu-li-d-n4qa/
/*
class NestedIterator {
public:
    NestedIterator(vector<NestedInteger> &nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; --i) {
            st.push(nestedList[i]);
        }
    }

    int next() {
        NestedInteger cur = st.top(); st.pop();
        return cur.getInteger();
    }

    bool hasNext() {
        while (!st.empty()) {
            NestedInteger cur = st.top();
            if (cur.isInteger()) {
                return true;
            }
            st.pop();
            for (int i = cur.getList().size() - 1; i >= 0; --i) {
                st.push(cur.getList()[i]);
            }
        }
        return false;
    }
private:
    stack<NestedInteger> st;
};
*/


