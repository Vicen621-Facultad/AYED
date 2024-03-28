package tp2;

import tp1.ejercicio8.Queue;

public class BinaryTree<T> {
	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;

	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Consultar hasLeftChild() antes de invocar
	 * 
	 * @return El hijo izquierdo de este nodo
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * Consultar hasLeftChild() antes de invocar
	 * 
	 * @return El hijo derecho de este nodo
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty() {
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}

	public boolean hasLeftChild() {
		return this.leftChild != null;
	}

	public boolean hasRightChild() {
		return this.rightChild != null;
	}

	public int contarHojas() {
		// Si el nodo es una hoja devuelvo 1
		if (isLeaf())
			return 1;

		// Si no es una hoja, cuento las hojas de sus sub-arboles
		int ret = 0;
		if (hasLeftChild())
			ret += getLeftChild().contarHojas();

		if (hasRightChild())
			ret += getRightChild().contarHojas();

		return ret;
	}

	public BinaryTree<T> espejo() {
		BinaryTree<T> aux = new BinaryTree<>();
		
		if (!isEmpty())
			aux.setData(getData());
		
		if (hasRightChild())
			aux.addLeftChild(getRightChild().espejo());
		
		if (hasLeftChild())
			aux.addRightChild(getLeftChild().espejo());
		
		return aux;
	}

	// 0 <= n <= m <= altura
	public void entreNiveles(int n, int m) {
		Queue<BinaryTree<T>> queue = new Queue<>();
		queue.enqueue(this);
		
		int level = 0;
		BinaryTree<T> node = null;
		while (!queue.isEmpty()) {
			level++;
			int size = queue.size();
			
			while (size != 0) {
				node = queue.dequeue();
				
				if (n <= level && level <= m)
					System.out.print(node + " ");
				
				if (node.hasLeftChild())
					queue.enqueue(node.getLeftChild());
					
				if (node.hasRightChild())
					queue.enqueue(node.getRightChild());
				
                size--;
			}
			
			if (n <= level && level <= m) {
                System.out.println();
            }
		}
	}

	@Override
	public String toString() {
		return this.getData().toString();
	}
}
