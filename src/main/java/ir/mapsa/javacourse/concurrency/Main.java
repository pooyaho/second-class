package ir.mapsa.javacourse.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        int[] ints = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            ints[i] = i;
        }
//        Runnable target = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(5000L);
//                    System.out.println("Hello world from thread!");
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long l = System.currentTimeMillis();
//        MyTask target = new MyTask();
//        Thread thread = new Thread( target);
//        thread.start();

//        Future<String> future1 = executorService.submit(target);
//        executorService.shutdown();
        List<Callable<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lists.add(new MyTask(ints, 10000000 * i, (i + 1) * 10000000));
        }
//        lists.add(new MyTask());
        List<Future<Integer>> futures = executorService.invokeAll(lists);
        for (Future<Integer> future : futures) {
            System.out.println(future.get());
        }
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < 100000000; i++) {
//            if (ints[i] > max) {
//                max = ints[i];
//            }
//        }
//        System.out.println(max);
//        String s = future1.get(1,TimeUnit.SECONDS);
//        System.out.println(s);
//        System.out.println("Hello world from main!");
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}

class MyTask implements Callable<Integer> {

    private final int[] ints;
    private final int from;
    private final int to;

    public MyTask(int[] ints, int from, int to) {
        this.ints=ints;
        this.from = from;
        this.to = to;
    }
    @Override
    public Integer call() throws Exception {
        int max = Integer.MIN_VALUE;
        for (int i = from; i < to; i++) {
            if (ints[i] > max) {
                max = ints[i];
            }
        }
        return max;
//        try {
//            Thread.sleep(5000L);
////            System.out.println("Hello world from thread!");
//            return "Hello world";
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
