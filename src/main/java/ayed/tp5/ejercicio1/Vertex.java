package ayed.tp5.ejercicio1;

public interface Vertex<T> {
	
	/**
	 * Retorna el dato del vértice.
	 * 
	 * @return
	 */
	public T getData();

	/**
	 * Reemplaza el dato del vértice.
	 * 
	 * @param data
	 */
	public void setData(T data);

	/**
	 * Retorna la posición del vértice en el grafo.
	 * 
	 * @return
	 */
	public int getPosition();
}