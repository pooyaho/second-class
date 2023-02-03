package ir.mapsa.javacourse.tutorial.session5;

import java.io.Serializable;
import java.util.Date;

public class Student extends Person<Long> implements Serializable {

    private static final long serialVersionUID = 1655405904508623923L;
    private Integer passedCourse;
    private String fatherName;
    private Date entranceDate;
    public Student(String name, String family, String nationalId, Long id, Integer age, Integer passedCourse,Date entranceDate) {
        super(name, family, nationalId, id, age);
        this.passedCourse = passedCourse;
        this.entranceDate = entranceDate;
    }

    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

    public Student() {
        this(null, null, null, null, null, null,null);
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

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
}




