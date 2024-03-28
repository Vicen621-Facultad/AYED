package tp2;

import tp1.ejercicio8.Queue;

public class ProfundidadDeArbolBinario {
	private final BinaryTree<Integer> arbol;

	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int sumaElementosProfundidad(int p) {
		Queue<BinaryTree<Integer>> queue = new Queue<>();
		queue.enqueue(arbol);
		
		int level = 0;
		int ret = 0;
		BinaryTree<Integer> node = null;
		
		while (!queue.isEmpty()) {
			level++;
			int size = queue.size();
			
			while (size != 0) {
				node = queue.dequeue();
				
				if (level == p)
					ret += node.getData();
				
				if (node.hasLeftChild())
					queue.enqueue(node.getLeftChild());
					
				if (node.hasRightChild())
					queue.enqueue(node.getRightChild());
				
                size--;
			}
			
			if (level == p)
				break;
		}
		
		return ret;
	}
}
