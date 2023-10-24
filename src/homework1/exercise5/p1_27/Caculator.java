package homework1.exercise5.p1_27;

public class Caculator {
    private double number1;
    private double number2;
    private Operation operation;

    public Caculator() {
    }

    public Caculator(double number1, double number2, Operation operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    public Caculator(double number1, double number2, String operation) {
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
            case "-" -> this.operation = new SubtractionOperation();
            case "*" -> this.operation = new MultiplicationOperation();
            case "/" -> this.operation = new DivisionOperation();
            default -> throw new ArithmeticException("Error: Input the wrong calculation.");
        }
    }

    public double inputTransformation(String textLine) {
        String[] tl = textLine.trim().split(" ");
        if (tl.length == 4 || tl.length == 3) {
            this.number1 = Double.parseDouble(tl[0].replace(",", "."));
            setOperation(tl[1]);
            this.number2 = Double.parseDouble(tl[2].replace(",", "."));
            return caculator();
        } else {
            throw new ArithmeticException("Error: You lack the facts to act.");
        }
    }
}
