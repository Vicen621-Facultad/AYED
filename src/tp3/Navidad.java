package tp3;

public class Navidad {
	private GeneralTree<?> arbol;
	
	public Navidad(GeneralTree<?> arbol) {
		this.arbol = arbol;
	}

	public String esAbetoNavidenio() {
		return esAbetoNavidenio(arbol) ? "Yes" : "No";
	}
	
	public boolean esAbetoNavidenio(GeneralTree<?> arbol) {
		if (!arbol.hasChildren())
			return false;
		
		int count = 0;
		// Inicializo en true ya que si tiene todos hijos nunca se llama
		boolean bool = true;
		
		for (GeneralTree<?> child : arbol.getChildren()) {
			if (child.isLeaf())
				count++;
			else
				// Tomo el bool anterior por si tiene multiples hijos (ult hoja cuaderno)
				bool &= esAbetoNavidenio(child);
		}
		return count >= 3 && bool;
	}
}
