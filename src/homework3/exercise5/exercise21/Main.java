package homework3.exercise5.exercise21;

import homework3.exercise2.ListInterface;
import homework3.exercise3.Node;
import homework3.exercise3.SimpleLinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ListInterface<Integer> list = new SimpleLinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(input.nextInt());
        }

        list.forEach(index -> System.out.print(index + " "));

    }
}
