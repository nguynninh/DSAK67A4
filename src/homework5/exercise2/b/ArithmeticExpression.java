package homework5.exercise2.b;

import homework5.exercise1.b.LinkedBinaryTree;

import java.util.Stack;

public class ArithmeticExpression<E extends Comparable<E>> {
    private LinkedBinaryTree<E, LinkedBinaryTree.Node<E>> data;

    public ArithmeticExpression() {
        this.data = new LinkedBinaryTree<>();
    }

    public void add(LinkedBinaryTree.Node<E> data) {
        this.data.setData(data);
    }

    public void preorderPrint(LinkedBinaryTree.Node<E> p) {
        // pre - order traversal of tree with root p
        if (p == null)
            return;

        System.out.print(p.getData() + " ");

        preorderPrint(p.getLeft());

        preorderPrint(p.getRight());
    }


    public void postorderPrint(LinkedBinaryTree.Node<E> p) {
        // post - order traversal of tree with root p
        if (p == null)
            return;

        postorderPrint(p.getLeft());

        postorderPrint(p.getRight());
        System.out.print(p.getData() + " ");
    }


    public void inorderPrint(LinkedBinaryTree.Node<E> p) {
        //in - order traversal of tree with root p
        if (p == null)
            return;

        inorderPrint(p.getLeft());

        System.out.print(p.getData() + " ");

        inorderPrint(p.getRight());
    }
}
