package homework7.exercise3;

public class TestMain {
    public static void main(String[] args) {
        BalancedBinarySearchTree<Integer, Integer> bst = new BalancedBinarySearchTree<>();

        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        System.out.println("Binary Search Tree:");
        System.out.println(bst);
    }
}