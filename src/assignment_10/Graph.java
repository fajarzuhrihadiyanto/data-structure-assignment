package assignment_10;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents Graph data structure with implementation of adjacency list.
 * This graph have component vertex and edge represented by map of source vertex to
 * pair of destination vertex and weight of corresponding vertex pair.
 *
 * @param <T> type of vertex that must implement {@link Comparable}
 *
 * @author Fajar Zuhri Hadiyanto
 * @version 1.0
 * @since June 15th 2021
 * */
public class Graph<T extends Comparable<T>> {

    /** field that specify either the graph is directed or not */
    private final boolean directed;

    /** field that specify either every edge of the graph has weight or not */
    private final boolean weighted;

    /** field that contain main data of this graph that represent connection between vertex */
    private final HashMap<T, ArrayList<Pair<T, Integer>>> adjList;

    /**
     * This constructor will create new graph with specified directed and weighted status.
     *
     * @param directed status that specify either the graph is directed or not
     * @param weighted status that specify either every edge of the graph has weight or not
     * */
    public Graph(boolean directed, boolean weighted) {
        this.directed = directed;
        this.weighted = weighted;
        this.adjList = new HashMap<>();
    }

    /**
     * This constructor will create new non direct and non weight graph.
     * */
    public Graph() {
        this(false, false);
    }

    /**
     * This method is used to get the status if the graph is directed or not
     *
     * @return field {@link #directed}
     * */
    public boolean getDirected() {
        return this.directed;
    }

    /**
     * This method is used to get the status if the graph is weighted or not
     *
     * @return field {@link #weighted}
     * */
    public boolean getWeighted() {
        return this.weighted;
    }

    /**
     * This method is used to check if the graph has some vertex
     *
     * @param vertex vertex to be looked for the existence
     * @return true if the given vertex is exist in the graph, otherwise false
     * */
    public boolean hasVertex(T vertex) {
        return this.adjList.containsKey(vertex);
    }

    /**
     * This method is used to check if some vertex in the graph is connected directly
     * to another vertex in one way
     *
     * @param source source vertex to be looked for the connection with other vertex
     * @param destination destination vertex to be looked for the connection with other vertex
     * @return true if those vertex are connected in some way, otherwise false
     * */
    public boolean hasEdge(T source, T destination) {
        return this.adjList.containsKey(source)
                && this.adjList.get(source).stream().anyMatch(elem ->
            elem.getKey().equals(destination)
        );
    }

    /**
     * This method is used to add new vertex to the graph
     *
     * @param vertex new vertex to be added
     * @return true if new vertex successfully added to the graph, otherwise false
     * */
    public boolean addVertex(T vertex) {
        if (this.hasVertex(vertex)) return false;
        this.adjList.put(vertex, new ArrayList<>());
        return true;
    }

    /**
     * This method is used to remove vertex from the graph
     *
     * @param vertex vertex to be removed from the graph
     * @return true if the vertex successfully removed from the graph, otherwise false
     * */
    public boolean removeVertex(T vertex) {
        if (!this.hasVertex(vertex)) return false;
        this.adjList.remove(vertex);
        this.adjList.forEach((k, v) -> v.removeIf(n -> n.getKey().equals(vertex)));
        return true;
    }

    /**
     * This method is used to add new edge to the graph by connecting one vertex to
     * another vertex with a certain weight (in case the graph is weighted).
     *
     * @param source source vertex of the edge
     * @param destination destination vertex of the edge
     * @param weight weight of the edge, only considered if the graph is weighted
     * @return true if new edge successfully added to the graph, otherwise false
     * */
    public boolean addEdge(T source, T destination, int weight) {
        if (this.hasEdge(source, destination)) return false;

        int finalWeight = this.weighted ? weight : 0;

        if (!this.adjList.containsKey(source)) this.addVertex(source);
        if (!this.adjList.containsKey(destination)) this.addVertex(destination);
        this.adjList.get(source).add(new Pair<>(destination, finalWeight));

        if (!this.directed) {
            this.adjList.get(destination).add(new Pair<>(source, finalWeight));
        }

        return true;
    }

    /**
     * This method is used to remove existing edge from the graph
     *
     * @param source source vertex of the edge to be removed from the graph
     * @param destination destination vertex of the edge to be removed from the graph
     * @return true if the edge successfully removed from the graph
     * */
    public boolean removeEdge(T source, T destination) {
        if (!this.hasEdge(source, destination)) return false;
        this.adjList.get(source).removeIf(n -> n.getKey().equals(destination));

        if (!this.directed) {
            this.adjList.get(destination).removeIf(n -> n.getKey().equals(source));
        }
        return true;
    }

    /**
     * This method is used to get list of vertex by extracting and convert key of
     * the adjacency list from hash key set to a new list
     *
     * @return list representation of vertex in the graph
     * */
    public ArrayList<T> getVertexes() {
        return new ArrayList<>(this.adjList.keySet());
    }

    /**
     * This method is used to get list of edge with it's weight
     *
     * @return map representation of pair of vertex with corresponding weight
     * */
    public HashMap<Pair<T, T>, Integer> getEdges() {
        HashMap<Pair<T, T>, Integer> edges = new HashMap<>();

        for (Map.Entry<T, ArrayList<Pair<T, Integer>>> entry : this.adjList.entrySet()) {
            entry.getValue().forEach(pair -> edges.put(new Pair<>(entry.getKey(), pair.getKey()), pair.getValue()));
        }

        return edges;
    }

    /**
     * This method is used to get total number of vertex in the graph
     *
     * @return number of the vertex in the graph
     * */
    public int getNVertex() {
        return this.adjList.size();
    }

    /**
     * This method is used to get total number of edge in the graph
     *
     * @return number of the edge in the graph
     * */
    public int getNEdge() {
        int sum = 0;
        for (Map.Entry<T, ArrayList<Pair<T, Integer>>> entry : this.adjList.entrySet()) {
            sum += entry.getValue().size();
        }
        return sum;
    }
}
