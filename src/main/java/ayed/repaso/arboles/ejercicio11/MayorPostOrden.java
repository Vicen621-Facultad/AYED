package ayed.repaso.arboles.ejercicio11;

import ayed.tp3.GeneralTree;

public class MayorPostOrden {

    public int mayorPostOrden(GeneralTree<Integer> arbol) {
        int max = -9999;

        if (arbol.hasChildren()) {
            for (GeneralTree<Integer> child : arbol.getChildren()) {
                int mayorHijos = mayorPostOrden(child);
                if (mayorHijos > max)
                    max = mayorHijos;
            }
        }

        if (arbol.getData() > max)
            max = arbol.getData();

        return max;
    }
}
