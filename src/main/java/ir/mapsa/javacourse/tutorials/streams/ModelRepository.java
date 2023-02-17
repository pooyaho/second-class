package ir.mapsa.javacourse.tutorials.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ModelRepository {

    private static final String SPAIN = "Spain";
    private Map<String, Model> models;
    private List<Model> emptyModel;

    public ModelRepository() throws IOException {
        Map<Boolean, List<Model>> collect = Files.lines(Paths.get("/Users/pooya/IdeaProjects/maven-sample/src/main/resources/churn.csv"))
                .skip(1)
                .map(line -> {
                    try {
                        String[] split = line.split(",", -1);
                        return new Model(split[0], split[1], split[2], split[3], split[4], split[5], split[6], split[7], split[8], split[9], split[10], split[11], split[12], split[13], split[14], split[15]);
                    } catch (Exception e) {
                        System.out.println(line);
                        throw new RuntimeException(e);
                        // Song for Eli - Andrea Bauer
                    }
                })
                .collect(Collectors.partitioningBy(i -> !i.getCustomerId().isEmpty() && !i.getSurname().isEmpty()));
        this.models = collect.get(true).stream()
                .collect(Collectors.toMap(i -> i.getCustomerId(), i -> i));
        this.emptyModel = collect.get(false);
    }

    public void add(Model model) {
        this.models.put(model.getCustomerId(), model);
    }

    public void update(Model model) {
        this.add(model);
    }

    public void remove(String customerId) {
        this.models.remove(customerId);
    }

    public Model maxCreditScore() {
        return this.models.values().stream()
                .max(Comparator.comparingInt(i -> Integer.parseInt(i.getCreditScore())))
                .get();
    }

    public Model maxCreditScoreWhoExited() {
        return this.models.values().stream()
                .filter(i -> i.getExited().equals("1"))
                .max(Comparator.comparingInt(i -> Integer.parseInt(i.getCreditScore())))
                .get();
    }

    public List<Model> menFromFranceAndSalaryLessThan60000() {
        return this.models.values().stream()
                .filter(i -> i.getGender().equals("Male") && i.getGeography().equals("France") && i.getEstimatedSalary() < 60000)
                .collect(Collectors.toList());

    }

    public List<Model> sortByCreditScore() {
        return this.models.values()
                .stream()
                .sorted(Comparator.comparing(i -> Integer.parseInt(i.getCreditScore())))
                .collect(Collectors.toList());

    }

    public List<Model> tenLeastSalaries() {
        return this.models.values()
                .stream()
                .sorted(Comparator.comparingDouble(Model::getEstimatedSalary)).limit(10)
                .collect(Collectors.toList());

    }

    public double avgOfSpain() {
        return models.values().stream()
                .filter(i -> i.getGeography().equals(SPAIN))
                .collect(Collectors.averagingDouble(i -> i.getEstimatedSalary()));
    }

    public List<Double> spainSalaries() {
        return models.values().stream()
                .filter(i -> i.getGeography().equals(SPAIN))
                .map(i -> i.getEstimatedSalary())
                .collect(Collectors.toList());
    }



    public Set<String> distinctCountryNames() {
        return models.values().stream()
                .map(i -> i.getGeography())
                .collect(Collectors.toSet());
    }


    public Map<String, Model> getModels() {
        return models;
    }
}
