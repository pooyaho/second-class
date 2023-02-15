package ir.mapsa.javacourse.patterns.proxy;

public class PrintProxy implements Print {
    private final PrinterClass printerClass;

    public PrintProxy(PrinterClass printerClass) {
        this.printerClass =printerClass;
    }


    @Override
    public void print() {
        System.out.println("Before call");
        printerClass.print();
        System.out.println("After");
    }
}

class Main {
    public static void main(String[] args) {
        PrintProxy proxy = new PrintProxy(new PrinterClass());
        proxy.print();
    }
}