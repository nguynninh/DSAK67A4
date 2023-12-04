package homework3.exercise2;

import homework3.exercise3.SimpleLinkedList;

import java.util.Vector;

public class MainTest {
    public static void main(String[] args) {
        ListInterface<String> simpleArrayList = new SimpleArrayList<>();
        testList(simpleArrayList);

        System.out.println();
        ListInterface<String> simpleLinkedList = new SimpleLinkedList<>();
        testList(simpleLinkedList);
    }

    private static void testList(ListInterface list) {
        ListInterface<String> myList = list;

        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");

        System.out.print("Danh sách ban đầu: ");
        printList(myList);

        System.out.println("Kích thước danh sách: " + myList.size());

        System.out.println("Danh sách rỗng? " + myList.isEmpty());

        System.out.println("Có phần tử 'B' trong danh sách? " + myList.isContain("B"));
        System.out.println("Có phần tử 'E' trong danh sách? " + myList.isContain("E"));

        System.out.println("Phần tử tại vị trí 2: " + myList.get(2));

        myList.set(1, "X");
        System.out.print("Danh sách sau khi thay đổi:");
        printList(myList);

        myList.remove("C");
        System.out.print("Danh sách sau khi xóa:");
        printList(myList);

        myList.clear();
        System.out.print("Danh sách sau khi xóa toàn bộ:");
        printList(myList);
    }

    private static void printList(ListInterface<String> myList) {
        System.out.print("[");
        myList.forEach(index -> System.out.print(index + " "));
        System.out.println("]");
    }
}
