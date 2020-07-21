package jzl.com.crackcodeinterview.O;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * jzl.com.crackcodeinterview.F
 * Created by kingj on 2020/6/19 0019.
 * 15.5 同一个 Foo 实例 会被 传入 3 个 不同 的 线程。 threadA 会 调用 first， threadB 会 调用 second， threadC 会 调用 third。 设计 一种 机制， 确保 first 会在 second 之前 调用， second 会在 third 之前 调用。
 */
public class O5 {

    public class FooBad {
        public int pauseTime = 1000;
        public ReentrantLock lock1, lock2;

        public FooBad() {
            try {
                lock1 = new ReentrantLock();
                lock2 = new ReentrantLock();
                lock1.lock();
                lock2.lock();
            } catch (Exception e) {

            }
        }

        public void first() {
            try {
                lock1.unlock();
            } catch (Exception e) {

            }
        }

        public void second() {
            try {
                lock1.lock();
                lock1.unlock();

                lock2.unlock();
            } catch (Exception e) {

            }
        }

        public void third() {
            try {
                lock2.lock();
                lock2.unlock();
            } catch (Exception e) {

            }
        }
    }

    public class Foo {
        public Semaphore sem1, sem2;

        public Foo() {
            try {
                sem1 = new Semaphore(1);
                sem2 = new Semaphore(1);

                sem1.acquire();
                sem2.acquire();
            } catch (Exception e) {

            }
        }

        public void first() {
            try {
                //...
                sem1.release();
            } catch (Exception e) {

            }
        }

        public void second() {
            try {
                sem1.acquire();
                sem1.release();
                //...
                sem2.release();
            } catch (Exception e) {

            }
        }

        public void third() {
            try {
                sem2.acquire();
                sem2.release();
                //...
            } catch (Exception e) {

            }
        }
    }

    private String longboard = "long";
    private String shortboard = "short";
    private String[] array = new String[]{longboard, shortboard};

    public List<String> getAllBoard(int k) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            result.addAll(recursion(k, 1, array[i]));
        }
        return result;
    }

    private List<String> recursion(int k, int index, String type) {
        ArrayList<String> result = new ArrayList<>();
        if (index == k) {
            result.add(type);
        } else {
            for (int i = 0; i < array.length; i++) {
                ArrayList temp = (ArrayList) recursion(k, index+1, array[i]);
                for (int j = 0; j < temp.size(); j++) {
                    String s = temp.get(j) + type;
                    result.add(s);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new O5().getAllBoard(3).toString());
    }

}
