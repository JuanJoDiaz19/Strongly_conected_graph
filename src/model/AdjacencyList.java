package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AdjacencyList<T> implements IGraph<T> {
    private ArrayList<GraphNode<T>> adjacencyList;
    int time;

    public AdjacencyList() {
        adjacencyList = new ArrayList<>();
    }

    @Override
    public void addVertex(T element) {
        adjacencyList.add(new GraphNode<>(element, new ArrayList<>()));
    }
    @Override
    public void addEdge(T elementA, T elementB) {
        for (GraphNode<T> g: adjacencyList) {
            if(g.getValue().equals(elementA)) {
                for (GraphNode<T> f: adjacencyList) {
                    if(f.getValue().equals(elementB)){
                        g.getAdjacentNodes().add(f);
                    }
                }

            }
        }
    }
    public int DFS(){
        for (GraphNode<T> graphNode: adjacencyList) {
            graphNode.setPrevious(null);
            graphNode.setColor(0);
            graphNode.setTime(0);
        }
        int trees = 0;
        int time = 0;
        for (GraphNode<T> graphNode: adjacencyList) {
            if(graphNode.getColor() == 0) {
                trees++;
                DFSVisit(graphNode);
            }
        }
        return trees;
    }
    public void DFSVisit(GraphNode<T> graphNode){
        time++;
        graphNode.setTime(time);
        graphNode.setColor(1);
        for (GraphNode<T> adjacencyNode: graphNode.getAdjacentNodes()) {
            if(adjacencyNode.getColor() == 0) {
                adjacencyNode.setPrevious(graphNode);
                DFSVisit(adjacencyNode);
            }
        }
        graphNode.setColor(2);
        time++;
        graphNode.setTime(time);
    }

    public GraphNode<T> searchNode(T element) {
        for (GraphNode<T> g: adjacencyList) {
            if(g.getValue().equals(element)){
                return g;
            }
        }
        return null;
    }
    @Override
    public boolean BFS(T element) {
        GraphNode <T> graphNode = searchNode(element);
        for (GraphNode<T> adjacentNode: adjacencyList) {
            adjacentNode.setColor(0);
            adjacentNode.setTime(Integer.MAX_VALUE);
            adjacentNode.setPrevious(null);
        }
        graphNode.setColor(1);
        graphNode.setTime(0);
        graphNode.setPrevious(null);
        Queue<GraphNode<T>> graphNodes = new LinkedList<>();
        graphNodes.add(graphNode);
        while (!graphNodes.isEmpty()){
            GraphNode<T> u = graphNodes.poll();
            for (GraphNode<T> dequeue: u.getAdjacentNodes()) {
                if(dequeue.getColor() == 0) {
                    dequeue.setColor(1);
                    dequeue.setTime(dequeue.getTime()+1);
                    dequeue.setPrevious(u);
                    graphNodes.add(dequeue);
                }
            }
            u.setColor(3);
        }
        for (GraphNode<T> g: adjacencyList) {
            if(g.getColor() == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isStronglyConnected() {
        for (GraphNode<T> node: adjacencyList) {
            if (!BFS(node.getValue())) {
                return false;
            }
        }
        return true;
    }

}
