package homework1.exercise5.p1_27;

public class DivisionOperation extends Operation {
    @Override
    public double perform(double number1, double number2) {
        if (number2 != 0) {
            return number1 / number2;
        } else {
            throw new ArithmeticException("Error: Division by zero.");
        }
    }
}
