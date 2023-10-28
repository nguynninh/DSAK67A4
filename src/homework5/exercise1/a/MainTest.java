package homework5.exercise1.a;

import homework5.exercise1.BinaryTreeInterface;

public class MainTest {
    public static void main(String[] args) {
        BinaryTreeInterface<Integer> binaryTree = new ArrayBinaryTree<>();
        binaryTree.setData(new int[]{1, 5, 3, 8, 6, 2, 7});
        System.out.println(binaryTree);
    }
}
