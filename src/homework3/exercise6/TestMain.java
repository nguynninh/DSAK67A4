package homework3.exercise6;

import homework3.exercise6.MyLinkedList;

public class TestMain {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        // Test addAtHead
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(3);
        printList(myLinkedList);

        // Test addAtTail
        myLinkedList.addAtTail(4);
        myLinkedList.addAtTail(5);
        myLinkedList.addAtTail(6);
        printList(myLinkedList);

        // Test addAtIndex
        myLinkedList.addAtIndex(2, 7);
        myLinkedList.addAtIndex(5, 8);
        printList(myLinkedList);

        // Test deleteAtIndex
        myLinkedList.deleteAtIndex(2);
        myLinkedList.deleteAtIndex(4);
        printList(myLinkedList);
    }

    private static void printList(MyLinkedList myLinkedList) {
        int size = myLinkedList.size();
        for (int i = 0; i < size; i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
        System.out.println();
    }
}

