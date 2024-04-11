package tp2;

public class Tests {
	public static void main(String[] args) { 
		BinaryTree<Integer> root = new BinaryTree<>(2);
		BinaryTree<Integer> siete = new BinaryTree<>(7);
		BinaryTree<Integer> mCinco = new BinaryTree<>(-5);
		BinaryTree<Integer> veintiTres = new BinaryTree<>(23);
		BinaryTree<Integer> seis = new BinaryTree<>(6);
		BinaryTree<Integer> dieciNueve = new BinaryTree<>(19);
		BinaryTree<Integer> mTres = new BinaryTree<>(-3);
		BinaryTree<Integer> cincuentaYCinco = new BinaryTree<>(55);
		BinaryTree<Integer> once = new BinaryTree<>(11);
		BinaryTree<Integer> cuatro = new BinaryTree<>(4);
		BinaryTree<Integer> dieciOcho = new BinaryTree<>(18);
		
		root.addLeftChild(siete);
		root.addRightChild(mCinco);
		
		siete.addLeftChild(veintiTres);
		siete.addRightChild(seis);
		
		mCinco.addLeftChild(dieciNueve);
		
		veintiTres.addLeftChild(mTres);
		
		seis.addLeftChild(cincuentaYCinco);
		seis.addRightChild(once);
		
		dieciNueve.addRightChild(cuatro);
		
		cuatro.addLeftChild(dieciOcho);
		
		System.out.println(new ParcialArboles(root).isLeftTree(7));
	}
}
