package homework4.practice1.ex13;

import homework4.exercise2.ArrayBasedStack;
import homework4.exercise2.StackInterface;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StackInterface<Character> stack = new ArrayBasedStack<>();
        for (char i: str.toCharArray()) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
