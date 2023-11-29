package homework8.exercise1;

public class UndirectedGraphEdge<T> {
    private T source;
    private T destination;

    public UndirectedGraphEdge(T source, T destination) {
        this.source = source;
        this.destination = destination;
    }

    public T getSource() {
        return source;
    }

    public T getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "(" + source + ", " + destination + ")";
    }
}