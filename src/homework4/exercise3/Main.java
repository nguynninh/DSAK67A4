package homework4.exercise3;

import homework4.exercise3.entity.BracketValidator;

public class Main {
    public static void main(String[] args) {
        BracketValidator bracket = new BracketValidator();

        bracket.addBracket('(', ')')
                .addBracket('[', ']')
                .addBracket('{', '}');

        System.out.println("Valid expression in terms of parentheses: ");

        String math1 = "(a − b) ∗ (c + d)";
        System.out.println(math1 + " => " + bracket.isValid(math1));

        String math2 = "(10 + 8)/((5 − 2) ∗ 17)";
        System.out.println(math2 + " => " + bracket.isValid(math2));

        System.out.println();

        System.out.println("Invalid expression within parentheses: ");
        String math3 = "(a + b) ∗ c − d)";
        System.out.println(math3 + " => " + bracket.isValid(math3));

        String math4 = "(10 − 8/((2 + 5) ∗ 17)";
        System.out.println(math4 + " => " + bracket.isValid(math4));

        String math5 = ")u − v) ∗ (m + n)";
        System.out.println(math5 + " => " + bracket.isValid(math5));

        System.out.println("\n");

//        System.out.println(bracket.caculator("(a)"));
    }
}
