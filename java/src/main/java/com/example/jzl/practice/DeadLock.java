package com.example.jzl.practice;

public class DeadLock {

    public void doSomething() {
    }

    private class OrderDeadLock {
        private final Object A = new Object();
        private final Object B = new Object();

        public void leftRight() {
            synchronized (A) {
                synchronized (B) {
                    doSomething();
                }
            }
        }

        public void rightLeft() {
            synchronized (B) {
                synchronized (A) {
                    doSomething();
                }
            }
        }
    }

    private class ActiveOrderDeadlock {
        public void transferMoney(Object from, Object to, int amount) {
            synchronized (from) {
                synchronized (to) {
                    doSomething();
                }
            }
        }
    }

    private class SynergicObjectOrderDeadlock{
        private class Taxi{
            public synchronized void notifyDispatcher(){
                new Dispatcher().doSomething();
            }
            public synchronized void doSomething(){}
        }
        private class Dispatcher{
            public synchronized void notifyTaxi(){
                new Taxi().doSomething();
            }
            public synchronized void doSomething(){}
        }
    }
}
