package ayed.tp5.ejercicio6;

import ayed.tp5.ejercicio1.Graph;
import ayed.tp5.ejercicio1.Vertex;
import ayed.tp5.ejercicio1.adjList.AdjListGraph;
import ayed.tp5.ejercicio1.adjList.AdjListVertex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestBuscadorDeCaminos {

    @Test
    public void test_buscador_de_caminos() {
        Graph<String> bosque = new AdjListGraph<>();
        Vertex<String> casaCaperucita = bosque.createVertex("Casa caperucita");
        Vertex<String> claro1 = bosque.createVertex("Claro 1");
        Vertex<String> claro2 = bosque.createVertex("Claro 2");
        Vertex<String> claro3 = bosque.createVertex("Claro 3");
        Vertex<String> claro4 = bosque.createVertex("Claro 4");
        Vertex<String> claro5 = bosque.createVertex("Claro 5");
        Vertex<String> casaAbuelita = bosque.createVertex("Casa abuelita");

        bosque.connect(casaCaperucita, claro3, 4);
        bosque.connect(casaCaperucita, claro1, 3);
        bosque.connect(casaCaperucita, claro2, 4);
        bosque.connect(claro3, claro5, 15);
        bosque.connect(claro1, claro5, 3);
        bosque.connect(claro2, claro5, 11);
        bosque.connect(claro2, claro1, 4);
        bosque.connect(claro2, claro4, 10);
        bosque.connect(claro5, casaAbuelita, 4);
        bosque.connect(claro4, casaAbuelita, 9);

        BuscadorDeCaminos bdc = new BuscadorDeCaminos();
        bdc.setBosque(bosque);
        List<List<String>> caminos = bdc.recorridosMasSeguros();
        assertEquals(2, caminos.size());
    }
}
