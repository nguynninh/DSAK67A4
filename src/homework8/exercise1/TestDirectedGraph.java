package homework8.exercise1;

public class TestDirectedGraph {
    public static void main(String[] args) {
        DirectedGraph<String> graph = new DirectedGraph<>(5);

        // Insert vertices
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        // Insert edges
        graph.insertEdge("A", "B", 1);
        graph.insertEdge("B", "C", 2);
        graph.insertEdge("C", "A", 3);
        graph.insertEdge("D", "A", 4);
        graph.insertEdge("E", "D", 5);

        // Print the number of vertices and edges
        System.out.println("Number of Vertices: " + graph.numVertices());
        System.out.println("Number of Edges: " + graph.numEdges());

        // Print vertices
        System.out.println("Vertices: " + graph.vertices());

        // Print edges
        System.out.println("Edges:");
        for (UndirectedGraphEdge<String> edge : graph.edges()) {
            System.out.println(edge.getSource() + " -> " + edge.getDestination());
        }

        // Test outDegree and inDegree
        System.out.println("Out Degree of A: " + graph.outDegree("A"));
        System.out.println("In Degree of A: " + graph.inDegree("A"));

        // Test outgoingEdges and incomingEdges
        System.out.println("Outgoing Edges from A:");
        for (UndirectedGraphEdge<String> edge : graph.outgoingEdges("A")) {
            System.out.println(edge.getSource() + " -> " + edge.getDestination());
        }

        System.out.println("Incoming Edges to A:");
        for (UndirectedGraphEdge<String> edge : graph.incomingEdges("A")) {
            System.out.println(edge.getSource() + " -> " + edge.getDestination());
        }

        // Test removeVertex
        graph.removeVertex("A");
        System.out.println("Vertices after removing A: " + graph.vertices());
        System.out.println("Edges after removing A:");
        for (UndirectedGraphEdge<String> edge : graph.edges()) {
            System.out.println(edge.getSource() + " -> " + edge.getDestination());
        }

    }
}
