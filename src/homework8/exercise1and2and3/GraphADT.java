package homework8.exercise1and2and3;

public interface GraphADT<T, W> {
    int numVertices();

    int numEdges();

    Iterable<T> vertices();

    Iterable<W> edges();

    W getEdge(T u, T v);

    int outDegree(T v);

    int inDegree(T v);

    Iterable<W> outgoingEdges(T v);

    Iterable<W> incomingEdges(T v);

    void insertVertex(T vertex);

    void removeVertex(T vertex);

    void insertEdge(T u, T v, int weight);

    void removeEdge(W edge);
}
