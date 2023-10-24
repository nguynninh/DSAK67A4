package homework4.practice4;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char a : s.toCharArray()) {
            if (a == '(' || a == '{' || a == '[')
                stack.push(a);

            if (a == ')' || a == ']' || a == '}') {
                if (stack.isEmpty())
                    return false;
                switch (a) {
                    case ')' -> {
                        char pop = stack.pop();
                        if (pop == '{' || pop == '[')
                            return false;
                    }
                    case ']' -> {
                        char pop = stack.pop();
                        if (pop == '(' || pop == '{')
                            return false;
                    }
                    case '}' -> {
                        char pop = stack.pop();
                        if (pop == '(' || pop == '[')
                            return false;
                    }

                }
            }
        }
        return stack.isEmpty();
    }
}
