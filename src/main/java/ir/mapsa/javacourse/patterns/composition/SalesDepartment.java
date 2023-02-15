package ir.mapsa.javacourse.patterns.composition;

public class SalesDepartment implements Department {
    @Override
    public void print() {
        System.out.println("Sales");
    }
}
