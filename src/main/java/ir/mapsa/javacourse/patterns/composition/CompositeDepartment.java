package ir.mapsa.javacourse.patterns.composition;

public class CompositeDepartment {
    private final Department department;

    public CompositeDepartment(Department department) {
        this.department = department;
    }


    public void print() {
        System.out.println("Before ");
        department.print();

    }
}
