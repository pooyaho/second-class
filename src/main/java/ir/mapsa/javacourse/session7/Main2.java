package ir.mapsa.javacourse.session7;

import java.util.HashSet;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i <= 100; i++) {
            numbers.add(i);
        }
        int sum=0;
        for (Integer i : numbers) {
            sum += i;
        }
        System.out.println(sum);
    }
}
