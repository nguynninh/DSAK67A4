package homework4.exercise3.logic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Caculator {
    public List<String> listInfix;
    public List<String> listPostfix;

    public Caculator() {
        this.listInfix = new ArrayList<>();
        this.listPostfix = new ArrayList<>();
    }

    public List<String> input(String text) {
        StringBuilder builder = new StringBuilder();

        for (char a : text.toCharArray()) {
            if (!builder.isEmpty() && isOperator(a + "") ||
                    !builder.isEmpty() && "()=".contains(a + "")) {
                listInfix.add(builder.toString());
                builder = new StringBuilder();
            }

            if ("0123456789.".contains(a + ""))
                builder.append(a);
            else
                listInfix.add(a + "");
        }

        listInfix.removeLast();
        return listInfix;
    }

    private int getPriority(String x) {
        if ("sqrt^".contains(x))
            return 3;

        if ("*x÷/%".contains(x))
            return 2;

        if ("+-".contains(x))
            return 1;

        if ("(".contains(x))
            return 0;

        return -1;
    }

    boolean isOperator(String x) {
        return Arrays.asList(new String[]{"+", "-", "x", "*", "÷", "/", "%", "^"}).contains(x);
    }

    public double calculateValue(double y, String operation, double x) {
        return new Caculator2Number(x, y, operation).caculator();
    }

    public double calculateValue() {
        Stack<Double> stack = new Stack<>();

        if (listInfix.size() == 1)
            stack.push(Double.parseDouble(listInfix.get(0)));
        else
            for (String value : listPostfix) {
                if (isOperator(value)) {
                    if ("%".contains(value))
                        stack.push(calculateValue(
                                100,
                                "/",
                                stack.pop()
                        ));
                    else stack.push(
                            calculateValue(
                                    stack.pop(),
                                    value,
                                    stack.pop()
                            )
                    );
                } else
                    stack.push(Double.parseDouble(value));
            }

        //Save Data - ON / OFF
        listInfix.add("=");
        listInfix.add(String.valueOf(stack.peek()));
        System.out.println(listInfix);
        saveFile(false);

        return stack.pop();
    }

    public List<String> infixToPostfix() {
        Stack<String> stack = new Stack<>();

        for (String x : listInfix) {
            if ("(".contains(x))
                stack.push(x);
            else if (")".contains(x)) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    listPostfix.add(stack.pop());
                }
                stack.pop();
            } else if (isOperator(x)) {
                if (stack.isEmpty() || stack.peek().equals("("))
                    stack.push(x);
                else if (getPriority(x) <= getPriority(stack.peek())) {
                    listPostfix.add(stack.pop());
                    stack.push(x);
                } else
                    stack.push(x);
            } else
                listPostfix.add(x);
        }

        while (!stack.isEmpty()) {
            listPostfix.add(stack.pop());
        }

        return listPostfix;
    }

    public boolean saveFile(boolean isSave) {
        if (isSave) {
            try {
                FileWriter fileWriter = new FileWriter("src\\homework4\\exercise3\\database\\his.txt", true);

                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < listInfix.size(); i++) {
                    builder.append(listInfix.get(i));
                }

                fileWriter.write(builder + "\n");
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else return false;
    }
}