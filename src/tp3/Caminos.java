package tp3;

import java.util.LinkedList;
import java.util.List;

public class Caminos {
	private GeneralTree<Integer> arbol;
	
	public Caminos(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public List<Integer> caminoAHojaMasLejana() {
		List<Integer> path = new LinkedList<>();
		List<Integer> maxPath = new LinkedList<>();
		caminoAHojaMasLejana(arbol, path, maxPath);
		return maxPath;
	}
	
	public void caminoAHojaMasLejana(GeneralTree<Integer> arbol, List<Integer> path, List<Integer> maxPath) {
		path.add(arbol.getData());
		
		if (arbol.isLeaf() && path.size() > maxPath.size()) {
			maxPath.clear();
			maxPath.addAll(path);
		} else {
			for (GeneralTree<Integer> child : arbol.getChildren())
				caminoAHojaMasLejana(child, path, maxPath);
		}
		
		path.remove(arbol.getData());
	}
	
	public void setArbol(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}
}
