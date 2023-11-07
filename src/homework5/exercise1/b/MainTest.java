package homework5.exercise1.b;

import homework5.exercise1.BinaryTreeInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainTest {
    public static void main(String[] args) {
        BinaryTreeInterface<Integer> binaryTree = new LinkedBinaryTree<>();

        LinkedBinaryTree.Node<Integer> root = new LinkedBinaryTree.Node<>(1, null, null, null);
        binaryTree.setData(root);

        LinkedBinaryTree.Node<Integer> leftChild = new LinkedBinaryTree.Node<>(5, root, null, null);
        root.setLeft(leftChild);

        LinkedBinaryTree.Node<Integer> rightChild = new LinkedBinaryTree.Node<>(3, root, null, null);
        root.setRight(rightChild);

        LinkedBinaryTree.Node<Integer> leftChildOfLeft = new LinkedBinaryTree.Node<>(8, leftChild, null, null);
        leftChild.setLeft(leftChildOfLeft);

        LinkedBinaryTree.Node<Integer> rightChildOfLeft = new LinkedBinaryTree.Node<>(6, leftChild, null, null);
        leftChild.setRight(rightChildOfLeft);

        LinkedBinaryTree.Node<Integer> leftChildOfRight = new LinkedBinaryTree.Node<>(2, leftChild, null, null);
        rightChild.setLeft(leftChildOfRight);

        LinkedBinaryTree.Node<Integer> rightChildOfRight = new LinkedBinaryTree.Node<>(7, leftChild, null, null);
        rightChild.setRight(rightChildOfRight);

        binaryTree.addDataToFile();
        System.out.println(binaryTree);

    }
}
