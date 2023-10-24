package homework4.practice1.ex14;

import homework4.exercise2.ArrayBasedStack;
import homework4.exercise2.StackInterface;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if (number < 0)
            return;

        StackInterface<Integer> stack = new ArrayBasedStack<>();
        if (number == 0)
            stack.push(0);
        else
            while (number > 0) {
                stack.push(number % 2);
                number /= 2;
            }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
