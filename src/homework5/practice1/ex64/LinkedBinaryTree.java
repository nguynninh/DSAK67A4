package homework5.practice1.ex64;

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

    public int treeDegree() {
        return treeDegree(root);
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

    private int treeDegree(Node node) {
        if (node == null) {
            return 0;
        }

        int leftDegree = treeDegree(node.left);
        int rightDegree = treeDegree(node.right);

        int maxDegree = Math.max(leftDegree, rightDegree);

        if (node.left != null || node.right != null) {
            return maxDegree + 1;
        }

        return 0;
    }
}
