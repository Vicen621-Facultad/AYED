package ayed.tp5.ejercicio6;

import ayed.tp5.ejercicio1.Edge;
import ayed.tp5.ejercicio1.Graph;
import ayed.tp5.ejercicio1.Vertex;

import java.util.ArrayList;
import java.util.List;

public class BuscadorDeCaminos {
    private Graph<String> bosque;

    public List<List<String>> recorridosMasSeguros() {
        List<List<String>> caminos = new ArrayList<>();
        if (!bosque.isEmpty()) {
            Vertex<String> origen = bosque.search("Casa caperucita");
            Vertex<String> destino = bosque.search("Casa abuelita");
            if (origen != null && destino != null) {
                dfs(origen, destino, caminos, new ArrayList<>(), new boolean[bosque.getSize()]);
            }
        }

        return caminos;
    }

    private void dfs(Vertex<String> origen, Vertex<String> destino, List<List<String>> caminos, List<String> caminoActual, boolean[] visitados) {
        visitados[origen.getPosition()] = true;
        caminoActual.add(origen.getData());

        if (!origen.getData().equals(destino.getData())) {
            List<Edge<String>> adyacentes = bosque.getEdges(origen);
            for (Edge<String> edge : adyacentes) {
                Vertex<String> v = edge.getTarget();
                if (!visitados[v.getPosition()] && edge.getWeight() < 5)
                    dfs(v, destino, caminos, caminoActual, visitados);
            }
        } else {
            caminos.add(new ArrayList<>(caminoActual));
        }

        visitados[origen.getPosition()] = false;
        caminoActual.remove(caminoActual.size() - 1);
    }


    public void setBosque(Graph<String> bosque) {
        this.bosque = bosque;
    }
}
