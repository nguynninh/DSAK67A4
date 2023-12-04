package homework8.exercise1;

public class DirectedGraphEdge<T> extends UndirectedGraphEdge<T> {
    private double height;

    public DirectedGraphEdge(T source, T destination) {
        super(source, destination);
    }

    public DirectedGraphEdge(T source, T destination, double height) {
        super(source, destination);
        this.height = height;
    }

    public T getSource() {
        return source;
    }

    public T getDestination() {
        return destination;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "(" + source + " -> " + destination + ", " + height + ")";
    }
}