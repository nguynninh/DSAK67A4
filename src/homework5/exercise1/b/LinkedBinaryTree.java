package homework5.exercise1.b;

import homework5.exercise1.BinaryTreeInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedBinaryTree<E extends Comparable<E>, T> implements BinaryTreeInterface<T> {

    public static class Node<E extends Comparable<E>> {
        private E data; // an data stored at this node
        private Node<E> parent; // a reference to the parent node (if any)
        private Node<E> left; // a reference to the left child
        private Node<E> right; // a reference to the right child

        // Constructs a node with the given data and neighbors .
        public Node(E data, Node<E> parent, Node<E> left, Node<E> right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public Node(E data) {
            this.data = data;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setData(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

    }

    protected Node<E> root;
    protected int size;

    @Override
    public T root() {
        return (T) root;
    }

    public void addRoot(E value) {
        root = new Node<>(value, null, null, null);
    }

    @Override
    public void setData(Object data) {
        this.root = (Node<E>) data;
    }

    public void insertValue(E value) {
        root = insertRec(root, value);
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
        return numChild(((Node<E>) p));
    }

    // Return parent of p
    @Override
    public T parent(T p) {
        return (T) ((Node<E>) p).parent;
    }

    // Return left child of p
    @Override
    public T left(T p) {
        return (T) ((Node<E>) p).left;
    }

    // Return right child of p
    @Override
    public T right(T p) {
        return (T) ((Node<E>) p).right;
    }

    // Return sibling of p
    @Override
    public T sibling(T p) {
        return (T) ((((Node<E>) p).parent.left == (Node<E>) p)
                ? ((Node<E>) p).parent.left
                : ((Node<E>) p).parent.right);
    }

    public boolean searchValue(E value){
        return searchRec(root, value);
    }

    @Override
    public boolean addDataToFile() {
        try {
            final String file = "src/homework5/exercise1/b/linked_binary_tree.txt";
            FileWriter fw = new FileWriter(file);
            fw.write(toString());
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
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

    private Node<E> insertRec(Node<E> root, E value) {
        if (root == null) {
            return new Node<>(value);
        }

        Random random = new Random();
        if (random.nextBoolean()) {
            root.setLeft(insertRec(root.getLeft(), value));
        } else {
            root.setRight(insertRec(root.getRight(), value));
        }

        return root;
    }

    private boolean searchRec(Node<E> root, E value) {
        if (root == null)
            return false;

        if (value.equals(root.getData()))
            return true;

        return searchRec(root.getLeft(), value) || searchRec(root.getRight(), value);
    }
}