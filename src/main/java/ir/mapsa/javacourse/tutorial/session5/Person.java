package ir.mapsa.javacourse.tutorial.session5;

import java.io.Serializable;


public abstract class Person<T> implements Serializable {
    private static final long serialVersionUID = -8615089633896207189L;
    protected String name;
    private String family;
    private String nationalId;
    private T id;
    private Integer age;

    public Person(String name, String family, String nationalId, T id, Integer age) {
        this.name = name;
        this.family = family;
        this.nationalId = nationalId;
        this.id = id;
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

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public abstract void print();
}
