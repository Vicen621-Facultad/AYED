package ayed.repaso.grafos.ejercicio2;

import ayed.tp5.ejercicio1.Edge;
import ayed.tp5.ejercicio1.Graph;
import ayed.tp5.ejercicio1.Vertex;

import java.util.LinkedList;
import java.util.List;

public class Estadios {

    public List<String> estadios(Graph<Estadio> mapaEstadios, Estadio estadioOrigen, int cantKm) {
        List<String> camino = new LinkedList<>();
        Vertex<Estadio> origen = mapaEstadios.search(estadioOrigen);

        dfs(mapaEstadios, origen, cantKm, new boolean[mapaEstadios.getSize()], new LinkedList<>(), camino);

        return camino;
    }

    private void dfs(Graph<Estadio> mapaEstadios, Vertex<Estadio> origen, int cantKm, boolean[] visitados, List<String> caminoActual, List<String> camino) {
        if (cantKm >= 0) {
            caminoActual.add(origen.getData().name());
            visitados[origen.getPosition()] = true;
        }

        if (cantKm <= 0) {
            if (caminoActual.size() > camino.size()) {
                camino.clear();
                camino.addAll(caminoActual);
            }
        } else {
            List<Edge<Estadio>> adyacentes = mapaEstadios.getEdges(origen);
            for (Edge<Estadio> edge : adyacentes) {
                int weight = edge.getWeight();
                Vertex<Estadio> v = edge.getTarget();

                if (!visitados[v.getPosition()])
                    dfs(mapaEstadios, v, cantKm - weight, visitados, caminoActual, camino);
            }

            caminoActual.remove(caminoActual.size() - 1);
            visitados[origen.getPosition()] = false;
        }
    }


    public record Estadio(String name, String ciudad){ }
}
