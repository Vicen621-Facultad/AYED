package ayed.tp2;

public class Transformacion {
    private final BinaryTree<Integer> arbol;

    public Transformacion(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> suma() {
        return suma(arbol);
    }

    private int sumarArbol(BinaryTree<Integer> arbol) {
        int ret = 0;

        if (arbol.isLeaf()) {
            ret += arbol.getData();
            arbol.setData(0);
            return ret;
        }

        if (arbol.hasLeftChild())
            ret += sumarArbol(arbol.getLeftChild());

        if (arbol.hasRightChild())
            ret += sumarArbol(arbol.getRightChild());

        int data = arbol.getData();
        arbol.setData(ret);
        return ret + data;
    }

    private BinaryTree<Integer> suma(BinaryTree<Integer> arbol) {
        this.sumarArbol(arbol);
        return arbol;
    }
}
