package homework8.exercise1;

public interface GraphADT<T> {
    int numVertices();
    int numEdges();
    Iterable<T> vertices();
    Iterable<Edge<T>> edges();
    Edge<T> getEdge(T u, T v);
    int outDegree(T v);
    int inDegree(T v);
    Iterable<Edge<T>> outgoingEdges(T v);
    Iterable<Edge<T>> incomingEdges(T v);
    void insertVertex(T vertex);
    void removeVertex(T vertex);
    void insertEdge(T u, T v, int weight);
    void removeEdge(Edge<T> edge);
}
