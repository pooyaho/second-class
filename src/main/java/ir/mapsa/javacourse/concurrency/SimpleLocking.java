package ir.mapsa.javacourse.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleLocking {
    private ThreadLocal<Integer> count =new ThreadLocal<>();
    public synchronized  void print() {
        System.out.println("Hello world!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (count.get() == null) {
            count.set(0);

        }
        count.set(count.get()+1);

    }

    public synchronized void print2() {
        System.out.println("Hello world2!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (count.get() == null) {
            count.set(0);

        }
        count.set(count.get()+1);
    }

public int getCount() {
    return count.get();
}

    public static void main(String[] args) throws InterruptedException {
        SimpleLocking simpleLocking = new SimpleLocking();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long l = System.currentTimeMillis();
        List<Callable<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Callable<Integer>() {
                @Override
                public Integer call() {
                    simpleLocking.print();
                    return 0;
                }
            });

        }

        for (int i = 0; i < 5; i++) {
            list.add(new Callable<Integer>() {
                @Override
                public Integer call() {
                    simpleLocking.print2();
                    return 0;
                }
            });

        }

        executorService.invokeAll(list);

        long l1 = System.currentTimeMillis();
        System.out.println(simpleLocking.getCount());

        System.out.println(l1 - l);
    }


}
