package homework4.exercise3.entity;

public class SquareOperation extends Operation {
    @Override
    public double perform(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}
