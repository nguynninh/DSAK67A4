//package homework3.exercise5.exercise26;
//
//import homework3.exercise2.ListInterface;
//import homework3.exercise3.SimpleLinkedList;
//
//import java.util.Iterator;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        ListInterface listInfix = new SimpleLinkedList();
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        for (
//                int i = 0;
//                i < n; i++) {
//            listInfix.add(sc.nextInt());
//        }
//
//        Integer x = sc.nextInt();
//        ((SimpleLinkedList<Integer>) listInfix).removeTransmittedValue(x);
//
//        printLinkedList(listInfix);
//
//    }
//
//    private static void printLinkedList(ListInterface listInfix) {
//        Iterator iterator = listInfix.iterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next() + " ");
//        }
//    }
//}
//
