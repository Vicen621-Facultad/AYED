package ayed.repaso.arboles.ejercicio3;

import ayed.tp3.GeneralTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class TestArbolCreciente {
    @Test
    public void testCrecienteTree() {
        // Nivel 0
        GeneralTree<Integer> node0 = new GeneralTree<>(0);

        // Nivel 1
        GeneralTree<Integer> node1a = new GeneralTree<>(1);
        GeneralTree<Integer> node1b = new GeneralTree<>(2);

        node0.setChildren(List.of(node1a, node1b));

        // Nivel 2
        GeneralTree<Integer> node2a = new GeneralTree<>(3);
        GeneralTree<Integer> node2b = new GeneralTree<>(4);
        GeneralTree<Integer> node2c = new GeneralTree<>(5);

        node1b.setChildren(List.of(node2a, node2b, node2c));

        // Verificamos si el árbol es creciente
        GeneralTree<Integer> result = new ArbolCreciente<Integer>().arbolCreciente(node0);

        // Esperamos que el árbol sea creciente y que el nodo con más hijos sea node1b (con 3 hijos)
        assertNotNull(result);
        assertEquals(node1b.getData(), result.getData());
    }

    @Test
    public void testNonCrecienteTree() {
        // Nivel 0
        GeneralTree<Integer> node0 = new GeneralTree<>(0);

        // Nivel 1
        GeneralTree<Integer> node1a = new GeneralTree<>(1);
        GeneralTree<Integer> node1b = new GeneralTree<>(2);

        node0.setChildren(Arrays.asList(node1a, node1b));

        // Nivel 2 - Incorrecto (más de 3 nodos en el nivel 2)
        GeneralTree<Integer> node2a = new GeneralTree<>(3);
        GeneralTree<Integer> node2b = new GeneralTree<>(4);
        GeneralTree<Integer> node2c = new GeneralTree<>(5);
        GeneralTree<Integer> node2d = new GeneralTree<>(6);

        node1a.setChildren(Arrays.asList(node2a));
        node1b.setChildren(Arrays.asList(node2b, node2c, node2d));

        // Verificamos si el árbol es creciente
        GeneralTree<Integer> result = new ArbolCreciente<Integer>().arbolCreciente(node0);

        // Esperamos que el árbol no sea creciente y que el resultado sea null
        assertNull(result);
    }
}
