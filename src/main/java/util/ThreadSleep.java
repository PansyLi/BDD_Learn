package util;

public class ThreadSleep {

    public static void  threadSleep() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(2000);
    }
}