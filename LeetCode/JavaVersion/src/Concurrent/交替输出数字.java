package Concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


// 使用Semaphore信号量实现
public class 交替输出数字 {
    final Semaphore s_jishu = new Semaphore(1);
    final Semaphore s_oushu = new Semaphore(0);

    public void 交替输出数字(){
        Thread t1=new Thread(new JiShu());
        Thread t2=new Thread(new OuShu());
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (Exception e){}
    }

    class JiShu implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 100; i += 2) {
                try {
                    s_jishu.acquire();
                    System.out.println(i);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    s_oushu.release();
                }
            }
        }
    }

    class OuShu implements Runnable{
        @Override
        public void run() {
            for (int i = 2; i <= 100; i += 2) {
                try {
                    s_oushu.acquire();
                    System.out.println(i);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    s_jishu.release();
                }
            }
        }
    }
}


/*
// 使用Object.wait()，Object.notify()实现
public class 交替输出数字 {
    final Object monitor = new Object();

    public void 交替输出数字() {
        Thread t1 = new Thread(new JiShu());
        Thread t2 = new Thread(new OuShu());
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        }
    }

    class JiShu implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 100; i += 2) {
                synchronized (monitor) {
                    System.out.println(i);
                    monitor.notify();
                    try {
                        monitor.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class OuShu implements Runnable {
        @Override
        public void run() {
            for (int i = 2; i <= 100; i += 2) {
                synchronized (monitor) {
                    System.out.println(i);
                    monitor.notify();
                    try {
                        if (i < 100) monitor.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
*/


/*
// 使用Lock+Condition的方法
public class 交替输出数字 {
    ReentrantLock lock = new ReentrantLock();
    Condition jishu_con = lock.newCondition();
    Condition oushu_con = lock.newCondition();

    public void 交替输出数字() {
        Thread t1 = new Thread(new JiShu());
        Thread t2 = new Thread(new OuShu());
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        }
    }

    class JiShu implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 100; i += 2) {
                try {
                    lock.lock();
                    System.out.println(i);
                    oushu_con.signal();
                    jishu_con.await();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    class OuShu implements Runnable {
        @Override
        public void run() {
            for (int i = 2; i <= 100; i += 2) {
                try {
                    lock.lock();
                    System.out.println(i);
                    jishu_con.signal();
                    if (i < 100) oushu_con.await();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
*/

// 使用AtomicInteger和volatile组合
/*
public class 交替输出数字 {
    volatile boolean flag = true;
    AtomicInteger num = new AtomicInteger(1);

    public void 交替输出数字() {
        Thread t1 = new Thread(new JiShu());
        Thread t2 = new Thread(new OuShu());
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
        }
    }

    class JiShu implements Runnable {
        @Override
        public void run() {
            while (num.get() <= 100) {
                if (!flag) {
                    System.out.println(num.getAndIncrement());
                    flag = true;
                }
            }
        }
    }

    class OuShu implements Runnable {
        @Override
        public void run() {
            while (num.get() <= 100) {
                if (flag) {
                    System.out.println(num.getAndIncrement());
                    flag = false;
                }
            }
        }
    }
}
*/