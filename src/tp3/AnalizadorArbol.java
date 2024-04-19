package tp3;

import tp1.ejercicio8.Queue;

public class AnalizadorArbol {
	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		Queue<GeneralTree<AreaEmpresa>> queue = new Queue<>();
		GeneralTree<AreaEmpresa> aux;
		queue.enqueue(arbol);
		double max = -1;
		
		while (!queue.isEmpty()) {
			int count = 0;
			int nodes = 0;
			int size = queue.size();
			
			while (size != 0) {
				aux = queue.dequeue();
				nodes++;
				count += aux.getData().getDelay();
				
				if (aux.hasChildren()) {
					for (GeneralTree<AreaEmpresa> children : aux.getChildren())
						queue.enqueue(children);
				}
				
				size--;
			}
			
			double levelAverage = count / nodes;
			max = Math.max(max, levelAverage);
		}
		
		return max;
	}

	public static class AreaEmpresa {
		private String id;
		private int delay;
		
		public AreaEmpresa(String id, int delay) {
			this.id = id;
			this.delay = delay;
		}
		
		public int getDelay() {
			return delay;
		}
		
		public String getId() {
			return id;
		}
		
		public void setDelay(int delay) {
			this.delay = delay;
		}
		
		public void setId(String id) {
			this.id = id;
		}
	}
}
