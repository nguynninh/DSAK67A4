package homework3.exercise11;

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
    public boolean isPalindrome(ListNode head) {
        ListNode node = head;
        ListNode right = null;
        int count = 0;
        while (node != null) {
            if (count == 0)
                right = new ListNode(node.val, null);
            else
                right = new ListNode(node.val, right);
            node = node.next;
            count++;
        }

        ListNode left = head;
        for (int i = 0; i < count / 2; i++) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        ListNode listNode =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(1,
                                                        null)))));
        System.out.println(new Solution().isPalindrome(listNode));

        listNode =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(2,
                                                new ListNode(1,
                                                        null)))));
        System.out.println(new Solution().isPalindrome(listNode));
    }
}
