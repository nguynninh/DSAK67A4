package homework5.exercise2.c;

import homework5.exercise1.BinaryTreeInterface;
import homework5.exercise1.b.LinkedBinaryTree;

import java.util.Stack;

public class Caculator {
    private BinaryTreeInterface binaryTree;
    private Stack stack;

    public Caculator() {
        binaryTree = new LinkedBinaryTree();
        stack = new Stack();
    }


}
