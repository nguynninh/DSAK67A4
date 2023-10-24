package homework3.exercise5.exercise25;

import homework3.exercise2.ListInterface;
import homework3.exercise3.SimpleLinkedList;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListInterface list = new SimpleLinkedList();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (
                int i = 0;
                i < n; i++) {
            list.add(sc.nextInt());
        }

        Integer x = sc.nextInt();
        Integer k = sc.nextInt();
        ((SimpleLinkedList<Integer>) list).changeValue(x, k);

        printLinkedList(list);

    }

    private static void printLinkedList(ListInterface list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
