package ir.mapsa.javacourse.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SampleMethodRunner {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(10);
//        int d = 0;
//        Calculation add = (a, b) -> a + b;
//        Calculation multiply = (a, b) -> a * b;
//        Callable<String> callable = () -> "Hello world!";
//        Callable<Integer> callable2 = () -> 123;
//
//        System.out.println(add.f(1, 2));
//        System.out.println(multiply.f(1, 2));
//        Runnable2 simpleRunnable = () -> System.out.println("Hello world!");
//        simpleRunnable.run();
//        threadPool.submit(() -> System.out.println("Hello world!"));
//        int a = 12;
//        threadPool.submit(() -> 123+a);
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            numbers.add(random.nextInt());
        }
        System.out.println(numbers);

//        numbers.stream()
//                .map(MyClass::calc)
//                .distinct()
//                .filter(a -> a > 0)
//                .reduce((a, b) -> {
//                    if (a > b) {
//                        return a;
//                    }
//                    return b;
//                }).ifPresent(i-> System.out.println(i));
//        Optional<Integer> add = MyClass.add(null, 2);
//        add.ifPresent(i-> System.out.println(i));

    }
}
