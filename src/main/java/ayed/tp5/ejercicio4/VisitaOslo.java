package ayed.tp5.ejercicio4;

import ayed.tp5.ejercicio1.Graph;
import ayed.tp5.ejercicio1.Vertex;

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
        List<String> camino = new LinkedList<>();


        return camino;
    }
}
