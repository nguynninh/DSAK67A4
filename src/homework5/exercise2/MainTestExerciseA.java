package homework5.exercise2;

import homework5.exercise1.b.LinkedBinaryTree;

public class MainTestExerciseA {
    public static void main(String[] args) {
        ArithmeticExpression<Integer> arithmeticExpression = new ArithmeticExpression<>();

        LinkedBinaryTree.Node<Integer> root = new LinkedBinaryTree.Node<>(1, null, null, null);

        LinkedBinaryTree.Node<Integer> leftChild = new LinkedBinaryTree.Node<>(5, root, null, null);
        root.setLeft(leftChild);

        LinkedBinaryTree.Node<Integer> rightChild = new LinkedBinaryTree.Node<>(3, root, null, null);
        root.setRight(rightChild);

        LinkedBinaryTree.Node<Integer> leftChildOfLeft = new LinkedBinaryTree.Node<>(8, leftChild, null, null);
        leftChild.setLeft(leftChildOfLeft);

        LinkedBinaryTree.Node<Integer> rightChildOfLeft = new LinkedBinaryTree.Node<>(6, leftChild, null, null);
        leftChild.setRight(rightChildOfLeft);

        LinkedBinaryTree.Node<Integer> leftChildOfRight = new LinkedBinaryTree.Node<>(2, rightChild, null, null);
        rightChild.setLeft(leftChildOfRight);

        LinkedBinaryTree.Node<Integer> rightChildOfRight = new LinkedBinaryTree.Node<>(7, rightChild, null, null);
        rightChild.setRight(rightChildOfRight);

        arithmeticExpression.preorderPrint(root);
        System.out.println("\n");
        arithmeticExpression.inorderPrint(root);
        System.out.println("\n");
        arithmeticExpression.postorderPrint(root);
    }
}
