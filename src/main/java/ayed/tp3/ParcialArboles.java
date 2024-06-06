package ayed.tp3;

import ayed.tp1.ejercicio8.Queue;

import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		if (arbol.isLeaf())
			return true;
		
		int min = Integer.MAX_VALUE;
		boolean bool = true;
		for (GeneralTree<Integer> child : arbol.getChildren()) {
			if (child.getData() < min)
				min = child.getData();
			
			bool &= esDeSeleccion(child);
		}
		
		return bool && min == arbol.getData();
	}
	
	public static List<Integer> caminoFiltradoValorMaximo(GeneralTree<Integer> arbol) {
		List<Integer> path = new LinkedList<>();
		List<Integer> maxPath = new LinkedList<>();
		caminoFiltradoValorMaximo(arbol, path, maxPath, 0, -1, 0);
		return maxPath;
	}
	
	private static int caminoFiltradoValorMaximo(GeneralTree<Integer> arbol, List<Integer> path, List<Integer> maxPath, int current, int max, int level) {
		current += arbol.getData() * level;
		if (arbol.getData() != 0)
			path.add(arbol.getData());
		
		if (arbol.isLeaf()) {
			if (current > max) {
				max = current;
				maxPath.clear();
				maxPath.addAll(path);
			}
		} else {
			for (GeneralTree<Integer> child : arbol.getChildren()) {
				max = Math.max(max, caminoFiltradoValorMaximo(child, path, maxPath, current, max, level + 1));
			}
		}
		
		if (arbol.getData() != 0)
			path.remove(path.size() - 1);
		
		return max;
	}
	
	public static boolean esCreciente(GeneralTree<Integer> arbol) {
		int previousLevel = 0;
		boolean condition = true;
		GeneralTree<Integer> aux;

		Queue<GeneralTree<Integer>> queue = new Queue<>();
		queue.enqueue(arbol);
		while (!queue.isEmpty() && condition) {
			int size = queue.size();
			int currentLevel = 0;

			while (size != 0) {
				currentLevel++;
				aux = queue.dequeue();

				for (GeneralTree<Integer> child : aux.getChildren())
					queue.enqueue(child);

				size--;
			}

			condition = previousLevel + 1 == currentLevel;
			previousLevel = currentLevel;
		}
		
		return condition;
	}
}