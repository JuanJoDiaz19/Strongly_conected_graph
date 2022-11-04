package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyListTest {
    private IGraph<String> graph;
    @Test
    public void test1() {
        graph = new AdjacencyList<>();
        //Adding the nodes in the graph
        graph.addVertex("U");
        graph.addVertex("V");
        graph.addVertex("X");
        graph.addVertex("Y");
        graph.addVertex("Z");
        //Adding the edges in the graph
        graph.addEdge("U", "X");
        graph.addEdge("X", "Y");
        graph.addEdge("Y", "Z");
        graph.addEdge("Z", "Y");
        graph.addEdge("Y", "V");
        graph.addEdge("V", "U");
        assertTrue(graph.isStronglyConnected());
    }
    @Test
    public void test2() {
        graph = new AdjacencyList<>();

        //Adding the nodes in the graph
        graph.addVertex("U");
        graph.addVertex("V");
        graph.addVertex("X");
        graph.addVertex("Y");
        graph.addVertex("Z");
        //Adding the edges in the graph
        graph.addEdge("U", "X");
        graph.addEdge("X", "Y");
        graph.addEdge("Y", "Z");
        graph.addEdge("Z", "Y");
        //graph.addEdge("Y", "V");
        graph.addEdge("V", "U");
        assertFalse(graph.isStronglyConnected());
    }
    @Test
    public void test3() {
        graph = new AdjacencyList<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("C", "B");

        assertFalse(graph.isStronglyConnected());

    }
}