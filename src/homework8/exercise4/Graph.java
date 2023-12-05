package homework8.exercise4;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int V;
    private List<List<Integer>> adjacencyList;

    public Graph(int vertices) {
        V = vertices;
        adjacencyList = new ArrayList<>(V);

        for (int i = 0; i < V; ++i) {
            adjacencyList.add(new ArrayList<>());
        }
    }


    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    public void printAdjacencyList() {
        for (int i = 0; i < V; ++i) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);


        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printAdjacencyList();
    }
}