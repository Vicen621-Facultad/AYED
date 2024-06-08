package ayed.tp5.ejercicio3;

import ayed.tp5.ejercicio1.Graph;
import ayed.tp5.ejercicio1.Vertex;
import ayed.tp5.ejercicio1.adjList.AdjListGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapaTest {

    private Mapa mapa;

    @BeforeEach
    public void setUp() {
        Graph<String> graph = new AdjListGraph<>();
        // Aquí deberías inicializar el grafo con vertices y aristas para las pruebas
        Vertex<String> A = graph.createVertex("A");
        Vertex<String> B = graph.createVertex("B");
        Vertex<String> C = graph.createVertex("C");
        Vertex<String> D = graph.createVertex("D");
        Vertex<String> E = graph.createVertex("E");

        graph.connect(A, B, 10);
        graph.connect(A, C, 15);
        graph.connect(B, D, 12);
        graph.connect(C, E, 10);
        graph.connect(D, E, 2);
        graph.connect(D, C, 1);

        mapa = new Mapa(graph);
    }

    @Test
    public void testDevolverCamino() {
        List<String> camino = mapa.devolverCamino("A", "E");
        List<String> expected = Arrays.asList("A", "B", "D", "E");
        assertEquals(expected, camino);
    }

    @Test
    public void testDevolverCaminoInexistente() {
        List<String> camino = mapa.devolverCamino("A", "F");
        assertTrue(camino.isEmpty());
    }

    @Test
    public void testDevolverCaminoExceptuando() {
        List<String> camino = mapa.devolverCaminoExceptuando("A", "E", List.of("B"));
        List<String> expected = Arrays.asList("A", "C", "E");
        assertEquals(expected, camino);
    }

    @Test
    public void testDevolverCaminoExceptuandoInexistente() {
        List<String> camino = mapa.devolverCaminoExceptuando("A", "E", Arrays.asList("B", "C"));
        assertTrue(camino.isEmpty());
    }

    @Test
    public void testCaminoMasCorto() {
        List<String> camino = mapa.caminoMasCorto("A", "E");
        List<String> expected = Arrays.asList("A", "B", "D", "E");
        assertEquals(expected, camino);
    }

    @Test
    public void testCaminoMasCortoInexistente() {
        List<String> camino = mapa.caminoMasCorto("A", "F");
        assertTrue(camino.isEmpty());
    }

    @Test
    public void testCaminoSinCargarCombustible() {
        List<String> camino = mapa.caminoSinCargarCombustible("A", "E", 25);
        List<String> expected = Arrays.asList("A", "B", "D", "E");
        assertEquals(expected, camino);
    }

    @Test
    public void testCaminoSinCargarCombustibleInexistente() {
        List<String> camino = mapa.caminoSinCargarCombustible("A", "E", 5);
        assertTrue(camino.isEmpty());
    }

    @Test
    public void testCaminoConMenorCargaDeCombustible() {
        List<String> camino = mapa.caminoConMenorCargaDeCombustible("A", "E", 12);
        List<String> expected = Arrays.asList("A", "B", "D", "E");
        assertEquals(expected, camino);
    }
}
