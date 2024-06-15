package ayed.repaso.grafos.ejercicio2;

import ayed.tp5.ejercicio1.Graph;
import ayed.tp5.ejercicio1.Vertex;
import ayed.tp5.ejercicio1.adjList.AdjListGraph;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestEstadios {
    @Test
    public void testEstadios() {
        Graph<Estadios.Estadio> mapaEstadios = new AdjListGraph<>();
        Vertex<Estadios.Estadio> AlBayt = mapaEstadios.createVertex(new Estadios.Estadio("Al Bayt", ""));
        Vertex<Estadios.Estadio> Lusail = mapaEstadios.createVertex(new Estadios.Estadio("Lusail", ""));
        Vertex<Estadios.Estadio> Stadium947 = mapaEstadios.createVertex(new Estadios.Estadio("947", ""));
        Vertex<Estadios.Estadio> EducationCity = mapaEstadios.createVertex(new Estadios.Estadio("Education City", ""));
        Vertex<Estadios.Estadio> AlRayyan = mapaEstadios.createVertex(new Estadios.Estadio("Al Rayyan", ""));
        Vertex<Estadios.Estadio> Khalifa = mapaEstadios.createVertex(new Estadios.Estadio("Khalifa", ""));
        Vertex<Estadios.Estadio> AlThumama = mapaEstadios.createVertex(new Estadios.Estadio("Al Thumama", ""));
        Vertex<Estadios.Estadio> AlJanoub = mapaEstadios.createVertex(new Estadios.Estadio("Al Janoub", ""));

        mapaEstadios.connect(AlBayt, Lusail, 42);
        mapaEstadios.connect(Lusail, AlBayt, 42);

        mapaEstadios.connect(Lusail, EducationCity, 24);
        mapaEstadios.connect(EducationCity, Lusail, 24);

        mapaEstadios.connect(Lusail, Stadium947, 52);
        mapaEstadios.connect(Stadium947, Lusail, 52);

        mapaEstadios.connect(EducationCity, AlRayyan, 11);
        mapaEstadios.connect(AlRayyan, EducationCity, 11);

        mapaEstadios.connect(AlRayyan, Khalifa, 8);
        mapaEstadios.connect(Khalifa, AlRayyan, 8);

        mapaEstadios.connect(Khalifa, AlThumama, 12);
        mapaEstadios.connect(AlThumama, Khalifa, 12);

        mapaEstadios.connect(AlThumama, AlJanoub, 12);
        mapaEstadios.connect(AlJanoub, AlThumama, 12);

        mapaEstadios.connect(AlJanoub, Stadium947, 19);
        mapaEstadios.connect(Stadium947, AlJanoub, 19);

        List<String> camino = new Estadios().estadios(mapaEstadios, new Estadios.Estadio("Al Bayt", ""), 100);
    }
}
