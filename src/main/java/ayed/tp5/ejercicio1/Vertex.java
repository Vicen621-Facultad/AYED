package ayed.tp5.ejercicio1;

public interface Vertex<T> {

    /**
     * Retorna el dato del vértice.
     *
     * @return
     */
    T getData();

    /**
     * Reemplaza el dato del vértice.
     *
     * @param data
     */
    void setData(T data);

    /**
     * Retorna la posición del vértice en el grafo.
     *
     * @return
     */
    int getPosition();
}
