package homework3.exercise10;
// Java program for reversing the linked listInfix

public class LinkedList {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /* Function to reverse the linked listInfix */
    Node reverse(Node node) {
        Node current = node;
        Node reverse = null;
        while (current != null) {
            if (reverse == null)
                reverse = new Node(current.data, null);
            else {
                Node nodeNew = reverse;
                reverse = new Node(current.data, nodeNew);
            }
            current = current.next;
        }
        return reverse;
    }

    // prints content of double linked listInfix
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    // Driver Code
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Given linked listInfix");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked listInfix ");
        list.printList(head);
    }
}

// This code has been contributed by Mayank Jaiswal

