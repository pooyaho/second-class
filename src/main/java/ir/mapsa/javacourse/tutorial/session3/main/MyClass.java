package ir.mapsa.javacourse.tutorial.session3.main;

import ir.mapsa.javacourse.tutorial.session3.calculators.Calculator;
import ir.mapsa.javacourse.tutorial.session3.calculators.Tuple;

public class MyClass {
    public static void main(String[] args) {
//        System.out.println(CalculatorUtil.add(1, 2));
//        Calculator calc1 = Calculator.create(1, 2);
//        int a = 1;
////        String s = "Hello world!";
//        String s = "1,2,ali,hasani,1980/01/12";
//
//        System.out.println(Arrays.toString(s.split(",")));
//        Calculator calculator = new Calculator(10,12);
////        Integer a = 12;
////
////        Float b=12.3f;
////
////        Double c=12.3;
////        Boolean d=true;
////        Character e='A';
////        Short f=12;
////        Long g= 128768768767895685L;
////        Byte h=-120;
////        System.out.println(a);
//        System.out.println(calculator.add());
//        System.out.println(calculator.minus());
//        System.out.println(calculator.multiply());
//        System.out.println(calculator.divide());
//        System.out.println(calculator.remaining());
//        System.out.println(calculator.power());
//        Integer[] integers = new Integer[]{1, 2, 1000, 8888, 777};
//        for (int i = 0; i < integers.length; i++) {
//            int k = 0;
//            if (integers[i]%2==1) {
//                System.out.println(integers[i]);
//                break;
//            }
//
//        }

//
//        Integer[] empty = new Integer[]{};
//        ExtendedCalculator calculator = new ExtendedCalculator(integers);
//        System.out.println(calculator.sum());
//        System.out.println(calculator.max());

        Calculator calculator = new Calculator();
        Tuple tuple = new Tuple(1,2);
        System.out.println(tuple.toString());

    }
}

