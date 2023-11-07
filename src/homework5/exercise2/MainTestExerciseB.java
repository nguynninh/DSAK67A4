package homework5.exercise2;

import homework5.exercise1.b.LinkedBinaryTree;
import homework5.exercise1.b.LinkedBinaryTree.Node;

public class MainTestExerciseB {
    public static void main(String[] args) {
        ArithmeticExpression<String> arithmetic = new ArithmeticExpression();

        Node<String> root = new Node<>("*", null, null, null);
        arithmetic.add(root);

        Node<String> leftChild = new Node<>("+", root, null, null);
        root.setLeft(leftChild);

        LinkedBinaryTree.Node<String> rightChild = new Node<>("-", root, null, null);
        root.setRight(rightChild);

        LinkedBinaryTree.Node<String> leftChildOfLeft = new LinkedBinaryTree.Node<>("/", leftChild, null, null);
        leftChild.setLeft(leftChildOfLeft);

        LinkedBinaryTree.Node<String> rightChildOfLeft = new LinkedBinaryTree.Node<>("2", leftChild, null, null);
        leftChild.setRight(rightChildOfLeft);

        LinkedBinaryTree.Node<String> leftChildOfRight = new LinkedBinaryTree.Node<>("7", rightChild, null, null);
        rightChild.setLeft(leftChildOfRight);

        LinkedBinaryTree.Node<String> rightChildOfRight = new LinkedBinaryTree.Node<>("4", rightChild, null, null);
        rightChild.setRight(rightChildOfRight);

        LinkedBinaryTree.Node<String> leftChildOfleftChildOfLeft = new LinkedBinaryTree.Node<>("6", leftChildOfLeft, null, null);
        leftChildOfLeft.setLeft(leftChildOfleftChildOfLeft);

        LinkedBinaryTree.Node<String> rightChildOfleftChildOfLeft = new LinkedBinaryTree.Node<>("3", leftChildOfLeft, null, null);
        leftChildOfLeft.setRight(rightChildOfleftChildOfLeft);

        arithmetic.inorderPrint(root);
        System.out.println("\n");
        arithmetic.postorderPrint(root);
        System.out.println("\n");
        arithmetic.preorderPrint(root);
    }
}
