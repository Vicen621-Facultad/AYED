package ayed.repaso.arboles.ejercicio4;

import ayed.tp2.BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class CodigoZigZag {

    public List<Character> descifrarCodigo(BinaryTree<Character> arbol, List<String> listaDeSecuencias) {
        List<Character> ret = new LinkedList<>();

        for (String secuencia : listaDeSecuencias)
            ret.add(descifrarSecuencia(arbol, secuencia, 0));

        return ret;
    }

    private char descifrarSecuencia(BinaryTree<Character> arbol, String secuencia, int posActual) {
        if (posActual + 1 > secuencia.length()) {
            return arbol.getData();
        } else {
            char charActual = secuencia.charAt(posActual);

            if (charActual == '0') {
                return descifrarSecuencia(arbol.getLeftChild(), secuencia, posActual + 1);
            } else {
                return descifrarSecuencia(arbol.getRightChild(), secuencia, posActual + 1);
            }
        }
    }
}
