package homework8.exercise1;

public interface GraphADT<T> {
    int numVertices();
    int numEdges();
    Iterable<T> vertices();
    Iterable<UndirectedGraphEdge<T>> edges();
    UndirectedGraphEdge<T> getEdge(T u, T v);
    int outDegree(T v);
    int inDegree(T v);
    Iterable<UndirectedGraphEdge<T>> outgoingEdges(T v);
    Iterable<UndirectedGraphEdge<T>> incomingEdges(T v);
    void insertVertex(T vertex);
    void removeVertex(T vertex);
    void insertEdge(T u, T v, int weight);
    void removeEdge(UndirectedGraphEdge<T> edge);
}
