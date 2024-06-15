package ayed.tp5.ejercicio2;

import ayed.tp1.ejercicio8.Queue;
import ayed.tp5.ejercicio1.Edge;
import ayed.tp5.ejercicio1.Graph;
import ayed.tp5.ejercicio1.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Recorridos<T> {

    public List<T> dfs(Graph<T> graph) {
        boolean[] visited = new boolean[graph.getSize()];
        List<T> result = new ArrayList<>();
        for (int i = 0; i < graph.getSize(); i++) {
            if (!visited[i])
                dfs(graph, i, visited, result);
        }
        return result;
    }

    private void dfs(Graph<T> graph, int vertexPos, boolean[] visited, List<T> result) {
        visited[vertexPos] = true;
        Vertex<T> vertex = graph.getVertex(vertexPos);
        List<Edge<T>> adjacent = graph.getEdges(vertex);

        result.add(vertex.getData());

        for (Edge<T> edge : adjacent) {
            int adjacentPos = edge.getTarget().getPosition();
            if (!visited[adjacentPos])
                dfs(graph, adjacentPos, visited, result);
        }
    }

    public List<T> bfs(Graph<T> graph) {
        boolean[] visited = new boolean[graph.getSize()];
        List<T> result = new ArrayList<>();
        for (int i = 0; i < graph.getSize(); i++) {
            if (!visited[i])
                bfs(graph, i, visited, result);
        }

        return result;
    }

    private void bfs(Graph<T> graph, int vertexPos, boolean[] visited, List<T> result) {
        Queue<Vertex<T>> queue = new Queue<>();
        queue.enqueue(graph.getVertex(vertexPos));
        visited[vertexPos] = true;

        while (!queue.isEmpty()) {
            Vertex<T> vertex = queue.dequeue();
            result.add(vertex.getData());
            for (Edge<T> adjacent : graph.getEdges(vertex)) {
                int adjacentPos = adjacent.getTarget().getPosition();
                if (!visited[adjacentPos]) {
                    visited[adjacentPos] = true;
                    queue.enqueue(adjacent.getTarget());
                }
            }
        }
    }
}
