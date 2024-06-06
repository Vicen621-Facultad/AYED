package ayed.tp5.ejercicio3;

import ayed.tp5.ejercicio1.Edge;
import ayed.tp5.ejercicio1.Graph;
import ayed.tp5.ejercicio1.Vertex;
import ayed.tp5.ejercicio3.CaminoMinimo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Mapa {
    private final Graph<String> mapaCiudades;

    public Mapa(Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }

    /**
     * Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso de que se
     * pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).
     * @param ciudad1
     * @param ciudad2
     * @return
     */
    public List<String> devolverCamino(String ciudad1, String ciudad2) {
        boolean[] visitados = new boolean[mapaCiudades.getSize()];
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        Vertex<String> destino = mapaCiudades.search(ciudad2);
        List<String> camino = new LinkedList<>();

        if (origen != null && destino != null)
            dfs(origen, destino, visitados, camino);

        return camino;
    }

    private boolean dfs(Vertex<String> origen, Vertex<String> destino, boolean[] visitados, List<String> camino) {
        visitados[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen == destino)
            return false;

        List<Edge<String>> adyacentes = mapaCiudades.getEdges(origen);
        Iterator<Edge<String>> iter = adyacentes.iterator();
        boolean paro = false;
        while (iter.hasNext() && !paro) {
            Vertex<String> vertex = iter.next().getTarget();
            int j = vertex.getPosition();
            if (!visitados[j])
                paro = dfs(vertex, destino, visitados, camino);
        }

        if (paro)
            return false;

        camino.remove(camino.size() - 1);
        return true;
    }

    /**
     * Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
     * que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
     * vacía. (Sin tener en cuenta el combustible).
     * @param ciudad1
     * @param ciudad2
     * @param ciudades
     * @return
     */
    public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades) {
        boolean[] visitados = new boolean[mapaCiudades.getSize()];
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        Vertex<String> destino = mapaCiudades.search(ciudad2);
        List<String> camino = new LinkedList<>();

        if (origen != null && destino != null)
            dfsExcept(origen, destino, visitados, camino, ciudades);

        return camino;
    }

    public boolean dfsExcept(Vertex<String> origen, Vertex<String> destino, boolean[] visitados, List<String> camino, List<String> ciudades) {
        visitados[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen == destino)
            return false;

        List<Edge<String>> adyacentes = mapaCiudades.getEdges(origen);
        Iterator<Edge<String>> iter = adyacentes.iterator();
        boolean paro = false;
        while (iter.hasNext() && !paro) {
            Vertex<String> vertex = iter.next().getTarget();
            int j = vertex.getPosition();
            if (!visitados[j] && !ciudades.contains(vertex.getData()))
                paro = dfs(vertex, destino, visitados, camino);
        }

        if (paro)
            return false;

        camino.remove(camino.size() - 1);
        return true;
    }

    /**
     * Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
     * existe camino retorna la lista vacía. (Las rutas poseen la distancia)
     * @param ciudad1
     * @param ciudad2
     * @return
     */
    public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        Vertex<String> destino = mapaCiudades.search(ciudad2);
        CaminoMinimo caminoMinimo = new CaminoMinimo();

        if (origen != null && destino != null)
            dfsMasCorto(origen, destino, new boolean[mapaCiudades.getSize()], new LinkedList<>(), 0, new CaminoMinimo());

        return caminoMinimo.getCamino();
    }

    public void dfsMasCorto(Vertex<String> origen, Vertex<String> destino, boolean[] visitados, List<String> caminoActual, int pesoActual, CaminoMinimo caminoMinimo) {
        visitados[origen.getPosition()] = true;
        caminoActual.add(origen.getData());

        if (origen.getData().equals(destino.getData())) {
            if (pesoActual < caminoMinimo.getMinimo()) {
                caminoMinimo.setCamino(caminoActual);
                caminoMinimo.setMinimo(pesoActual);
            }
        } else {
            List<Edge<String>> edges = mapaCiudades.getEdges(origen);
            for (Edge<String> edge : edges) {
                Vertex<String> v = edge.getTarget();
                if (!visitados[v.getPosition()])
                    dfsMasCorto(v, destino, visitados, caminoActual, pesoActual + edge.getWeight(), caminoMinimo);
            }
        }

        visitados[origen.getPosition()] = false;
        caminoActual.remove(caminoActual.size() - 1);
    }

    /**
     * Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe
     * quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.
     */
    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        boolean[] visitados = new boolean[mapaCiudades.getSize()];
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        Vertex<String> destino = mapaCiudades.search(ciudad2);
        List<String> camino = new ArrayList<>();

        if (origen != null && destino != null)
            dfsSinCargaCombustible(origen, destino, visitados, camino, tanqueAuto);

        return camino;
    }

    public boolean dfsSinCargaCombustible(Vertex<String> origen, Vertex<String> destino, boolean[] visitados, List<String> camino, int tanqueAuto) {
        visitados[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (origen == destino)
            return false;

        List<Edge<String>> adyacentes = mapaCiudades.getEdges(origen);
        Iterator<Edge<String>> iter = adyacentes.iterator();
        boolean paro = false;
        while (iter.hasNext() && !paro) {
            Vertex<String> vertex = iter.next().getTarget();
            int weight = iter.next().getWeight();
            int j = vertex.getPosition();
            if (!visitados[j] && tanqueAuto - weight > 0)
                paro = dfsSinCargaCombustible(vertex, destino, visitados, camino, tanqueAuto - weight);
        }

        if (paro)
            return false;

        camino.remove(camino.size() - 1);
        return true;
    }

    public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        Vertex<String> origen = mapaCiudades.search(ciudad1);
        Vertex<String> destino = mapaCiudades.search(ciudad2);
        CaminoMinimo caminoMinimo = new CaminoMinimo();

        if (origen != null && destino != null)
            dfsConMenorCargaDeCombustible(
                    origen,
                    destino,
                    new boolean[mapaCiudades.getSize()],
                    new LinkedList<>(),
                    0,
                    caminoMinimo,
                    tanqueAuto,
                    tanqueAuto
            );

        return caminoMinimo.getCamino();
    }

    public void dfsConMenorCargaDeCombustible(Vertex<String> origen, Vertex<String> destino, boolean[] visitados, List<String> caminoActual, int cargaTanquesActual, CaminoMinimo caminoMinimo, int tanqueActual, int tanqueLleno) {
        visitados[origen.getPosition()] = true;
        caminoActual.add(origen.getData());

        if (origen.getData().equals(destino.getData())) {
            if (cargaTanquesActual < caminoMinimo.getMinimo()) {
                caminoMinimo.setMinimo(cargaTanquesActual);
                caminoMinimo.setCamino(caminoActual);
            }
        } else {
            List<Edge<String>> adyacentes = mapaCiudades.getEdges(origen);
            for (Edge<String> edge : adyacentes) {
                Vertex<String> v = edge.getTarget();
                int weight = edge.getWeight();

                if (!visitados[v.getPosition()]) {
                    if (tanqueActual - weight > 0)
                        dfsConMenorCargaDeCombustible(v, destino, visitados, caminoActual, cargaTanquesActual, caminoMinimo, tanqueActual - weight, tanqueLleno);
                    else
                        dfsConMenorCargaDeCombustible(v, destino, visitados, caminoActual, cargaTanquesActual + 1, caminoMinimo, tanqueLleno, tanqueLleno);
                }
            }
        }

        visitados[origen.getPosition()] = false;
        caminoActual.remove(caminoActual.size() - 1);
    }
}
