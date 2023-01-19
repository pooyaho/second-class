package ir.digikala.tutorial.session5.main;

public class Main {
    public static void main(String[] args) {
//        Person student = new Student("Ali","Alavi","123456","123",19,10);
//        student.print();
//        Person teacher = new Teacher("Mahdi", "Mahdavi", "12345689", "456", 39, 100);
//        teacher.print();
//        Teacher teacher = new Teacher();
    }
}
abstract class Shapes {
    public abstract void area();
}

class Triangle extends Shapes {
    public void area() {
        System.out.println("Triangle is ½ * base * height ");
    }
}

class Circle extends Shapes {
    public void area() {
        System.out.println("Circle is 3.14 * radius * radius ");
    }
}