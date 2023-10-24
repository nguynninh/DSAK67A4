package homework4.exercise2;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        StackInterface<Character> arrayBasedStack = new ArrayBasedStack<>();
        testStackInterface(arrayBasedStack);
        System.out.println();

        StackInterface<Character> linkedListStack = new LinkedListStack<>();
        testStackInterface(linkedListStack);
    }

    private static void testStackInterface(StackInterface<Character> stack) {
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');
        System.out.println("Stack size: " + stack.size());
        System.out.println("The elements after add: " + printStack(stack));

        stack.pop();
        stack.pop();
        System.out.println("Stack size: " + stack.size());
        System.out.println("The elements after pop twice: " + printStack(stack));

        System.out.println("See the last element is: " + stack.top());
    }

    private static String printStack(StackInterface<Character> stack) {
        StringBuilder s = new StringBuilder("[");

        Iterator<Character> iterator = stack.iterator();
        while (iterator.hasNext()) {
            s.append(iterator.next()).append(" ");
        }

        return ((s.length() > 1) ? s.substring(0, s.length() - 1) : s) + "]";
    }
}
