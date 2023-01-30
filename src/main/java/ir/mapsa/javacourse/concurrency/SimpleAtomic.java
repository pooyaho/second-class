package ir.mapsa.javacourse.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleAtomic {

    private AtomicBoolean isLoaded = new AtomicBoolean(false);
    private AtomicInteger integer = new AtomicInteger(10);

    public void checkLoaded() {
        if (isLoaded.compareAndSet(false,true)) {
            System.out.println("Loaded");
        }

//        System.out.println("Checked");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
            SimpleAtomic simpleAtomic = new SimpleAtomic();
            for (int i = 0; i < 10; i++) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        simpleAtomic.checkLoaded();

                    }
                });
            }
    }
}
