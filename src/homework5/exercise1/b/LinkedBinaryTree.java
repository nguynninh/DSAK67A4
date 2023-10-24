package homework5.exercise1.b;

import homework5.exercise1.BinaryTreeInterface;

public class LinkedBinaryTree<E, T extends Comparable<T>> implements BinaryTreeInterface<T> {

    protected static class Node<E> {
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
    }

    private Node root;
    private int size;

    @Override
    public T root() {
        return (T) root.data;
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
        return numChild(((Node<T>) p));
    }

    @Override
    public T parent(T p) {
        return ((Node<T>) p).data;
    }

    @Override
    public T left(T p) {
        return (T) ((Node<T>) p).left;
    }

    @Override
    public T right(T p) {
        return (T) ((Node<T>) p).right;
    }

    @Override
    public T sibling(T p) {
        return (T) ((((Node<T>) p).parent.left == (Node<T>) p)
                ? ((Node<T>) p).parent.left
                : ((Node<T>) p).parent.right);
    }

    //PRIVATE
    private int numChild(Node<T> p) {
        int count = 0;

        if (p == null)
            return count;

        if (p.left != null) numChild(p.left);
        if (p.right != null) numChild(p.right);

        return ++count;
    }
}