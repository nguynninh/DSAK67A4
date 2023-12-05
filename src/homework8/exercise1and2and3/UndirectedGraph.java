package homework8.exercise1and2and3;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph<T> implements GraphADT<T, UndirectedGraphEdge<T>> {
    private int[][] adjacencyMatrix;
    private List<T> vertices;

    public UndirectedGraph(int numVertices) {
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
            for (int j = i; j < numVertices(); j++) {
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
            for (int j = i; j < numVertices(); j++) {
                if (adjacencyMatrix[i][j] == 1) {
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
        if (indexU != -1 && indexV != -1 && adjacencyMatrix[indexU][indexV] == 1) {
            return new UndirectedGraphEdge<>(u, v);
        }
        return null;
    }

    @Override
    public int outDegree(T v) {
        int indexV = vertices.indexOf(v);
        if (indexV != -1) {
            int degree = 0;
            for (int i = 0; i < numVertices(); i++) {
                degree += adjacencyMatrix[indexV][i];
            }
            return degree;
        }
        return -1;
    }

    @Override
    public int inDegree(T v) {
        return outDegree(v);
    }

    @Override
    public Iterable<UndirectedGraphEdge<T>> outgoingEdges(T v) {
        int indexV = vertices.indexOf(v);
        if (indexV != -1) {
            List<UndirectedGraphEdge<T>> outgoingEdges = new ArrayList<>();
            for (int i = 0; i < numVertices(); i++) {
                if (adjacencyMatrix[indexV][i] == 1) {
                    T u = vertices.get(indexV);
                    T dest = vertices.get(i);
                    outgoingEdges.add(new UndirectedGraphEdge<>(u, dest));
                }
            }
            return outgoingEdges;
        }
        return null;
    }

    @Override
    public Iterable<UndirectedGraphEdge<T>> incomingEdges(T v) {
        return outgoingEdges(v);
    }

    @Override
    public void insertVertex(T vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
        }
    }

    @Override
    public void removeVertex(T vertex) {
        int index = vertices.indexOf(vertex);
        if (index != -1) {
            // Xóa cột và hàng tương ứng trong ma trận kề
            for (int i = index; i < numVertices() - 1; i++) {
                for (int j = 0; j < numVertices(); j++) {
                    adjacencyMatrix[i][j] = adjacencyMatrix[i + 1][j];
                }
            }
            for (int j = index; j < numVertices() - 1; j++) {
                for (int i = 0; i < numVertices(); i++) {
                    adjacencyMatrix[i][j] = adjacencyMatrix[i][j + 1];
                }
            }

            // Xóa đỉnh khỏi danh sách đỉnh
            vertices.remove(index);
        }
    }

    @Override
    public void insertEdge(T u, T v, int weight) {
        int indexU = vertices.indexOf(u);
        int indexV = vertices.indexOf(v);
        if (indexU != -1 && indexV != -1) {
            adjacencyMatrix[indexU][indexV] = 1;
            adjacencyMatrix[indexV][indexU] = 1;
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
            adjacencyMatrix[indexV][indexU] = 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("  ");
        for (int i = 0; i < numVertices(); i++) {
            builder.append(vertices
                    .get(i)).append(" ");
        }
        builder.append("\n");

        for (int j = 0; j < numVertices(); j++) {
            builder.append(vertices.get(j)).append(" ");
            for (int i = 0; i < numVertices(); i++) {
                builder.append(adjacencyMatrix[j][i]).append(" ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
