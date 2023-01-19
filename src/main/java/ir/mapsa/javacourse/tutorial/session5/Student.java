package ir.mapsa.javacourse.tutorial.session5;

public class Student extends Person<Long> {
    private Integer passedCourse;

    public Student(String name, String family, String nationalId, Long id, Integer age, Integer passedCourse) {
        super(name, family, nationalId, id, age);
        this.passedCourse = passedCourse;
    }

    public Student() {
        this(null, null, null, null, null, null);
    }

    @Override
    public Long getId() {
        return 10*super.getId();
    }

    @Override
    public void print() {
        String s="In class Student "+
                this.getPassedCourse();
        System.out.println(s);
    }

    public Integer getPassedCourse() {
        return passedCourse;
    }

    public void setPassedCourse(Integer passedCourse) {
        this.passedCourse = passedCourse;
    }
}




