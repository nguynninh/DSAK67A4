package homework7.exercise3;

import homework5.exercise1.BinaryTreeInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BalancedBinarySearchTree<E extends Comparable<E>, T> implements BinaryTreeInterface<T> {

    class Node<E> {
        E data;
        Node<E> parent, left, right;
        int height;

        public Node(E data) {
            this.data = data;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    @Override
    public T root() {
        return (T) root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int numChildren(T p) {
        return numChild((Node<E>) p);
    }

    @Override
    public T parent(T p) {
        return (T) ((Node<T>) p).parent;
    }

    @Override
    public T left(T p) {
        return (T) ((Node<E>) p).left;
    }

    @Override
    public T right(T p) {
        return (T) ((Node<E>) p).right;
    }

    @Override
    public T sibling(T p) {
        return (T) ((((Node<E>) p).parent.left == (Node<E>) p)
                ? ((Node<E>) p).parent.left
                : ((Node<E>) p).parent.right);
    }

    @Override
    public void setData(Object data) {
        this.root = (Node<E>) data;
    }

    @Override
    public boolean addDataToFile() {
        try {
            final String file = "src/homework7/exercise3/linked_binary_tree.txt";
            FileWriter fw = new FileWriter(file);
            fw.write(toString());
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public void insert(E data) {
        root = insert(root, data);
    }

    private Node<E> insert(Node<E> node, E data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.data) < 0)
            node.left = insert(node.left, data);
        else if (data.compareTo(node.data) > 0)
            node.right = insert(node.right, data);
        else return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && data.compareTo(node.left.data) < 0)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && data.compareTo(node.right.data) > 0)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && data.compareTo(node.left.data) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && data.compareTo(node.right.data) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        printTree(root, false, new ArrayList<>(), builder);
        return builder.toString();
    }


    //PRIVATE
    private int numChild(Node<E> p) {
        int count = 0;

        if (p == null)
            return count;

        if (p.left != null) numChild(p.left);
        if (p.right != null) numChild(p.right);

        return ++count;
    }

    private void printTree(Node root, boolean isLeft, List<String> list, StringBuilder builder) {
        if (root == null) return;

        list.add("\t");

        printTree(root.right, true, list, builder);

        for (int i = 0; i < list.size() - 1; i++)
            builder.append(list.get(i));
        builder.append(root.data).append("\n");

        printTree(root.left, false, list, builder);

        list.remove(list.size() - 1);
    }

    private int height(Node node) {
        return (node != null) ? node.height : 0;
    }

    private int getBalance(Node<E> node) {
        return (node != null) ? height(node.left) - height(node.right) : 0;
    }

    private Node<E> rightRotate(Node<E> y) {
        Node<E> x = y.left;
        Node<E> t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node<E> leftRotate(Node<E> x) {
        Node<E> y = x.right;
        Node<E> t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }
}
