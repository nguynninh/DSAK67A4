package homework5.exercise2.a;

import homework5.exercise1.b.LinkedBinaryTree;

public class ExpressionTree<E extends Comparable<E>> extends LinkedBinaryTree {

    public void preorderPrint(Node<E> p) {
        // pre - order traversal of tree with root p
        if (p == null)
            return;

        System.out.print(p.getData() + " ");

        preorderPrint(p.getLeft());

        preorderPrint(p.getRight());
    }


    public void postorderPrint(Node<E> p) {
        // post - order traversal of tree with root p
        if (p == null)
            return;

        postorderPrint(p.getLeft());

        postorderPrint(p.getRight());

        System.out.print(p.getData() + " ");
    }


    public void inorderPrint(Node<E> p) {
        //in - order traversal of tree with root p
        if (p == null)
            return;

        inorderPrint(p.getLeft());

        System.out.print(p.getData() + " ");

        inorderPrint(p.getRight());
    }
}
