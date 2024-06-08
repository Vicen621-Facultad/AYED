package ayed.tp5.ejercicio4;

import ayed.tp5.ejercicio1.Graph;
import ayed.tp5.ejercicio1.Vertex;
import ayed.tp5.ejercicio1.adjList.AdjListGraph;
import ayed.tp5.ejercicio3.Mapa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class VisitaOsloTest {
    private Graph<String> graph;

    @BeforeEach
    public void setUp() {
        graph = new AdjListGraph<>();
        // Aquí deberías inicializar el grafo con vertices y aristas para las pruebas
        Vertex<String> ayuntamiento = graph.createVertex("Ayuntamiento");
        Vertex<String> tigre = graph.createVertex("El tigre");
        Vertex<String> opera = graph.createVertex("La opera");
        Vertex<String> akershus = graph.createVertex("Fortaleza Akershus");
        Vertex<String> munch = graph.createVertex("Museo Munch");
        Vertex<String> parqueBotanico = graph.createVertex("Parque Botanico");
        Vertex<String> galeriaNacional = graph.createVertex("Galeria Nacional");
        Vertex<String> parqueVigeland = graph.createVertex("Parque vigeland");
        Vertex<String> holmenkollen = graph.createVertex("Holmenkollen");
        Vertex<String> folkMuseum = graph.createVertex("FolkMuseum");
        Vertex<String> fram = graph.createVertex("Museo Fram");
        Vertex<String> barcoPolar = graph.createVertex("Museo del barco polar");
        Vertex<String> vikingo = graph.createVertex("Museo Vikingo");
        Vertex<String> palacioReal = graph.createVertex("Palacio Real");
        Vertex<String> akkerBrigge = graph.createVertex("Akker Brigge");

        graph.connect(ayuntamiento, tigre, 15);
        graph.connect(ayuntamiento, parqueBotanico, 10);
        graph.connect(ayuntamiento, palacioReal, 5);
        graph.connect(ayuntamiento, akkerBrigge, 20);

        graph.connect(tigre, opera, 5);
        graph.connect(tigre, munch, 15);

        graph.connect(opera, akershus, 10);

        graph.connect(munch, parqueBotanico, 1);

        graph.connect(parqueBotanico, galeriaNacional, 15);

        graph.connect(galeriaNacional, parqueVigeland, 10);

        graph.connect(parqueVigeland, holmenkollen, 30);
        graph.connect(parqueVigeland, folkMuseum, 20);

        graph.connect(folkMuseum, fram, 5);
        graph.connect(folkMuseum, palacioReal, 5);
        graph.connect(folkMuseum, akkerBrigge, 30);

        graph.connect(akkerBrigge, vikingo, 30);

        graph.connect(fram, barcoPolar, 5);

        graph.connect(barcoPolar, vikingo, 5);
    }

    @Test
    public void testVisitaOsloPaseoEnBici() {
        VisitaOslo oslo = new VisitaOslo();
        List<String> camino = oslo.paseoEnBici(graph, "Museo Vikingo", 120, Arrays.asList("Akker Brigge", "Palacio Real"));
        List<String> expected = Arrays.asList(
                "Ayuntamiento", "El tigre", "Museo Munch", "Parque Botanico",
                "Galeria Nacional", "Parque vigeland", "FolkMuseum", "Museo Fram",
                "Museo del barco polar", "Museo Vikingo"
        );
        Assertions.assertEquals(expected, camino);
    }
}
