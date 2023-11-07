package homework5.practice1.ex63;

import java.util.ArrayList;
import java.util.List;

public class LinkedBinaryTree {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int size;

    public void add(int data) {
        root = add(root, data);
        size++;
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    // PRIVATE
    private Node add(Node node, int data) {
        if (node == null)
            node = new Node(data, null, null);
        else {
            if (data >= node.data) node.right = add(node.right, data);
            else node.left = add(node.left, data);
        }
        return node;
    }

    private int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int leftLeaves = countLeaves(node.left);
        int rightLeaves = countLeaves(node.right);
        return leftLeaves + rightLeaves;
    }
}
