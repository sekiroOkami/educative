package org.basic;

public class Demonstration {
    public static void main(String[] args) throws InterruptedException {
        SumupExample.runTest();
    }
}

class SumupExample {
    long stratRange;
    long endRange;
    long counter = 0;
    static long MAX_NUM = Integer.MAX_VALUE;

    public SumupExample(long stratRange, long endRange) {
        this.stratRange = stratRange;
        this.endRange = endRange;
    }

    public void add() {
        for (long i = stratRange; i<=endRange; i++) {
            counter += i;
        }
    }

    public static void runTest() throws InterruptedException {
        oneThread();
        twoThread();
    }

    private static void twoThread() throws InterruptedException{
        long start = System.currentTimeMillis();
        SumupExample s1 = new SumupExample(1, MAX_NUM/2);
        var s2 = new SumupExample(1 + (MAX_NUM/2), MAX_NUM);
        Thread t1 = new Thread(()-> s1.add());
        Thread t2 = new Thread(()-> s2.add());
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        long finalCount = s1.counter + s2.counter;
        long end = System.currentTimeMillis();
        System.out.println("Two threads final count = " + finalCount + " took " + (end - start));
    }

    private static void oneThread() {
        long start = System.currentTimeMillis();
        SumupExample s = new SumupExample(1, MAX_NUM);
        s.add();
        long end = System.currentTimeMillis();
        System.out.println("Single thread final count = " + s.counter + " took " + (end - start));
    }
}
