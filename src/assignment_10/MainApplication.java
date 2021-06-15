package assignment_10;


/**
 * This class represents main application of graph implementation
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since June 15th 2021
 * */
public class MainApplication {

    /**
     * This method is used as main method
     *
     * @param args arguments to the console app while compiled and launched.
     * */
    public static void main(String[] args) {
        // PREPARE THE GRAPH
        Graph<Integer> graph = new Graph<>(false, true);

        // ADDING NEW EDGE TO THE GRAPH
        graph.addEdge(1, 5, 10);
        graph.addEdge(2, 4, 15);
        graph.addEdge(3, 2, 5);
        graph.addEdge(4, 3, 7);

        // PRINT ALL VERTEX IN THE GRAPH
        System.out.println("Number of vertex in the graph : " + graph.getNVertex());
        graph.getVertexes().forEach(vertex -> {
            System.out.println("- " + vertex);
        });
        System.out.println();

        // PRINT ALL EDGE IN THE GRAPH
        System.out.println("Number of edge in the graph : " + graph.getNEdge());
        graph.getEdges().forEach((vertex, weight) -> {
            System.out.print("Vertex " + vertex.getKey() + " is connected to vertex " + vertex.getValue());
            if (graph.getWeighted()) System.out.print(" with weight " + weight);
            System.out.println();
        });
        System.out.println();

        // REMOVE EDGE AND VERTEX FROM THE GRAPH
        graph.removeEdge(2, 4);
        graph.removeVertex(3);

        System.out.println("After removing edge and vertex");
        System.out.println("--------------------------------------");

        // PRINT ALL VERTEX IN THE GRAPH AFTER DELETION
        System.out.println("Number of vertex in the graph : " + graph.getNVertex());
        graph.getVertexes().forEach(vertex -> {
            System.out.println("- " + vertex);
        });
        System.out.println();

        // PRINT ALL EDGE IN THE GRAPH AFTER DELETION
        System.out.println("Number of edge in the graph : " + graph.getNEdge());
        graph.getEdges().forEach((vertex, weight) -> {
            System.out.print("Vertex " + vertex.getKey() + " is connected to vertex " + vertex.getValue());
            if (graph.getWeighted()) System.out.print(" with weight " + weight);
            System.out.println();
        });
        System.out.println();
    }

}
