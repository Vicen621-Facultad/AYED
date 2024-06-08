package ayed.tp2;

public class ParcialArboles {
    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public ParcialArboles() {
        super();
    }

    public boolean isLeftTree(int num) {
        BinaryTree<Integer> node = foundNode(arbol, num);
        if (node == null) {
            System.out.println("Node not found");
            return false;
        }

        int leftOrphans = -1;
        int rightOrphans = -1;

        if (node.hasLeftChild())
            leftOrphans = countOrphans(node.getLeftChild());

        if (node.hasRightChild())
            rightOrphans = countOrphans(node.getRightChild());

        return leftOrphans > rightOrphans;
    }

    /**
     * Cuento los hijos huerfanos de un arbol
     *
     * @param root El arbol en el cual contar
     * @return La cantidad de hijos huerfanos en el arbol
     */
    private int countOrphans(BinaryTree<Integer> root) {
        // Caso 1.
        if (root.isLeaf())
            return 0;

        int count = 0;
        if (root.hasLeftChild())
            // Caso 3.
            // Caso 4.
            count += countOrphans(root.getLeftChild());
        else
            // Caso 2.
            count++;

        if (root.hasRightChild())
            // Caso 2.
            // Caso 4.
            count += countOrphans(root.getRightChild());
        else
            // Caso 3.
            count++;

        return count;
    }

    /**
     * Busca el nodo con el numero dado dentro del arbol
     *
     * @param root El arbol en el cual buscar
     * @param num  El dato que contiene el nodo buscado
     * @return El arbol si lo encuentra, null en caso contrario
     */
    private BinaryTree<Integer> foundNode(BinaryTree<Integer> root, int num) {
        if (root.getData() == num)
            return root;

        BinaryTree<Integer> node = null;

        if (root.hasLeftChild())
            node = foundNode(root.getLeftChild(), num);

        // Devuelvo antes ya que si no sobreescribo con lo del hijo derecho
        if (node != null)
            return node;

        if (root.hasRightChild())
            node = foundNode(root.getRightChild(), num);

        return node;
    }

    /*
     * 1. Que no coincidan (false)
     * 2. que se termine el arbol1 (true)
     * 3. Que haya un hijo en el arbol1 que no sea en el arbol2 (false)
     */
    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        if (arbol1.getData() != arbol2.getData())
            return false;

        if (arbol1.isLeaf())
            return true;

        if (arbol1.hasLeftChild() && !arbol2.hasLeftChild())
            return false;

        if (arbol1.hasRightChild() && !arbol2.hasRightChild())
            return false;

        boolean right = true;
        boolean left = true;

        if (arbol1.hasRightChild() && arbol2.hasRightChild())
            right = esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());

        if (arbol1.hasLeftChild() && arbol2.hasLeftChild())
            left = esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());

        return right && left;
    }

    public BinaryTree<SumDif> sumAndDif(BinaryTree<Integer> arbol) {
        BinaryTree<SumDif> sumDif = new BinaryTree<>();
        sumAndDif(arbol, sumDif, 0, 0);
        return sumDif;
    }

    private void sumAndDif(BinaryTree<Integer> arbol, BinaryTree<SumDif> sumDif, int sum, int dif) {
        SumDif data = new SumDif(arbol.getData() + sum, arbol.getData() - dif);
        sumDif.setData(data);

        if (arbol.hasLeftChild()) {
            BinaryTree<SumDif> node = new BinaryTree<>();
            sumAndDif(arbol.getLeftChild(), node, data.getSum(), arbol.getData());
            sumDif.addLeftChild(node);
        }

        if (arbol.hasRightChild()) {
            BinaryTree<SumDif> node = new BinaryTree<>();
            sumAndDif(arbol.getRightChild(), node, data.getSum(), arbol.getData());
            sumDif.addRightChild(node);
        }
    }

    public static class SumDif {
        private int sum;
        private int dif;

        public SumDif(int sum, int dif) {
            this.sum = sum;
            this.dif = dif;
        }

        public void sum(int sum) {
            this.sum += sum;
        }

        public void dif(int dif) {
            this.dif -= dif;
        }

        public int getSum() {
            return this.sum;
        }

        public int getDif() {
            return this.dif;
        }
    }
}