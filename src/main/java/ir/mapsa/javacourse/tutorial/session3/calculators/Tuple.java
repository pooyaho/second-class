package ir.mapsa.javacourse.tutorial.session3.calculators;

public class Tuple {
    private Integer left;
    private Integer right;

    public Tuple() {
    }

    public Tuple(Integer left, Integer right) {
        this.right = right;
        this.left = left;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public String toString(){
        return "("+left+","+right +")";
    }
}
