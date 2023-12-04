package homework8.exercise1;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph<T> implements GraphADT<T, Integer> {
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
        int indexV = vertices.indexOf(v);
        if (indexV != -1) {
            int count = 0;
            for (int i = 0; i < numVertices(); i++) {
                count += adjacencyMatrix[indexV][i];
            }
            return count;
        }
        return -1;
    }

    @Override
    public int inDegree(T v) {
        int indexV = vertices.indexOf(v);
        if (indexV != -1) {
            int count = 0;
            for (int i = 0; i < numVertices(); i++) {
                count += adjacencyMatrix[i][indexV];
            }
            return count;
        }
        return -1;
    }


    @Override
    public Iterable<UndirectedGraphEdge<T>> outgoingEdges(T v) {
        int indexV = vertices.indexOf(v);
        if (indexV != -1) {
            List<UndirectedGraphEdge<T>> edgesList = new ArrayList<>();
            for (int i = 0; i < numVertices(); i++) {
                if (adjacencyMatrix[indexV][i] != 0) {
                    T u = vertices.get(indexV);
                    T dest = vertices.get(i);
                    edgesList.add(new UndirectedGraphEdge<>(u, dest));
                }
            }
            return edgesList;
        }
        return null;
    }

    @Override
    public Iterable<UndirectedGraphEdge<T>> incomingEdges(T v) {
        int indexV = vertices.indexOf(v);
        if (indexV != -1) {
            List<UndirectedGraphEdge<T>> edgesList = new ArrayList<>();
            for (int i = 0; i < numVertices(); i++) {
                if (adjacencyMatrix[i][indexV] != 0) {
                    T src = vertices.get(i);
                    T dest = vertices.get(indexV);
                    edgesList.add(new UndirectedGraphEdge<>(src, dest));
                }
            }
            return edgesList;
        }
        return null;
    }


    @Override
    public void insertVertex(T vertex) {
        vertices.add(vertex);
    }

    @Override
    public void removeVertex(T vertex) {
        int index = vertices.indexOf(vertex);
        if (index != -1) {
            vertices.remove(index);

            for (int i = 0; i < numVertices(); i++) {
                adjacencyMatrix[index][i] = 0;
                adjacencyMatrix[i][index] = 0;
            }
        }
    }


    @Override
    public void insertEdge(T u, T v, int weight) {
        int indexU = vertices.indexOf(u);
        int indexV = vertices.indexOf(v);
        if (indexU != -1 && indexV != -1) {
            adjacencyMatrix[indexU][indexV] = weight;
        }
    }


    @Override
    public void removeEdge(UndirectedGraphEdge<T> edge) {
        T u = edge.getSource();
        T v = edge.getDestination();
        int indexU = vertices.indexOf(u);
        int indexV = vertices.indexOf(v);
        if (indexU != -1 && indexV != -1) {
            adjacencyMatrix[indexU][indexV] = 0;
        }
    }

}
