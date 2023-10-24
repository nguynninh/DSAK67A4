package homework4.exercise3.entity;

import homework4.exercise2.ArrayBasedStack;
import homework4.exercise2.StackInterface;
import homework4.exercise3.logic.Caculator2Number;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BracketValidator {
    private StackInterface<Character> stack;
    private Map<Character, Character> check;

    public BracketValidator() {
        this.stack = new ArrayBasedStack<>();
        check = new HashMap<>();
    }

    public StackInterface<Character> getStack() {
        return stack;
    }

    public Map<Character, Character> getCheck() {
        return check;
    }

    public BracketValidator addBracket(char openBracket, char closeBracket) {
        check.put(openBracket, closeBracket);
        return this;
    }

    public boolean isValid(String value) {
        StackInterface<Character> stack = new ArrayBasedStack<>();

        for (char ch : value.toCharArray())
            if (check.containsKey(ch))
                stack.push(ch);
            else if (check.containsValue(ch))
                if (stack.isEmpty() || check.get(stack.pop()) != ch)
                    return false;

        return stack.isEmpty();
    }

    public double input(double number1, double number2, String operator) {
        return new Caculator2Number(number1, number2, operator).caculator();
    }

//    public String inputTransformation(String textLine) {
//        List<String> listNumber = new ArrayList<>();
//        StringBuilder builder = new StringBuilder();
//
//        for (char a : textLine.toCharArray()) {
//            if ("0123456789.".contains(String.valueOf(a))) {
//                builder.append(a);
//            } else if ("+-x**÷/^()=".contains(String.valueOf(a))) {
//                listNumber.add(builder.toString());
//                listNumber.add(a + "");
//                builder = new StringBuilder();
//            }
//        }
//        System.out.println(listNumber);
//
//        String operator = "";
//        double result = Double.parseDouble(listNumber.get(0));
//        for (int i = 1; i < listNumber.size() - 1; i++) {
//            if ("+-**x÷/^".contains(listNumber.get(i))) {
//                switch (listNumber.get(i)) {
//                    case "+" -> operator = "+";
//                    case "-" -> operator = "-";
//                    case "*", "x" -> operator = "*";
//                    case "/", "÷" -> operator = "/";
//                    case "^", "**" -> operator = "^";
//                }
//            } else {
//                if (listNumber.get(i).contains("%"))
//                    listNumber.set(i,
//                            String.valueOf(input(
//                                    Double.parseDouble(listNumber.get(i).replace("%", "")),
//                                    100, "/")
//                            )
//                    );
//                result = input(result, Double.parseDouble(listNumber.get(i)), operator);
//            }
//        }
//
//        String resultStr = ((int) result == result) ? String.valueOf((int) result) : String.valueOf(result);
//
//        try {
//            FileWriter fileWriter = new FileWriter("src\\homework4\\exercise3\\database\\his.txt", true);
//
//            builder = new StringBuilder();
//            for (int i = 0; i < listNumber.size(); i++) {
//                builder.append(listNumber.get(i));
//            }
//            builder.append(resultStr);
//
//            fileWriter.write(builder + "\n");
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return resultStr;
//    }
}
