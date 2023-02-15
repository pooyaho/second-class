package ir.mapsa.javacourse.patterns.proxy;

public class PrinterClass implements Print {
    @Override
    public void print() {
        System.out.println("Something");
    }
}
