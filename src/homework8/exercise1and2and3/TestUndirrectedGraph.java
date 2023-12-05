package homework8.exercise1and2and3;

public class TestUndirrectedGraph {
    public static void main(String[] args) {
        UndirectedGraph<String> graph = new UndirectedGraph<>(5);

        // Insert vertices
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        // Insert edges
        graph.insertEdge("A", "B", 1);
        graph.insertEdge("B", "C", 1);
        graph.insertEdge("C", "D", 1);
        graph.insertEdge("D", "E", 1);
        graph.insertEdge("E", "A", 1);

        // Display vertices
        System.out.println("Vertices: " + graph.vertices());

        // Display edges
        System.out.println("Edges: " + graph.edges());

        // Display out degree of a vertex
        System.out.println("Out degree of A: " + graph.outDegree("A"));

        // Display in degree of a vertex
        System.out.println("In degree of A: " + graph.inDegree("A"));

        // Display outgoing edges of a vertex
        System.out.println("Outgoing edges of A: " + graph.outgoingEdges("A"));

        // Display incoming edges of a vertex
        System.out.println("Incoming edges of A: " + graph.incomingEdges("A"));

        // Remove an edge
        UndirectedGraphEdge<String> edgeToRemove = graph.getEdge("A", "B");
        graph.removeEdge(edgeToRemove);
        System.out.println("Edges after removing (A, B): " + graph.edges());

        // Remove a vertex
        graph.removeVertex("C");
        System.out.println("Vertices after removing C: " + graph.vertices());
        System.out.println("Edges after removing C: " + graph.edges());

        System.out.println("Print Graph: \n" + graph);
    }
}
