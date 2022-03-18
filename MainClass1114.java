/*
 * MainClass1114.java
 * Copyright (C) 2022 2022-03-18 18:43 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//https://leetcode-cn.com/problems/print-in-order/solution/chang-you-duo-xian-cheng-zhi-zhi-shun-xu-it6f/

使用同步原语的方式：

public class Foo {
    private volatile int flag = 1;
    private final Object object = new Object();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (object) {
            while (flag != 1) object.wait();
            printFirst.run();
            flag = 2;
            object.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (object) {
            while (flag != 2) object.wait();
            printSecond.run();
            flag = 3;
            object.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (object) {
            while (flag != 3) object.wait();
        }
        printThird.run();
    }
}

官方题解的方式，直接借助原子操作类，用起来简单容易理解呀

public class AtomicFoo {
    private final AtomicInteger atomic = new AtomicInteger(0);

    public AtomicFoo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        atomic.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (atomic.get() != 1) {
        }
        printSecond.run();
        atomic.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (atomic.get() != 2) {
        }
        printThird.run();
    }
}

第一种方式既然使用了volatile，已经可以保证可见性，那么就可以简化为：

class Foo {
    private volatile int flag = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (flag != 2) {
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (flag != 3) {
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}



//kalipy错误写法
class Foo {

    ReentrantLock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        c2.signal();

        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        c2.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        c3.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        c3.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        c1.signal();

        lock.unlock();
    }
}

//正确写法
class Foo {

    int num;
    Lock lock;
    //精确的通知和唤醒线程
    Condition condition1, condition2, condition3;

    public Foo() {
        num = 1;
        lock = new ReentrantLock();
        condition1 = lock.newCondition();
        condition2 = lock.newCondition();
        condition3 = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while (num != 1) {//不是1的时候，阻塞
                condition1.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            num = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (num != 2) {//不是2的时候，阻塞
                condition2.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            num = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (num != 3) {//不是3的时候，阻塞
                condition3.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            num = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
