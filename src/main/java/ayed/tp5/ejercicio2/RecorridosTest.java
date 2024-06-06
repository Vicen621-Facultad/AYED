package ayed.tp5.ejercicio2;

import ayed.tp5.ejercicio1.Graph;
import ayed.tp5.ejercicio1.Vertex;
import ayed.tp5.ejercicio1.adjList.AdjListGraph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecorridosTest {

    Graph<String> graph;

    private Graph<String> createTestGraph() {
        Graph<String> graph = new AdjListGraph<>();

        // Crear vértices
        Vertex<String> a = graph.createVertex("A");
        Vertex<String> b = graph.createVertex("B");
        Vertex<String> c = graph.createVertex("C");
        Vertex<String> d = graph.createVertex("D");
        Vertex<String> e = graph.createVertex("E");

        // Conectar vértices
        graph.connect(a, b);
        graph.connect(a, c);
        graph.connect(b, d);
        graph.connect(c, e);

        return graph;
    }

    @Test
    public void testDFS() {
        Graph<String> graph = createTestGraph();
        Recorridos<String> recorridos = new Recorridos<>();

        List<String> dfsResult = recorridos.dfs(graph);

        // Verificar orden de visita
        List<String> expectedOrder = List.of("A", "B", "D", "C", "E");
        assertEquals(expectedOrder, dfsResult);
    }

    @Test
    public void testBFS() {
        Graph<String> graph = createTestGraph();
        Recorridos<String> recorridos = new Recorridos<>();

        List<String> bfsResult = recorridos.bfs(graph);

        // Verificar orden de visita
        List<String> expectedOrder = List.of("A", "B", "C", "D", "E");
        assertEquals(expectedOrder, bfsResult);
    }

    @Test
    public void testDFSDisconnectedGraph() {
        Graph<String> graph = new AdjListGraph<>();

        // Crear vértices
        Vertex<String> a = graph.createVertex("A");
        Vertex<String> b = graph.createVertex("B");
        Vertex<String> c = graph.createVertex("C");

        // Conectar vértices
        graph.connect(a, b);
        // El vértice C no está conectado

        Recorridos<String> recorridos = new Recorridos<>();
        List<String> dfsResult = recorridos.dfs(graph);

        // Verificar orden de visita
        List<String> expectedOrder = List.of("A", "B", "C");
        assertEquals(expectedOrder, dfsResult);
    }

    @Test
    public void testBFSDisconnectedGraph() {
        Graph<String> graph = new AdjListGraph<>();

        // Crear vértices
        Vertex<String> a = graph.createVertex("A");
        Vertex<String> b = graph.createVertex("B");
        Vertex<String> c = graph.createVertex("C");

        // Conectar vértices
        graph.connect(a, b);
        // El vértice C no está conectado

        Recorridos<String> recorridos = new Recorridos<>();
        List<String> bfsResult = recorridos.bfs(graph);

        // Verificar orden de visita
        List<String> expectedOrder = List.of("A", "B", "C");
        assertEquals(expectedOrder, bfsResult);
    }
}
