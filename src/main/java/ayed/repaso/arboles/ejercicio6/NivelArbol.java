package ayed.repaso.arboles.ejercicio6;

import ayed.tp1.ejercicio8.Queue;
import ayed.tp2.BinaryTree;

public class NivelArbol {
    private final BinaryTree<Integer> arbol;

    public NivelArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> minEnNivelAB(int n) {
        BinaryTree<Integer> min = null;
        Queue<BinaryTree<Integer>> queue = new Queue<>();
        int nivel = 0;
        queue.enqueue(arbol);
        queue.enqueue(null);

        while (!queue.isEmpty()) {
            BinaryTree<Integer> nodo = queue.dequeue();

            if (nodo != null) {

                if (nivel == n && nodo.isLeaf()) {
                    if (min == null || nodo.getData() < min.getData()) {
                        min = nodo;
                    }
                }

                if (nodo.hasLeftChild())
                    queue.enqueue(nodo.getLeftChild());
                if (nodo.hasRightChild())
                    queue.enqueue(nodo.getRightChild());

            } else if (!queue.isEmpty()) {
                queue.enqueue(null);
                nivel++;
            }
        }

        return min;
    }
}
