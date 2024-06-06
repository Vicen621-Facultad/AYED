package ayed.tp3;

import java.util.LinkedList;
import java.util.List;

import ayed.tp1.ejercicio8.Queue;

public class RecorridosAG {

	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n) {
		List<Integer> list = new LinkedList<>();
		numerosImparesMayoresQuePreOrden(a, n, list);
		return list;
	}

	private void numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, int n, List<Integer> list) {
		if (a.isEmpty())
			return;

		if (a.getData() > n && a.getData() % 2 != 0)
			list.add(a.getData());

		if (a.hasChildren()) {
			for (GeneralTree<Integer> child : a.getChildren())
				numerosImparesMayoresQuePreOrden(child, n, list);
		}
	}

	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n) {
		List<Integer> list = new LinkedList<>();
		numerosImparesMayoresQueInOrden(a, n, list);
		return list;
	}

	private void numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, int n, List<Integer> list) {
		if (a.isEmpty())
			return;

		if (a.hasChildren())
			numerosImparesMayoresQueInOrden(a.getChildren().get(0), n, list);

		if (a.getData() > n && a.getData() % 2 != 0)
			list.add(a.getData());

		if (a.hasChildren()) {
			for (int i = 1; i < a.getChildren().size(); i++)
				numerosImparesMayoresQueInOrden(a.getChildren().get(i), n, list);
		}
	}

	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
		List<Integer> list = new LinkedList<>();
		numerosImparesMayoresQuePostOrden(a, n, list);
		return list;
	}

	private void numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, int n, List<Integer> list) {
		if (a.isEmpty())
			return;

		if (a.hasChildren()) {
			for (GeneralTree<Integer> child : a.getChildren())
				numerosImparesMayoresQuePostOrden(child, n, list);
		}

		if (a.getData() > n && a.getData() % 2 != 0)
			list.add(a.getData());
	}

	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
		List<Integer> list = new LinkedList<>();
		GeneralTree<Integer> aux;

		Queue<GeneralTree<Integer>> queue = new Queue<>();
		queue.enqueue(a);
		while (!queue.isEmpty()) {
			aux = queue.dequeue();

			if (aux.getData() > n && aux.getData() % 2 != 0)
				list.add(aux.getData());

			for (GeneralTree<Integer> child : aux.getChildren())
				queue.enqueue(child);
		}

		return list;
	}
}
