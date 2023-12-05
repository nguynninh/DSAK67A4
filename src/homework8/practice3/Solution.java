package homework8.practice3;//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;

// } Driver Code Ends


public class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        boolean vis[] = new boolean[V];
        vis[0] = true;
        while (!queue.isEmpty()) {
            int cur = queue.remove();

            list.add(cur);

            for (int i : adj.get(cur))
                if (!vis[i]) {
                    queue.add(i);
                    vis[i] = true;
                }
        }
        return list;
    }
}