package homework5.exercise1.a;

import homework5.exercise1.BinaryTreeInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainTest {
    public static void main(String[] args) {
        BinaryTreeInterface<Integer> binaryTree = new ArrayBinaryTree<>();
        Integer[] data = new Integer[]{1, 5, 3, 8, 6, 2, 7};
        ((ArrayBinaryTree) binaryTree).setData(data);
        System.out.println(binaryTree);

        try {
            FileWriter fw = new FileWriter(new File("src/homework5/exercise1/b/linked_binary_tree.txt"));
            fw.write(binaryTree.toString());
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
