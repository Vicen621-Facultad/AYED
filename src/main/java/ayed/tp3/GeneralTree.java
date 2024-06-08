package ayed.tp3;

import ayed.tp1.ejercicio8.Queue;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T> {

    private T data;
    private List<GeneralTree<T>> children = new LinkedList<>();

    public GeneralTree() {

    }

    public GeneralTree(T data) {
        this.data = data;
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this(data);
        this.children = children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }

    public void setChildren(List<GeneralTree<T>> children) {
        if (children != null)
            this.children = children;
    }

    public void addChild(GeneralTree<T> child) {
        this.getChildren().add(child);
    }

    public void addChilds(GeneralTree<T>... childs) {
        for (GeneralTree<T> child : childs)
            this.addChild(child);
    }

    public boolean isLeaf() {
        return !this.hasChildren();
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    public boolean isEmpty() {
        return this.data == null && !this.hasChildren();
    }

    public void removeChild(GeneralTree<T> child) {
        if (this.hasChildren())
            children.remove(child);
    }

    /**
     * Devuelve la altura del árbol. La altura de un arbol es la longitud del camino
     * más largo desde la raíz hasta una hoja.
     *
     * @return La altura del arbol
     */
    public int altura() {
        if (this.hasChildren()) {
            int max = -1;
            for (GeneralTree<T> children : this.getChildren())
                max = Math.max(children.altura(), max);

            return max + 1;
        }

        return 0;
    }

    /**
     * Devuelve la profundidad o nivel del dato en el árbol. El nivel de un nodo es
     * la longitud del único camino de la raíz al nodo
     *
     * @param dato El dato a buscar
     * @return El nivel del dato en el arbol, -1 si el dato no se encuentra en el
     * arbol
     */
    public int nivel(T dato) {
        if (this.getData().equals(dato))
            return 0;

        if (this.hasChildren()) {
            int nivelChild = -1;
            for (GeneralTree<T> child : this.getChildren()) {
                nivelChild = child.nivel(dato);
                if (nivelChild != -1)
                    return nivelChild + 1;
            }
        }

        return -1;
    }

    /**
     * Devuelve el ancho del arbol. El ancho de un arbol se define como la cantidad
     * de nodos que se encuentran en el nivel que posee la mayor cantidad de nodos.
     *
     * @return El ancho del arbol
     */
    public int ancho() {
        int max = -1;
        GeneralTree<T> aux;

        Queue<GeneralTree<T>> queue = new Queue<>();
        queue.enqueue(this);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currentLevel = 0;

            while (size != 0) {
                currentLevel++;
                aux = queue.dequeue();

                for (GeneralTree<T> child : aux.getChildren())
                    queue.enqueue(child);

                size--;
            }

            max = Math.max(max, currentLevel);
        }
        return max;
    }

    /**
     * Este metodo se fija si el valor a es ancestro de b. Se dice que un nodo n es
     * ancestro de m si existe un camino desde n hasta m.
     *
     * @param a El ancestro
     * @param b El descendiente
     * @return True si a es ancestro de b, false en caso contrario
     */
    public boolean esAncestro(T a, T b) {
        if (this.getData().equals(a))
            return this.isChild(b);


        if (this.hasChildren()) {
            for (GeneralTree<T> children : this.getChildren()) {
                if (children.esAncestro(a, b))
                    return true;
            }
        }

        return false;
    }

    private boolean isChild(T data) {
        Queue<GeneralTree<T>> queue = new Queue<>();
        queue.enqueue(this);

        GeneralTree<T> aux;
        while (!queue.isEmpty()) {
            aux = queue.dequeue();
            if (aux.getData().equals(data))
                return true;

            if (aux.hasChildren())
                for (GeneralTree<T> children : aux.getChildren())
                    queue.enqueue(children);
        }

        return false;
    }
}















