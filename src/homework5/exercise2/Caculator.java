package homework5.exercise2;

public class Caculator {
    private double number1;
    private double number2;
    private Operation operation;

    public Caculator(double number1, double number2, String operation) {
        this.number1 = number1;
        this.number2 = number2;

        switch (operation) {
            case "+" -> this.operation = new Addition();
            case "-" -> this.operation = new Subtract();
            case "*" -> this.operation = new Multiplication();
            case "/" -> this.operation = new Divition();
            default -> throw new ArithmeticException();
        }
    }

    public double caculator() {
        return operation.perform(number1, number2);
    }
}
