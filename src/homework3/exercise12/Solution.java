package homework3.exercise12;

import homework3.exercise3.Node;

/**
 * Definition for singly-linked listInfix.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null) {
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }

        return head;
    }
}


class Main {
    public static void main(String[] args) {
        ListNode listNode =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(2,
                                        new ListNode(4,
                                                new ListNode(1,
                                                        null)))));
        System.out.println("Before: " + printList(listNode));
        System.out.println("After: " + printList(new Solution().deleteDuplicates(listNode)));
    }

    private static String printList(ListNode listNode) {
        StringBuilder str = new StringBuilder("[");
        ListNode pt = listNode;
        while (pt != null) {
            str.append(pt.val).append(" ");
            pt = pt.next;
        }
        return str.append("]").toString();
    }
}
