package homework4.exercise2;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');
        System.out.println("Stack size: " + stack.size());
        stack.forEach(i -> System.out.println(i+" "));
    }
}
