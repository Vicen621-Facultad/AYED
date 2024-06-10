package ayed.repaso.arboles.ejercicio4;

import ayed.tp2.BTreePrinter;
import ayed.tp2.BinaryTree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class TestCodigoZigZag {

    @Test
    public void testDescifrarCodigo() {
        BinaryTree<Character> root = new BinaryTree<>('*');
        BinaryTree<Character> nodo2 = new BinaryTree<>('*');
        BinaryTree<Character> nodo3 = new BinaryTree<>('*');
        BinaryTree<Character> nodo4 = new BinaryTree<>('*');
        BinaryTree<Character> nodo5 = new BinaryTree<>('*');
        BinaryTree<Character> nodo6 = new BinaryTree<>('*');
        BinaryTree<Character> nodo7 = new BinaryTree<>('*');
        BinaryTree<Character> nodo8 = new BinaryTree<>('*');
        BinaryTree<Character> nodo9 = new BinaryTree<>('*');
        BinaryTree<Character> C = new BinaryTree<>('C');
        BinaryTree<Character> S = new BinaryTree<>('S');
        BinaryTree<Character> A = new BinaryTree<>('A');
        BinaryTree<Character> G = new BinaryTree<>('G');
        BinaryTree<Character> R = new BinaryTree<>('R');
        BinaryTree<Character> E = new BinaryTree<>('E');
        BinaryTree<Character> D = new BinaryTree<>('D');
        BinaryTree<Character> O = new BinaryTree<>('O');

        root.addLeftChild(nodo2);
        nodo2.addLeftChild(nodo3);
        nodo3.addLeftChild(C);
        nodo3.addRightChild(S);

        root.addRightChild(nodo4);
        nodo4.addLeftChild(nodo5);
        nodo5.addLeftChild(nodo6);
        nodo6.addLeftChild(nodo7);
        nodo7.addLeftChild(A);
        nodo7.addRightChild(G);
        nodo6.addRightChild(R);
        nodo5.addRightChild(E);
        nodo4.addRightChild(nodo8);
        nodo8.addLeftChild(D);
        nodo8.addRightChild(nodo9);
        nodo9.addRightChild(O);

        // Mensaje cifrado
        List<String> mensajeCifrado = Arrays.asList("101", "001", "10001", "1111", "1001", "110", "1111");

        // Decodificación
        List<Character> resultado = new CodigoZigZag().descifrarCodigo(root, mensajeCifrado);

        // Mensaje esperado: ESGORDO
        List<Character> esperado = Arrays.asList('E', 'S', 'G', 'O', 'R', 'D', 'O');

        // Verificación
        assertEquals(esperado, resultado);
    }
}
