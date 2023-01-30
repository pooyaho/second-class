package ir.mapsa.javacourse.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton {
    private static final Object lock = new Object();
    private static Singleton SINGLETON;

    private Singleton() {
        System.out.println("Constructor");
    }

    public static Singleton getInstance() {

        if (SINGLETON == null) {
            synchronized (lock) {
                if (SINGLETON == null) {
                    SINGLETON = new Singleton();
                }
            }
        }

        return SINGLETON;

    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Singleton.getInstance();
                }
            });
        }
    }
}
