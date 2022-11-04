package ui;

import model.AdjacencyList;
import model.IGraph;


public class Main {
    public static void main(String[] args) {
        IGraph<String> graph = new AdjacencyList<>();
        graph.addVertex("U");
        graph.addVertex("V");
        graph.addVertex("X");
        graph.addVertex("Y");
        graph.addVertex("Z");

        graph.addEdge("U", "X");
        graph.addEdge("X", "Y");
        graph.addEdge("Y", "Z");
        graph.addEdge("Z", "Y");
        graph.addEdge("Y", "V");
        graph.addEdge("V", "U");

        int numberOfTrees = graph.DFS();
        System.out.println("El numero de arboles que hay en el grafo es: " + numberOfTrees);
        System.out.println("Puedo ir de Y a V?: " + graph.BFS("Y"));
        System.out.println("El grafo es fuertemente conexo?: " + graph.isStronglyConnected());
    }
}
