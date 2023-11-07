package homework5.exercise2;

import homework5.exercise1.b.LinkedBinaryTree;

public class MainTestExerciseC {
    public static void main(String[] args) {
        ArithmeticExpression<String> arithmetic = new ArithmeticExpression();

        LinkedBinaryTree.Node<String> root = new LinkedBinaryTree.Node<>("*", null, null, null);
        arithmetic.add(root);

        LinkedBinaryTree.Node<String> leftChild = new LinkedBinaryTree.Node<>("+", root, null, null);
        root.setLeft(leftChild);

        LinkedBinaryTree.Node<String> rightChild = new LinkedBinaryTree.Node<>("-", root, null, null);
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

        arithmetic.setData(root);
        System.out.println("The result of the above expression is: "+arithmetic.caculator());
    }
}
