package ir.mapsa.javacourse.patterns.command;

import ir.mapsa.javacourse.tutorials.streams.ModelRepository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class CountrySalaryCommand implements Command<List<Double>, String> {
    private ModelRepository modelRepository ;

    public CountrySalaryCommand() throws IOException {
        modelRepository = new ModelRepository();
    }

    @Override
    public List<Double> execute(String s) {
        return modelRepository.getModels().values().stream()
                .filter(i -> i.getGeography().equals(s))
                .map(i -> i.getEstimatedSalary())
                .collect(Collectors.toList());
    }
}
