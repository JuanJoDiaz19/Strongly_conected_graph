package model;

import java.util.ArrayList;

public class GraphNode<T> {
    private T value;
    private ArrayList<GraphNode<T>> adjacentNodes;
    private int color;
    private GraphNode<T> previous;
    private int time;

    public GraphNode(T value, ArrayList<GraphNode<T>> adjacentNodes) {
        this.value = value;
        this.adjacentNodes = adjacentNodes;
        color = 0;
    }
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ArrayList<GraphNode<T>> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(ArrayList<GraphNode<T>> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public GraphNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(GraphNode<T> previous) {
        this.previous = previous;
    }

    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
}
