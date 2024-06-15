package ayed.repaso.arboles.ejercicio11;

import ayed.tp3.GeneralTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMayorPostOrden {
    @Test
    public void testMayorPostOrden() {
        GeneralTree<Integer> root = new GeneralTree<>(2);
        GeneralTree<Integer> siete = new GeneralTree<>(7);
        GeneralTree<Integer> cinco = new GeneralTree<>(5);
        GeneralTree<Integer> vy2 = new GeneralTree<>(22);
        GeneralTree<Integer> dos = new GeneralTree<>(2);
        GeneralTree<Integer> seis = new GeneralTree<>(6);
        GeneralTree<Integer> nueve = new GeneralTree<>(9);
        GeneralTree<Integer> veinte = new GeneralTree<>(20);
        GeneralTree<Integer> uno = new GeneralTree<>(1);
        GeneralTree<Integer> tres = new GeneralTree<>(3);
        GeneralTree<Integer> uno1 = new GeneralTree<>(1);
        GeneralTree<Integer> cuatro = new GeneralTree<>(4);
        GeneralTree<Integer> ocho = new GeneralTree<>(8);
        GeneralTree<Integer> vy22 = new GeneralTree<>(22);
        GeneralTree<Integer> nueve1 = new GeneralTree<>(9);

        root.addChilds(siete, cinco, vy2);
        siete.addChilds(dos, seis);
        cinco.addChilds(nueve);
        vy2.addChilds(veinte, uno);
        seis.addChilds(tres, uno1);
        nueve.addChilds(cuatro);
        uno.addChilds(ocho, vy22, nueve1);

        Assertions.assertEquals(22, new MayorPostOrden().mayorPostOrden(root));
    }
}
