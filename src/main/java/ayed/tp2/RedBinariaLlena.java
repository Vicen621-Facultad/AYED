package ayed.tp2;

public class RedBinariaLlena {
    private final BinaryTree<Integer> arbol;

    public RedBinariaLlena(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public int retardoReenvio() {
        return retardoReenvio(arbol);
    }

    public int retardoReenvio(BinaryTree<Integer> arbol) {
        if (arbol.isLeaf())
            return arbol.getData();

        int left = 0, right = 0;

        if (arbol.hasLeftChild())
            left = retardoReenvio(arbol.getLeftChild());

        if (arbol.hasRightChild())
            right = retardoReenvio(arbol.getRightChild());

        return Math.max(left, right) + arbol.getData();
    }
}
