package tp2;

import java.util.ArrayList;
import java.util.List;

public class ContadorArbol {
	private final BinaryTree<Integer> arbol;

	public ContadorArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public List<Integer> numerosParesInOrden() {
		List<Integer> list = new ArrayList<>();
		numerosParesInOrden(arbol, list);
		return list;
	}
	
	private void numerosParesInOrden(BinaryTree<Integer> arbol, List<Integer> list) {
		if (arbol.hasLeftChild())
			numerosParesInOrden(arbol.getLeftChild(), list);
		
		if (arbol.getData() % 2 == 0)
			list.add(arbol.getData());
		
		if (arbol.hasRightChild())
			numerosParesInOrden(arbol.getRightChild(), list);
	}
	
	public List<Integer> numerosParesPostOrden() {
		List<Integer> list = new ArrayList<>();
		numerosParesPostOrden(arbol, list);
		return list;
	}

	private void numerosParesPostOrden(BinaryTree<Integer> arbol, List<Integer> list) {
		if (arbol.hasLeftChild())
			numerosParesPostOrden(arbol.getLeftChild(), list);
		
		if (arbol.hasRightChild())
			numerosParesPostOrden(arbol.getRightChild(), list);

		if (arbol.getData() % 2 == 0)
			list.add(arbol.getData());
	}
}
