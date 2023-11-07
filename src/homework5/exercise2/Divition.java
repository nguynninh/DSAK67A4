package homework5.exercise2;

public class Divition extends Operation {
    @Override
    public double perform(double number1, double number2) {
        if (number2 != 0)
            return number1 / number2;

        throw new ArithmeticException("/ by zero");
    }
}
