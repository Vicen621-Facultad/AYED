package tp2;

public class Transformacion {
	private final BinaryTree<Integer> arbol;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> suma() {
		return suma(new BinaryTree<>());
	}
	
	/**
	 * Suma el total de los subarboles izquierdo y derecho sin sumar la raiz
	 * @param arbol El arbol a sumar
	 * @return La suma de los subarboles
	 */
	private int sumarArbol(BinaryTree<Integer> arbol) {
		if (arbol.isLeaf())
			return 0;
		
		int ret = 0;
		if (arbol.hasLeftChild())
			ret += sumarArbol(arbol.getLeftChild());
		
		if (arbol.hasRightChild())
			ret += sumarArbol(arbol.getRightChild());
		
		return ret;
	}
	
	public BinaryTree<Integer> suma(BinaryTree<Integer> arbol) {
			
	}
}
