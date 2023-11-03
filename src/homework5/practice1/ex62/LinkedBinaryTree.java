package homework5.practice1.ex62;

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

    public void print() {
        print(root);
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

    private void print(Node p) {
        if (p == null)
            return;

        print(p.left);

        System.out.print(p.data + " ");

        print(p.right);
    }
}
