package homework5.exercise1.a;

import homework5.exercise1.BinaryTreeInterface;

public class MainTest {
    public static void main(String[] args) {
        BinaryTreeInterface<Integer> binaryTree = new ArrayBinaryTree<>();
        Integer[] data = new Integer[]{1, 5, 3, 8, 6, 2, 7};
        binaryTree.setData(data);
        binaryTree.addDataToFile();
        System.out.println(binaryTree);

    }
}
