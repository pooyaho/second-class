package ir.digikala.tutorial.session3.calculators;

public class CalculatorUtil {
    public final static float PI_NUMBER = 3.14f;

    public static Integer add(int a,int b) {
        return a + b;
    }

    public static Integer minus(int a,int b) {
        return a - b;
    }

    public static Integer multiply(int a,int b) {
        return a * b;
    }

    public static Float divide(int a,int b) {
        return (float) a / b;
    }

    public static Integer remaining(int a,int b) {
        return a % b;
    }

    public static Long power(int a,int b) {
        return (long)Math.pow(a, b);
    }

}
