/*
 * MainClass622.java
 * Copyright (C) 2022 2022-02-12 12:59 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//官方题解
class MyCircularQueue {

  private int[] queue;
  private int headIndex;
  private int count;
  private int capacity;

  /** Initialize your data structure here. Set the size of the queue to be k. */
  public MyCircularQueue(int k) {
    this.capacity = k;
    this.queue = new int[k];
    this.headIndex = 0;
    this.count = 0;
  }

  /** Insert an element into the circular queue. Return true if the operation is successful. */
  public boolean enQueue(int value) {
    if (this.count == this.capacity)
      return false;
    this.queue[(this.headIndex + this.count) % this.capacity] = value;
    this.count += 1;
    return true;
  }

  /** Delete an element from the circular queue. Return true if the operation is successful. */
  public boolean deQueue() {
    if (this.count == 0)
      return false;
    this.headIndex = (this.headIndex + 1) % this.capacity;
    this.count -= 1;
    return true;
  }

  /** Get the front item from the queue. */
  public int Front() {
    if (this.count == 0)
      return -1;
    return this.queue[this.headIndex];
  }

  /** Get the last item from the queue. */
  public int Rear() {
    if (this.count == 0)
      return -1;
    int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
    return this.queue[tailIndex];
  }

  /** Checks whether the circular queue is empty or not. */
  public boolean isEmpty() {
    return (this.count == 0);
  }

  /** Checks whether the circular queue is full or not. */
  public boolean isFull() {
    return (this.count == this.capacity);
  }
}



//kalipy一次过 超级送分题
class MyCircularQueue {
    int capacity;
    int count;
    int head;
    int queue[];
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
    }

    public boolean enQueue(int value) {
        if (count == capacity) return false;

        queue[(head + count) % capacity] = value;
        count++;

        return true;
    }

    public boolean deQueue() {
        if (count == 0) return false;

        head = (head + 1) % capacity;
        count--;

        return true;
    }

    public int Front() {
        if (count == 0) return -1;

        return queue[head % capacity];
    }

    public int Rear() {
        if (count == 0) return -1;

        return queue[(head + count - 1) % capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
