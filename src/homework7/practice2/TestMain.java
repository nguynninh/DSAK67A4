package homework7.practice2;

public class TestMain {
    public static void main(String[] args) {
        Solution solution = new Solution();

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(3);
        System.out.println(solution.isBST(root1));

        Node root2 = new Node(2);
        root2.left = new Node(3);
        root2.right = new Node(1);
        System.out.println(solution.isBST(root2));

        Node root3 = null;
        System.out.println(solution.isBST(root3));
    }
}
