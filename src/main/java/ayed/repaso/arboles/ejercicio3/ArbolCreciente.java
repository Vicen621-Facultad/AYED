package ayed.repaso.arboles.ejercicio3;

import ayed.tp1.ejercicio8.Queue;
import ayed.tp3.GeneralTree;

import java.util.List;

public class ArbolCreciente<T> {

    public GeneralTree<T> arbolCreciente(GeneralTree<T> arbol) {
        GeneralTree<T> mayorHijos = new GeneralTree<>(null, List.of());
        Queue<GeneralTree<T>> queue = new Queue<>();
        int level = 0;
        int currentLevel = 0;
        boolean sigo = true;
        queue.enqueue(arbol);
        queue.enqueue(null);

        while (!queue.isEmpty() && sigo) {
            GeneralTree<T> nodo = queue.dequeue();

            if (nodo != null) {
                currentLevel++;

                if (nodo.hasChildren()) {
                    List<GeneralTree<T>> childrens = nodo.getChildren();

                    if (nodo.getChildren().size() > mayorHijos.getChildren().size())
                        mayorHijos = nodo;

                    for (GeneralTree<T> children : childrens)
                        queue.enqueue(children);
                }
            } else if (!queue.isEmpty()) {
                queue.enqueue(null);
                sigo = ++level == currentLevel;
                currentLevel = 0;
            }
        }

        if (!sigo)
            mayorHijos = null;

        return mayorHijos;
    }
}
