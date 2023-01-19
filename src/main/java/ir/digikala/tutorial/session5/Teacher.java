package ir.digikala.tutorial.session5;

public class Teacher extends Person{
    private Integer teachCourses;

    public Teacher(String name, String family, String nationalId, String id, Integer age,Integer teachCourses) {
        super(name, family, nationalId, id, age);
        this.teachCourses = teachCourses;
    }

    public Integer getTeachCourses() {
        return teachCourses;
    }

    public void setTeachCourses(Integer teachCourses) {
        this.teachCourses = teachCourses;
    }

    @Override
    public void print() {
        String s = "In teacher " + this.getTeachCourses();
        System.out.println(s);
    }
}
