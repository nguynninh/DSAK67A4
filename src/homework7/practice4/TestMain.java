package homework7.practice4;

public class TestMain {
    public static void main(String[] args) {
        Solution solution = new Solution();

        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        int range1Count = solution.getCount(root, 3, 7);
        System.out.println("Nodes in the range [3, 7]: " + range1Count);

        int range2Count = solution.getCount(root, 1, 9);
        System.out.println("Nodes in the range [1, 9]: " + range2Count);

        int range3Count = solution.getCount(root, 0, 2);
        System.out.println("Nodes in the range [0, 2]: " + range3Count);
    }
}
