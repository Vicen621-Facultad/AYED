package ayed.repaso.arboles.ejercicio5;

import ayed.tp3.GeneralTree;

import java.util.LinkedList;
import java.util.List;

public class Parcial {
    public List<List<Character>> caminosPares(GeneralTree<Character> arbol) {
        List<List<Character>> ret = new LinkedList<>();
        caminosPares(arbol, new LinkedList<>(), ret);
        return ret;
    }

    private void caminosPares(GeneralTree<Character> arbol, List<Character> caminoActual, List<List<Character>> caminos) {
        caminoActual.add(arbol.getData());

        if (arbol.isLeaf()) {
            if (caminoActual.size() % 2 == 0)
                caminos.add(new LinkedList<>(caminoActual));
        } else {
            for (GeneralTree<Character> children : arbol.getChildren()) {
                caminosPares(children, caminoActual, caminos);
            }
        }

        caminoActual.remove(caminoActual.size() - 1);
    }
}
