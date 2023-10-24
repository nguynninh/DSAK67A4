package homework4.exercise5;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public boolean isPalindrome(String input) {
        Queue<Character> queue = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();

        for (char i : input.toCharArray()) {
            queue.add(i);
            stack.push(i);
        }

        for (int i = 0; i < input.length() / 2; i++) {
            if (queue.remove() != stack.pop())
                return false;
        }

        return true;
    }
}
