package homework7.exercise1;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinarySearchTreeUsingLinkedNode<T extends Comparable<T>> implements TreeADT<T> {
    private int noteCount;
    private Node root;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return noteCount;
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public boolean contains(T element) {
        return contains(root, element);
    }

    @Override
    public boolean add(T element) {
        if (contains(element)) return false;
        root = add(root, element);
        noteCount++;
        return true;
    }

    @Override
    public boolean remove(T element) {
        if (!contains(element)) return false;
        root = remove(root, element);
        noteCount--;
        return true;
    }

    @Override
    public Iterator<T> traverse(TreeTraverseType type) {
        return switch (type) {
            case PRE_ORDER -> preOrderTraverse();
            case IN_ORDER -> inOrderTraverse();
            case POST_ORDER -> postOrderTraverse();
            case LEVER_ORDER -> leverOrderTraverse();
        };
    }

    //PRIVATE
    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    private boolean contains(Node node, T element) {
        if (node == null) return false;

        int result = element.compareTo((T) node.getData());
        if (result < 0) return contains(node.getLeft(), element);
        else if (result > 0) return contains(node.getRight(), element);
        else return true;
    }

    private Node add(Node node, T element) {
        if (node == null) node = new Node(element, null, null);
        else {
            if (element.compareTo((T) node.getData()) > 0) node.setRight(add(node.getRight(), element));
            else node.setLeft(add(node.getLeft(), element));
        }
        return node;
    }

    private Node remove(Node node, T element) {
        int result = element.compareTo((T) node.getData());
        if (result > 0) node.setRight(remove(node.getRight(), element));
        else if (result < 0) node.setLeft(remove(node.getLeft(), element));
        else if (node.getLeft() == null) {
            Node rightNote = node.getRight();
            node.setData(null);
            node = null;
            return node.getRight();
        } else if (node.getRight() == null) {
            T tmp = minRight(node.getRight());
            node.setData(tmp);
            node.setRight(remove(node.getRight(), tmp));
        }
        return node;
    }

    private T minRight(Node node) {
        while (node.getLeft() != null) node = node.getLeft();
        return (T) node;
    }

    private T maxLeft(Node node) {
        while (node.getRight() != null) node = node.getRight();
        return (T) node;
    }

    private Iterator<T> preOrderTraverse() {
        final int expectedCount = noteCount;
        Stack<Node> stack = new Stack();
        if (root != null) stack.push(root);

        return new Iterator() {
            @Override
            public boolean hasNext() {
                if (expectedCount != noteCount) throw new ConcurrentModificationException();
                return !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedCount != noteCount) throw new ConcurrentModificationException();
                if (!hasNext()) throw new NoSuchElementException();

                Node node = stack.pop();
                if (node.getRight() != null) stack.push(node.getRight());
                if (node.getLeft() != null) stack.push(node.getLeft());
                return (T) node.getData();
            }
        };
    }

    private Iterator<T> inOrderTraverse() {
        final int expectedCount = noteCount;
        Stack<Node> stack = new Stack();
        if (root != null) stack.push(root);

        return new Iterator<T>() {
            Node trav = root;

            @Override
            public boolean hasNext() {
                if (expectedCount != noteCount)
                    throw new ConcurrentModificationException();

                return !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedCount != noteCount)
                    throw new ConcurrentModificationException();

                while (trav != null && trav.getLeft() != null) {
                    stack.push(trav.getLeft());
                    trav = trav.getLeft();
                }

                Node node = stack.pop();

                if (node.getRight() != null) {
                    stack.push(node.getRight());
                    trav = node.getRight();
                }
                return (T) node.getData();
            }
        };
    }

    private Iterator<T> postOrderTraverse() {
        final int expectedCount = noteCount;
        Stack<Node> stack = new Stack();
        if (root != null) stack.push(root);
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedCount != noteCount)
                    throw new ConcurrentModificationException();
                return !stack.isEmpty();
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

    private Iterator<T> leverOrderTraverse() {
        final int expectedCount = noteCount;
        Stack<Node> stack = new Stack();
        if (root != null) stack.push(root);

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
}