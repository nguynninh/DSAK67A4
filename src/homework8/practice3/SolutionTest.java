package homework8.practice3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(3);
        adj.get(2).add(4);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 3, 2, 4));
        System.out.println("Expected: " + expected);

        List<Integer> result = solution.bfsOfGraph(V, adj);
        System.out.println("Result: " + result);
    }
}
