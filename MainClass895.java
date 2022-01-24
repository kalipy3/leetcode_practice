//优先队列，用index判断谁离栈顶近
//方法一
class FreqStack {

    private int index;
    private Map<Integer,Integer> map;
    private PriorityQueue<int[]> queue;

    public FreqStack() {
        queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])
                {
                    return o2[2]-o1[2];
                }
                return o2[1]-o1[1];
            }
        });
        map=new HashMap<>();
        index=0;
    }

    public void push(int x) {
        int cnt=map.getOrDefault(x,0)+1;
        map.put(x,cnt);
        queue.add(new int[]{x,cnt,index++});
    }

    public int pop() {
        int[] poll = queue.poll();
        map.put(poll[0],poll[1]-1);
        return poll[0];
    }
}

//方法二 官方题解
class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public FreqStack() {
        freq = new HashMap();
        group = new HashMap();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq)
            maxfreq = f;

        group.computeIfAbsent(f, z-> new Stack()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0)
            maxfreq--;
        return x;
    }
}


