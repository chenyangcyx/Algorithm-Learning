package Concurrent;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/*
public class 生产者消费者 {
    LinkedBlockingQueue<Integer> list = new LinkedBlockingQueue<>();


    public void 生产者消费者() {
        Thread p1 = new Thread(new Producer());
        Thread p2 = new Thread(new Producer());
        Thread p3 = new Thread(new Producer());
        Thread p4 = new Thread(new Producer());
        Thread c1 = new Thread(new Consumer());
        Thread c2 = new Thread(new Consumer());
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        c1.start();
        c2.start();
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    int obj = list.take();
                    System.out.println("消费了物品：" + obj + "，现库存：" + list.size());
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            Random ran = new Random();
            while (true) {
                int obj = ran.nextInt();
                try {
                    list.put(obj);
                    System.out.println("生产了物品：" + obj + "，现库存：" + list.size());
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
*/


/*
public class 生产者消费者 {
    public class Storage {
        // 仓库容量
        private final int MAX_SIZE = 10;
        // 仓库存储的载体
        private LinkedList<Object> list = new LinkedList<>();

        public void produce() {
            synchronized (list) {
                while (list.size() + 1 > MAX_SIZE) {
                    System.out.println("【生产者" + Thread.currentThread().getName()
                            + "】仓库已满");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(new Object());
                System.out.println("【生产者" + Thread.currentThread().getName()
                        + "】生产一个产品，现库存" + list.size());
                list.notifyAll();
            }
        }

        public void consume() {
            synchronized (list) {
                while (list.size() == 0) {
                    System.out.println("【消费者" + Thread.currentThread().getName()
                            + "】仓库为空");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.remove();
                System.out.println("【消费者" + Thread.currentThread().getName()
                        + "】消费一个产品，现库存" + list.size());
                list.notifyAll();
            }
        }
    }

    public class Producer implements Runnable{
        private Storage storage;

        public Producer(){}

        public Producer(Storage storage){
            this.storage = storage;
        }

        @Override
        public void run(){
            while(true){
                try{
                    Thread.sleep(1000);
                    storage.produce();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public class Consumer implements Runnable{
        private Storage storage;

        public Consumer(){}

        public Consumer(Storage storage){
            this.storage = storage;
        }

        @Override
        public void run(){
            while(true){
                try{
                    Thread.sleep(3000);
                    storage.consume();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void execute(){
        Storage storage = new Storage();
        Thread p1 = new Thread(new Producer(storage));
        Thread p2 = new Thread(new Producer(storage));
        Thread p3 = new Thread(new Producer(storage));

        Thread c1 = new Thread(new Consumer(storage));
        Thread c2 = new Thread(new Consumer(storage));
        Thread c3 = new Thread(new Consumer(storage));

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
*/


public class 生产者消费者 {
    public void execute() {
        Storage storage = new Storage();
        Thread p1 = new Thread(new Producer(storage));
        Thread p2 = new Thread(new Producer(storage));
        Thread p3 = new Thread(new Producer(storage));

        Thread c1 = new Thread(new Consumer(storage));
        Thread c2 = new Thread(new Consumer(storage));
        Thread c3 = new Thread(new Consumer(storage));

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
    }

    public class Storage {

        // 仓库最大存储量
        private final int MAX_SIZE = 10;
        // 锁
        private final Lock lock = new ReentrantLock();
        // 仓库满的条件变量
        private final Condition full = lock.newCondition();
        // 仓库空的条件变量
        private final Condition empty = lock.newCondition();
        // 仓库存储的载体
        private final LinkedList<Object> list = new LinkedList<Object>();

        public void produce() {
            // 获得锁
            lock.lock();
            while (list.size() + 1 > MAX_SIZE) {
                System.out.println("【生产者" + Thread.currentThread().getName()
                        + "】仓库已满");
                try {
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("【生产者" + Thread.currentThread().getName()
                    + "】生产一个产品，现库存" + list.size());

            empty.signalAll();
            lock.unlock();
        }

        public void consume() {
            // 获得锁
            lock.lock();
            while (list.size() == 0) {
                System.out.println("【消费者" + Thread.currentThread().getName()
                        + "】仓库为空");
                try {
                    empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println("【消费者" + Thread.currentThread().getName()
                    + "】消费一个产品，现库存" + list.size());

            full.signalAll();
            lock.unlock();
        }
    }

    public class Producer implements Runnable {
        private Storage storage;

        public Producer() {
        }

        public Producer(Storage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    storage.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class Consumer implements Runnable {
        private Storage storage;

        public Consumer() {
        }

        public Consumer(Storage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(3000);
                    storage.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}