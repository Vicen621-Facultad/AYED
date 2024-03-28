package tp2;

public class Tests {
	public static void main(String[] args) {
		 //           14
        //         /    \
        //        53     2
        //       / \    / \
        //      12  9  33 102
        BinaryTree<Integer> root =new BinaryTree<>(14);
        BinaryTree<Integer> cincuentaYTres =new BinaryTree<>(53);
        BinaryTree<Integer> dos =new BinaryTree<>(2);
        BinaryTree<Integer> doce =new BinaryTree<>(12);
        BinaryTree<Integer> nueve = new BinaryTree<>(9);
        BinaryTree<Integer> treintaYTres =new BinaryTree<>(33);
        BinaryTree<Integer> cientoDos =new BinaryTree<>(102);

        root.addLeftChild(cincuentaYTres);
        root.addRightChild(dos);
        cincuentaYTres.addLeftChild(doce);
        cincuentaYTres.addRightChild(nueve);
        dos.addLeftChild(treintaYTres);
        dos.addRightChild(cientoDos);

		ProfundidadDeArbolBinario pab = new ProfundidadDeArbolBinario(root);
		System.out.println(pab.sumaElementosProfundidad(3));
	}
}
