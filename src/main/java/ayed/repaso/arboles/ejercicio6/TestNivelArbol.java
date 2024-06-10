package ayed.repaso.arboles.ejercicio6;

import ayed.tp2.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestNivelArbol {

    @Test
    public void TestMinEnNivelAB() {
        BinaryTree<Integer> root = new BinaryTree<>(2);
        BinaryTree<Integer> siete = new BinaryTree<>(7);
        BinaryTree<Integer> cinco = new BinaryTree<>(5);
        BinaryTree<Integer> dos = new BinaryTree<>(2);
        BinaryTree<Integer> seis = new BinaryTree<>(6);
        BinaryTree<Integer> nueve = new BinaryTree<>(9);
        BinaryTree<Integer> cinco2 = new BinaryTree<>(5);
        BinaryTree<Integer> once = new BinaryTree<>(11);
        BinaryTree<Integer> cuatro = new BinaryTree<>(4);

        root.addLeftChild(siete);
        root.addRightChild(cinco);

        siete.addLeftChild(dos);
        siete.addRightChild(seis);

        seis.addLeftChild(cinco2);
        seis.addRightChild(once);

        cinco.addRightChild(nueve);
        nueve.addLeftChild(cuatro);

        NivelArbol nivelArbol = new NivelArbol(root);

        assertNull(nivelArbol.minEnNivelAB(1));
        assertEquals(2, nivelArbol.minEnNivelAB(2).getData());
        assertEquals(4, nivelArbol.minEnNivelAB(3).getData());
    }
}
