package ir.mapsa.javacourse.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
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
//
//                .reduce((a, b) -> {
//                    if (a > b) {
//                        return a;
//                    }
//                    return b;
//                }).ifPresent(i-> System.out.println(i));

//        numbers.stream()
//                .parallel()
//                .filter(i -> i % 2 == 0 && i > 0)
//                .sequential()
//                .reduce((a, b) -> a > b ? a : b)
//                .ifPresent(i -> System.out.println(i));
//        String s = "Hello world Hello";
//        String[] split = s.split(" ");
//        String collect2 = Arrays.stream(split)
//                .collect(Collectors.joining(","));
//        System.out.println(collect2);
//        IntStream.generate(()->random.nextInt()).limit(100).forEach(i-> System.out.println(i));

        try {
            Files.lines(Paths.get("myfile.txt"))
                    .forEach(i-> System.out.println(i));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        Map<String, Long> collect1 = Arrays.stream(split)
//
//                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
//        System.out.println(collect1);
//        Double collect = numbers.stream()
//                .collect(Collectors.averagingInt(i -> i));
//        System.out.println(collect);
//         Map<Integer, List<Integer>> collect = numbers.stream()
//                .filter(i -> i % 2 == 1)
//                .collect(Collectors.groupingBy(i -> i % 3));
//        System.out.println(collect);

    }
}

class MyClass {

    public void print() {
        System.out.println("Hello world");
    }

    public String print2() {
        String s = "Hello world";
        System.out.println(s);
        return s;
    }

    public String print3(int count) {
        String s = "Hello world";
        System.out.println(s);
        return s + count;
    }

    public static int calc(int item) {
        return item + 1;
    }

    public static Optional<Integer> add(Integer a, Integer b) {
        if (a == null || b == null) {
            return Optional.empty();
        }
        return Optional.of(a + b);
    }
}


interface Runnable2 {
    void run();
}

interface Calculation {
    int f(int a, int b);
}

class MyRunnable implements Runnable {

    private final MyClass myClass;

    MyRunnable(MyClass myClass) {
        this.myClass = myClass;
    }


    @Override
    public void run() {
        myClass.print();

    }
}

class SimpleRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello world!");
    }
}


