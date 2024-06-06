package ayed.tp3;

import java.util.List;

public class RedDeAguaPotable {
	private GeneralTree<Character> estructura;
	
	public RedDeAguaPotable(GeneralTree<Character> estructura) {
		this.estructura = estructura;
	}
	
	public double minimoCaudal(double caudal) {	
		return minimoCaudal(caudal, estructura);
	}
	
	private double minimoCaudal(double caudal, GeneralTree<Character> estructura) {
		if (estructura.isEmpty())
			return 0;
		
		if (estructura.isLeaf())
			return caudal;
		
		// Inicializo el minimo en algo mas grande
		double min = caudal + 1;
		
		if (estructura.hasChildren()) {
			List<GeneralTree<Character>> childrens = estructura.getChildren();
			double caudalChildren = caudal / childrens.size();
			
			for (GeneralTree<Character> child : childrens) {
				double ret = minimoCaudal(caudalChildren, child);
				
				if (ret < min)
					min = ret;
			}
		}
		
		return min;
	}

	public void setEstructura(GeneralTree<Character> estructura) {
		this.estructura = estructura;
	}
}