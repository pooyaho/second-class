package ir.mapsa.javacourse.etc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public interface Repository<T> {
    void save(T a) throws Exception;

    List<T> retrieveAll(Class<T> typeClass) throws Exception;
}

class FileRepository<T> implements Repository<T> {

    @Override
    public void save(T a) throws Exception {
        File file = new File(a.getClass().getSimpleName());
        try (FileWriter fileWriter = new FileWriter(file,true); BufferedWriter bf = new BufferedWriter(fileWriter)) {
            String line = Arrays.stream(a.getClass().getDeclaredFields())
                    .map(f -> {
                        try {
                            f.setAccessible(true);
                            Object o = f.get(a);
                            return String.valueOf(o);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }).collect(Collectors.joining(","));
            bf.append(line+"\n");
        }

    }

    @Override
    public List<T> retrieveAll(Class<T> typeClass) throws Exception{
        AtomicInteger atomicInteger = new AtomicInteger(0);
        return Files.lines(Paths.get(typeClass.getSimpleName()))
                .map(line -> {
                    atomicInteger.incrementAndGet();
                    String[] split = line.split(",");
                    Field[] declaredFields = typeClass.getDeclaredFields();
                    try {
                        T t = typeClass.newInstance();
                        for (int i = 0; i < split.length; i++) {
                            Field df = declaredFields[i];
                            df.setAccessible(true);
                            if (df.getType() == Integer.class) {
                                df.set(t,Integer.valueOf( split[i]));
                            } else if (df.getType() == Boolean.class) {
                                df.set(t, Boolean.valueOf( split[i]));
                            }else{
                                df.set(t, split[i]);
                            }
                        }
                        return t;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());
    }
}

class Test {
    public static void main(String[] args) throws Exception {
//        FileRepository<Student> fileRepository = new FileRepository<Student>();
//        fileRepository.save(new Student());
//        List<Student> students = fileRepository.retrieveAll(Student.class);

        Repository<MyClass> fileRepository = new FileRepository<>();
//        MyClass a = new MyClass();
//        a.setName("Ali");
//        a.setFamily("Alavi");
//        a.setAge(80);
//        a.setAlive(false);
//        fileRepository.save(a);
        List<MyClass> myClasses = fileRepository.retrieveAll(MyClass.class);
        System.out.println(myClasses);
    }
}
class MyClass{
    private String name;
    private String family;
    private Integer age;
    private Boolean alive;

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}