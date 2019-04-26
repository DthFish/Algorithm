package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程分别陆续输出 1.2.3.4.5...
 */
public class OutputSingleDouble {

    private static int count = 0;
    private static ReentrantLock lock = new ReentrantLock(true);
    private static Condition notSingle = lock.newCondition();
    private static Condition notDouble = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {

            while (true) {
                lock.lock();
                try {
                    while (count % 2 == 0) {
                        notDouble.await();
                    }
                    System.out.println(++count);
                    Thread.sleep(1000);
                    notSingle.signal();


                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }

        }).start();

        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (count % 2 != 0) {
                        notSingle.await();
                    }
                    System.out.println(++count);
                    Thread.sleep(1000);
                    notDouble.signal();

                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }

        }).start();


    }
}
