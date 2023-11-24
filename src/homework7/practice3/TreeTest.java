package homework7.practice3;

public class TreeTest {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(6);

        float median = Tree.findMedian(root);

        System.out.println("Median of the tree: " + median);
    }
}

