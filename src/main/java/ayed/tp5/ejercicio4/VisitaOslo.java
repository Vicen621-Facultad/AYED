package ayed.tp5.ejercicio4;

import ayed.tp5.ejercicio1.Edge;
import ayed.tp5.ejercicio1.Graph;
import ayed.tp5.ejercicio1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VisitaOslo {
    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> luagresRestringidos) {
        boolean[] visitados = new boolean[lugares.getSize()];

        for (String lugarRestringido : luagresRestringidos) {
            Vertex<String> v = lugares.search(lugarRestringido);
            if (v != null) {
                visitados[v.getPosition()] = true;
            }
        }
        Vertex<String> dest = lugares.search(destino);
        Vertex<String> origen = lugares.search("Ayuntamiento");
        List<String> camino = new LinkedList<>();

        if (dest != null)
            dfsPaseEnBici(lugares, origen, dest, maxTiempo, camino, visitados);

        return camino;
    }

    private boolean dfsPaseEnBici(Graph<String> lugares, Vertex<String> origen, Vertex<String> destino, int maxTiempo, List<String> camino, boolean[] visitados) {
        visitados[origen.getPosition()] = true;
        camino.add(origen.getData());

        if (origen.getData().equals(destino.getData()))
            return true;

        boolean paro = false;
        List<Edge<String>> adyacentes = lugares.getEdges(origen);
        Iterator<Edge<String>> iter = adyacentes.iterator();
        while (iter.hasNext() && !paro) {
            Edge<String> edge = iter.next();
            Vertex<String> vertex = edge.getTarget();
            int weight = edge.getWeight();
            int j = vertex.getPosition();

            if (!visitados[j] && maxTiempo - weight >= 0)
                paro = dfsPaseEnBici(lugares, vertex, destino, maxTiempo - weight, camino, visitados);
        }

        if (!paro)
            camino.remove(camino.size() - 1);

        return paro;
    }
}
