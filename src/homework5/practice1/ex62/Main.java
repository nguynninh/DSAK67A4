package homework5.practice1.ex62;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedBinaryTree tree = new LinkedBinaryTree();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            tree.add(sc.nextInt());
        }

        tree.print();
    }
}
