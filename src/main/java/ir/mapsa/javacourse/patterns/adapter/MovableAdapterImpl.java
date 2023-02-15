package ir.mapsa.javacourse.patterns.adapter;

public class MovableAdapterImpl implements MovableAdapter {
    private Movable luxuryCars;
    
    public MovableAdapterImpl(Movable luxuryCars) {
        this.luxuryCars = luxuryCars;
    }

    @Override
    public double convertSpeed() {
        double mph = luxuryCars.getSpeed();
        return convertMPHtoKMPH(mph);
    }
    
    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}
