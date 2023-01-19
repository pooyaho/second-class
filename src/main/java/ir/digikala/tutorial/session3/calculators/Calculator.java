package ir.digikala.tutorial.session3.calculators;

public class Calculator {
    private Integer a;
    private Integer b;

//    public ir.digikala.tutorial.session3.calculators.Calculator(Integer a, Integer b) {
//
//        this.a = a;
//        this.b = b;
//    }

    public static Calculator create(int a, int b) {
        Calculator calculator = new Calculator();
        calculator.a = a;
        calculator.b = b;
        return calculator;
    }

    public Integer add() {
        return a + b;
    }

    public Integer minus() {
        return a - b;
    }

    public Integer multiply() {
        return a * b;
    }

    public Float divide() {
        return (float) a / b;
    }

    public Integer remaining() {
        return a % b;
    }

    public Long power() {
        return (long)Math.pow(a, b);
    }

    @Override
    public String toString() {
        return "To string called";
    }

}
