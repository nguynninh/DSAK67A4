package homework5.exercise2;

import homework5.exercise1.b.LinkedBinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ArithmeticExpression<E extends Comparable<E>> extends LinkedBinaryTree {
    private List<String> input;

    public ArithmeticExpression() {
        this.input = new ArrayList<>();
    }

    public void add(LinkedBinaryTree.Node<E> data) {
        if (data != null)
            setData((Object) data);
    }

    public void preorderPrint() {
        preorderPrint(root);
    }

    public void postorderPrint() {
        postorderPrint(root);
    }

    public void inorderPrint() {
        inorderPrint(root);
    }

    public void preorderPrint(Node<E> p) {
        // pre - order traversal of tree with root p
        if (p == null)
            return;

        System.out.print(p.getData() + " ");

        preorderPrint(p.getLeft());

        preorderPrint(p.getRight());
    }


    public void postorderPrint(Node<E> p) {
        // post - order traversal of tree with root p
        if (p == null)
            return;

        postorderPrint(p.getLeft());

        postorderPrint(p.getRight());

        input.add(p.getData() + "");
        System.out.print(p.getData() + " ");
    }


    public void inorderPrint(Node<E> p) {
        //in - order traversal of tree with root p
        if (p == null)
            return;

        inorderPrint(p.getLeft());

        System.out.print(p.getData() + " ");

        inorderPrint(p.getRight());
    }

    private boolean isOperator(String x) {
        return Arrays.asList(new String[]{"+", "-", "x", "*", "÷", "/", "%", "^"}).contains(x);
    }

    // X <op> Y = Z
    private Double calculateValue(double x, String oper, double y) {
        return new Caculator(
                y,
                x,
                oper
        ).caculator();
    }

    private void convert(Node<E> p) {
        if (p == null)
            return;
        convert(p.getLeft());
        convert(p.getRight());
        input.add(p.getData() + "");
    }

    public double caculator() {
        Stack<Double> stack = new Stack<>();
        convert(root);

        if (input.size() == 1)
            stack.push(Double.parseDouble(input.get(0)));
        else
            for (String value : input) {
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

        return stack.pop();
    }
}
