package homework8.practice2;//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;

// } Driver Code Ends


public class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();

        boolean[] vis = new boolean[V];
        dfs(adj, vis, ans, 0);

        return ans;
    }

    void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans, int cur) {
        ans.add(cur);

        vis[cur] = true;

        for (int temp : adj.get(cur))
            if (!vis[temp])
                dfs(adj, vis, ans, temp);
    }
}