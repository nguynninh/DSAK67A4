package homework3.exercise7;

//{ Driver Code Starts

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int a) {
        data = a;
        next = null;
    }

}

// } Driver Code Ends
/*Complete the function below*/
/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

public class Solution {
    //Function to count nodes of a linked listInfix.
    public static int getCount(Node head) {
        int size = 0;
        Node node = head;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
        //Code here
    }
}


//{ Driver Code Starts.
class LinkedList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for (int i = 0; i < n - 1; i++) {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            Solution ob = new Solution();
            System.out.println(ob.getCount(head));
        }
    }


}


// } Driver Code Ends