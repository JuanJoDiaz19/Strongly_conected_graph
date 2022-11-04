package model;

public interface IGraph<T> {
    public void addVertex(T element);
    public void addEdge(T elementA, T elementB);
    public boolean isStronglyConnected();
    public int DFS();
    public boolean BFS(T element);
}
