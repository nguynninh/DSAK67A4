package homework7.exercise2;

import homework5.exercise1.b.LinkedBinaryTree;

import java.util.*;

public class RunTime {
    private static Random random = new Random();
    private static LinkedList<Integer> data = getDataTest(100_000);

    public static void main(String[] args) {
        int value = 20;

        LinkedList<Integer> list = data;
        long sequentialSearchTime = getTimeSequentialSearch(list, value);

        LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> linkBT = addValueAtLinkedBinaryTree();
        long binarySearchTime = getBinarySearchTime(linkBT, value);

        BinarySearchTree<Integer, BinarySearchTree.Node<Integer>> bst = addValueAtBinarySeachTree();
        long treeSearchTime = getTreeSearchTime(bst, value);

        System.out.println("Sequential Search Time: " + sequentialSearchTime + " nanoseconds");
        System.out.println("Binary Search Time: " + binarySearchTime + " nanoseconds");
        System.out.println("Tree Search Time: " + treeSearchTime + " nanoseconds");
    }

    //PRIVATE

    //SEARCH
    private static long getBinarySearchTime(LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> linkBT, int value) {
        long time = System.nanoTime();

        linkBT.searchValue(value);

        return System.nanoTime() - time;
    }

    private static long getTreeSearchTime(BinarySearchTree<Integer, LinkedBinaryTree.Node<Integer>> bst, int value) {
        long time = System.nanoTime();

        bst.search(value);

        return System.nanoTime() - time;
    }

    private static long getTimeSequentialSearch(LinkedList<Integer> list, int value) {
        long time = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {
            if (value == list.get(i))
                break;
        }

        return System.nanoTime() - time;
    }


    // ADD
    private static LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> addValueAtLinkedBinaryTree() {
        LinkedBinaryTree<Integer, LinkedBinaryTree.Node<Integer>> linkedBinaryTree = new LinkedBinaryTree<>();

        for (Integer i: data)
            linkedBinaryTree.insertValue(i);

        return linkedBinaryTree;
    }

    private static BinarySearchTree<Integer, LinkedBinaryTree.Node<Integer>> addValueAtBinarySeachTree() {
        BinarySearchTree<Integer, LinkedBinaryTree.Node<Integer>> bst = new BinarySearchTree<>();

        for (Integer i : data)
            bst.insert(i);

        return bst;
    }

    // SET UP DATA
    public static LinkedList<Integer> getDataTest(int capacity) {
        final int MAX_VALUE = 1000;
        final int MIN_VALUE = 0;

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < capacity; i++)
            list.add(random.nextInt(MIN_VALUE, MAX_VALUE + 1));

        return list;
    }

}