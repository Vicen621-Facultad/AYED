package ayed.repaso.grafos.ejercicio1;

import ayed.tp5.ejercicio1.Edge;
import ayed.tp5.ejercicio1.Graph;
import ayed.tp5.ejercicio1.Vertex;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Parcial {

    public List<Ciudad> resolver(Graph<Ciudad> ciudades, Ciudad origen, Ciudad destino) {
        List<Ciudad> camino = new LinkedList<>();

        if (!ciudades.isEmpty()) {
            Vertex<Ciudad> vOrigen = ciudades.search(origen);
            Vertex<Ciudad> vDestino = ciudades.search(destino);

            if (vOrigen != null && vDestino != null)
                dfs(ciudades, vOrigen, vDestino, camino, new boolean[ciudades.getSize()]);
        }
        return camino;
    }

    private boolean dfs(Graph<Ciudad> ciudades, Vertex<Ciudad> origen, Vertex<Ciudad> destino, List<Ciudad> camino, boolean[] visitados) {
        camino.add(origen.getData());
        visitados[origen.getPosition()] = true;

        if (origen.getData().equals(destino.getData()))
            return true;

        boolean paro = false;
        List<Edge<Ciudad>> adyacentes = ciudades.getEdges(origen);
        Iterator<Edge<Ciudad>> iter = adyacentes.iterator();
        while (iter.hasNext() && !paro) {
            Edge<Ciudad> edge = iter.next();
            Vertex<Ciudad> v = edge.getTarget();

            if (!visitados[v.getPosition()] && v.getData().fase() != 1) {
                paro = dfs(ciudades, v, destino, camino, visitados);
            }
        }

        if (!paro)
            camino.remove(camino.size() - 1);

        return paro;
    }

    public record Ciudad(String nombre, int fase) { }
}
