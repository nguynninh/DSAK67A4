package homework8.exercise1;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph<T> implements GraphADT<T> {
    private int[][] adjacencyMatrix;
    private List<T> vertices;

    public DirectedGraph(int numVertices) {
        this.adjacencyMatrix = new int[numVertices][numVertices];
        this.vertices = new ArrayList<>();
    }

    @Override
    public int numVertices() {
        return vertices.size();
    }

    @Override
    public int numEdges() {
        int count = 0;

        for (int i = 0; i < numVertices(); i++) {
            for (int j = 0; j < numVertices(); j++) {
                count += adjacencyMatrix[i][j];
            }
        }

        return count;
    }

    @Override
    public Iterable<T> vertices() {
        return vertices;
    }

    @Override
    public Iterable<UndirectedGraphEdge<T>> edges() {
        List<UndirectedGraphEdge<T>> edgesList = new ArrayList<>();
        for (int i = 0; i < numVertices(); i++) {
            for (int j = 0; j < numVertices(); j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    T u = vertices.get(i);
                    T v = vertices.get(j);
                    edgesList.add(new UndirectedGraphEdge<>(u, v));
                }
            }
        }
        return edgesList;
    }

    @Override
    public UndirectedGraphEdge<T> getEdge(T u, T v) {
        int indexU = vertices.indexOf(u);
        int indexV = vertices.indexOf(v);
        if (indexU != -1 && indexV != -1 && adjacencyMatrix[indexU][indexV] != 0) {
            return new UndirectedGraphEdge<>(u, v);
        }
        return null;
    }

    @Override
    public int outDegree(T v) {
        return 0;
    }

    @Override
    public int inDegree(T v) {
        return 0;
    }

    @Override
    public Iterable<UndirectedGraphEdge<T>> outgoingEdges(T v) {
        return null;
    }

    @Override
    public Iterable<UndirectedGraphEdge<T>> incomingEdges(T v) {
        return null;
    }

    @Override
    public void insertVertex(T vertex) {

    }

    @Override
    public void removeVertex(T vertex) {

    }

    @Override
    public void insertEdge(T u, T v, int weight) {

    }

    @Override
    public void removeEdge(UndirectedGraphEdge<T> edge) {

    }
}
