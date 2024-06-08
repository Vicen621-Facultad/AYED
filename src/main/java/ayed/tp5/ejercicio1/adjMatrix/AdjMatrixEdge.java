package ayed.tp5.ejercicio1.adjMatrix;

import ayed.tp5.ejercicio1.Edge;
import ayed.tp5.ejercicio1.Vertex;

public class AdjMatrixEdge<T> implements Edge<T> {
    private final Vertex<T> target;
    private final int weight;

    /**
     * Constructor de las aristas.  Solo se crean desde el grafo.
     */
    AdjMatrixEdge(Vertex<T> target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    @Override
    public Vertex<T> getTarget() {
        return target;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}
