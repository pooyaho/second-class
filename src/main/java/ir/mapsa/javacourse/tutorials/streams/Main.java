package ir.mapsa.javacourse.tutorials.streams;

import java.io.IOException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        ModelRepository modelRepository=new ModelRepository();

        System.out.println(modelRepository.tenLeastSalaries().stream()
                .map(i->i.getEstimatedSalary()).collect(Collectors.toList()));
        System.out.println(modelRepository.spainSalaries().stream()
                .count());
        System.out.println(modelRepository.spainSalaries().stream()
                .reduce((i,j)->i+j));
        System.out.println(modelRepository.avgOfSpain());
        System.out.println(modelRepository.distinctCountryNames());
    }
}
