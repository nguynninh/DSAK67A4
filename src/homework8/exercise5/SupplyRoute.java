package homework8.exercise5;

public class SupplyRoute {
    private StoreLocation source;
    private StoreLocation destination;
    private int distance;

    public SupplyRoute(StoreLocation source, StoreLocation destination) {
        this.source = source;
        this.destination = destination;
    }

    public SupplyRoute(StoreLocation source, StoreLocation destination, int distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }

    public StoreLocation getSource() {
        return source;
    }

    public StoreLocation getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "(" + source + " -> " + destination + "," + distance + ")";
    }
}
