package homework7.exercise2;

import homework5.exercise1.b.LinkedBinaryTree;

public class BinarySeachTree<E extends Comparable<E>, T> extends LinkedBinaryTree<E, T> {

    public Node<E> findMin() {
        Node<E> node = (Node<E>) root();
        while (isNotEmpty(left((T) node))) {
            node = (Node<E>) left((T) node);
        }
        return node;
    }

    public Node<E> search(E value) {
        Node<E> node = (Node<E>) root();
        while (isNotEmpty((T) node)) {
            if (value.equals(node.getData())) {
                return node;
            } else if (value.compareTo(node.getData()) < 0) {
                node = (Node<E>) left((T) node);
            } else {
                node = (Node<E>) right((T) node);
            }
        }
        return null;
    }

    public Node<E> insert(E value) {
        if (root() == null) {
            root = new Node<>(value);
            return (Node<E>) root();
        }
        return insert(value, null, (Node<E>) root());

    }

    public Node<E> insert(E value, Node<E> parent, Node<E> node) {
        if (node == null) {
            Node<E> newNode = new Node<>(value);
            newNode.setParent(parent);
            return new Node<>(value);
        }
        if (value.compareTo(node.getData()) < 0) {
            node.setLeft(insert(value, node, (Node<E>) left((T) node)));
        }
        if (value.compareTo(node.getData()) > 0) {
            node.setRight(insert(value, node, (Node<E>) right((T) node)));
        }
        return node;
    }

    public void remove(E value) {
        remove(value, (Node<E>) root());
    }

    private Node<E> remove(E value, Node<E> node) {
        if (node == null) {
            return null;
        }
        if (value.compareTo(node.getData()) < 0) {
            node.setLeft(remove(value, (Node<E>) left((T) node)));
        } else if (value.compareTo(node.getData()) > 0) {
            node.setRight(remove(value, (Node<E>) right((T) node)));
        } else {
            if (left((T) node) == null && right((T) node) == null)
                return null;

            if (left((T) node) != null && right((T) node) == null)
                return (Node<E>) left((T) node);

            if (left((T) node) == null && right((T) node) != null)
                return (Node<E>) right((T) node);

            Node<E> mostLeftNode = findNodeMostLeft((Node<E>) right((T) node));
            node.setData(mostLeftNode.getData());
            node.setRight(remove(mostLeftNode.getData(), (Node<E>) right((T) node)));
        }
        return node;
    }

    private Node<E> findNodeMostLeft(Node<E> node) {
        if (node == null) {
            return null;
        }
        Node<E> leftMostNode = node;
        while (left((T) leftMostNode) != null) {
            leftMostNode = (Node<E>) left((T) leftMostNode);
        }
        return leftMostNode;
    }

    private boolean isNotEmpty(T node) {
        return node != null;
    }
}
