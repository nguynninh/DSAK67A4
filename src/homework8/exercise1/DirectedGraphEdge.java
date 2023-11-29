package homework8.exercise1;

public class DirectedGraphEdge<T> {
    private T source;
    private T destination;
    private double height;

    public DirectedGraphEdge(T source, T destination) {
        this.source = source;
        this.destination = destination;
    }

    public DirectedGraphEdge(T source, T destination, double height) {
        this.source = source;
        this.destination = destination;
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
        return "(" + source + ", " + destination + ", " + height + ")";
    }
}