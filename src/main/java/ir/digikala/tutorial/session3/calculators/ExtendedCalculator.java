package ir.digikala.tutorial.session3.calculators;

public class ExtendedCalculator {
    private Integer[] ints;

    public ExtendedCalculator(Integer[] ints) {
        this.ints = ints;
    }

    public Long sum() {
        long sum = 0;
        if (ints.length == 0) {
            return null;
        }
        for (int i = 0; i < ints.length; i++) {
            sum+=ints[i];
        }
        return sum;
    }

    public Integer max() {
        int highest=Integer.MIN_VALUE;
        if (ints.length == 0) {
            return null;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > highest) {
                highest = ints[i];
            }
        }
        return highest;
    }


}
