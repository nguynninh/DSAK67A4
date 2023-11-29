package homework7.exercise2;

import homework5.exercise1.b.LinkedBinaryTree;

public class TestMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer, LinkedBinaryTree.Node<Integer>> bst = new BinarySearchTree<>();

        // Insert values into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder Traversal:");
        System.out.println(bst);

        LinkedBinaryTree.Node<Integer> minNode = bst.findMin();
        System.out.println("\nMinimum Value: " + minNode.getData());

        int searchValue = 40;
        LinkedBinaryTree.Node<Integer> searchResult = bst.search(searchValue);
        System.out.println("\nSearch for value " + searchValue + ": " + (searchResult != null ? "Found" : "Not Found"));

        int removeValue = 30;
        System.out.println("\nRemoving value " + removeValue);
        bst.remove(removeValue);

        System.out.println("\nInorder Traversal after removal:");
        System.out.println(bst);


    }
}
