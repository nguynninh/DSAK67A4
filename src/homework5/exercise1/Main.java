//package homework5.exercise1;
//
//import homework5.exercise1.b.LinkedBinaryTree;
//
//public class Main {
//    public static void main(String[] args) {
//        // Create a LinkedBinaryTree
//        BinaryTreeInterface<Integer> binaryTree = new LinkedBinaryTree<>();
//
//        // Insert some nodes
//        binaryTree.insertRoot(1);
//        Node<Integer> root = binaryTree.getRoot();
//        Node<Integer> leftChild = binaryTree.addLeftChild(root, 2);
//        Node<Integer> rightChild = binaryTree.addRightChild(root, 3);
//
//        // Test various methods
//        assert binaryTree.size() == 3;
//        assert binaryTree.root() == 1;
//        assert binaryTree.left(root) == 2;
//        assert binaryTree.right(root) == 3;
//        assert binaryTree.parent(leftChild) == 1;
//        assert binaryTree.parent(rightChild) == 1;
//        assert binaryTree.numChildren(root) == 2;
//        assert binaryTree.sibling(leftChild) == 3;
//        assert binaryTree.sibling(rightChild) == 2;
//
//        // Add more nodes and test again
//        Node<Integer> leftLeftChild = binaryTree.addLeftChild(leftChild, 4);
//        Node<Integer> leftRightChild = binaryTree.addRightChild(leftChild, 5);
//        assert binaryTree.numChildren(leftChild) == 2;
//        assert binaryTree.numChildren(rightChild) == 0;
//        assert binaryTree.numChildren(leftLeftChild) == 0;
//        assert binaryTree.numChildren(leftRightChild) == 0;
//
//        // Test isEmpty
//        assert !binaryTree.isEmpty();
//
//        System.out.println("All tests passed!");
//    }
//}
