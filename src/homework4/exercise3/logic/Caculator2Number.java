package homework4.exercise3.logic;

import homework4.exercise3.entity.*;

public class Caculator2Number {
    private double number1;
    private double number2;
    private Operation operation;

    public Caculator2Number() {
    }

    public Caculator2Number(double number1, double number2, Operation operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    public Caculator2Number(double number1, double number2, String operation) {
        this.number1 = number1;
        this.number2 = number2;
        setOperation(operation);
    }

    public double caculator() {
        return operation.perform(number1, number2);
    }

    public void setOperation(String operation) {
        switch (operation) {
            case "+" -> this.operation = new AdditionOperation();
            case "-", "+-" -> this.operation = new SubtractionOperation();
            case "*", "x" -> this.operation = new MultiplicationOperation();
            case "/", "÷" -> this.operation = new DivisionOperation();
            case "^", "**" -> this.operation = new SquareOperation();
            default -> throw new ArithmeticException("Error: Input the wrong calculation.");
        }
    }
}
