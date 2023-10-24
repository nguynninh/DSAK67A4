package homework4.practice1.ex17;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < number; i++) {
            queue.offer(in.nextInt());
        }

        int index = in.nextInt() % number;
        for (int i = 0; i < index; i++) {
            queue.add(queue.poll());
        }

        for (int element : queue) {
            System.out.print(element + " ");
        }
    }
}
