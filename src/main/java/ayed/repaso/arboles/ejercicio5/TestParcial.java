package ayed.repaso.arboles.ejercicio5;

import ayed.tp3.GeneralTree;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestParcial {

    @Test
    public void TestCaminosPares() {
        GeneralTree<Character> A = new GeneralTree<>('A');
        GeneralTree<Character> B = new GeneralTree<>('B');
        GeneralTree<Character> C = new GeneralTree<>('C');
        GeneralTree<Character> D = new GeneralTree<>('D');
        GeneralTree<Character> E = new GeneralTree<>('E');
        GeneralTree<Character> F = new GeneralTree<>('F');
        GeneralTree<Character> G = new GeneralTree<>('G');
        GeneralTree<Character> H = new GeneralTree<>('H');
        GeneralTree<Character> I = new GeneralTree<>('I');

        A.addChilds(B, C, D);
        B.addChild(E);
        C.addChilds(F, G);
        F.addChilds(H, I);

        List<List<Character>> caminos = new Parcial().caminosPares(A);
        List<List<Character>> expected = List.of(
                List.of('A', 'C', 'F', 'H'),
                List.of('A', 'C', 'F', 'I'),
                List.of('A', 'D')
        );

        assertEquals(expected, caminos);
    }
}
