package homework8.exercise1and2and3;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph<T> implements GraphADT<T, DirectedGraphEdge<T>> {
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
    public Iterable<DirectedGraphEdge<T>> edges() {
        List<DirectedGraphEdge<T>> edgesList = new ArrayList<>();
        for (int i = 0; i < numVertices(); i++) {
            for (int j = 0; j < numVertices(); j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    T u = vertices.get(i);
                    T v = vertices.get(j);
                    edgesList.add(new DirectedGraphEdge<>(u, v, adjacencyMatrix[i][j]));
                }
            }
        }
        return edgesList;
    }

    @Override
    public DirectedGraphEdge<T> getEdge(T u, T v) {
        int indexU = vertices.indexOf(u);
        int indexV = vertices.indexOf(v);
        if (indexU != -1 && indexV != -1 && adjacencyMatrix[indexU][indexV] != 0) {
            return new DirectedGraphEdge<>(u, v, adjacencyMatrix[indexU][indexV]);
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
    public Iterable<DirectedGraphEdge<T>> outgoingEdges(T v) {
        int indexV = vertices.indexOf(v);
        if (indexV != -1) {
            List<DirectedGraphEdge<T>> edgesList = new ArrayList<>();
            for (int i = 0; i < numVertices(); i++) {
                if (adjacencyMatrix[indexV][i] != 0) {
                    T u = vertices.get(indexV);
                    T dest = vertices.get(i);
                    edgesList.add(new DirectedGraphEdge<>(u, dest,adjacencyMatrix[indexV][i]));
                }
            }
            return edgesList;
        }
        return null;
    }

    @Override
    public Iterable<DirectedGraphEdge<T>> incomingEdges(T v) {
        int indexV = vertices.indexOf(v);
        if (indexV != -1) {
            List<DirectedGraphEdge<T>> edgesList = new ArrayList<>();
            for (int i = 0; i < numVertices(); i++) {
                if (adjacencyMatrix[i][indexV] != 0) {
                    T src = vertices.get(i);
                    T dest = vertices.get(indexV);
                    edgesList.add(new DirectedGraphEdge<>(src, dest,adjacencyMatrix[i][indexV]));
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
    public void removeEdge(DirectedGraphEdge<T> edge) {
        T u = edge.getSource();
        T v = edge.getDestination();
        int indexU = vertices.indexOf(u);
        int indexV = vertices.indexOf(v);
        if (indexU != -1 && indexV != -1) {
            adjacencyMatrix[indexU][indexV] = 0;
        }
    }

}
