package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio3.Estudiante;

public class TestArrayList {

	public static void main(String[] args) {
		/*List<Estudiante> lista = incisoD();
		
		Estudiante e = new Estudiante("Maria", "Josefina", "asd", 5);
		
		if (!lista.contains(e)) {
			lista.add(e);
		}
		
		ArrayList<Integer> integerList = new ArrayList<>();
		
		integerList.add(2);
		integerList.add(5);
		integerList.add(2);

		System.out.println("integerList capicua?: " + esCapicua(integerList));*/
		ArrayList<Integer> list = calcularSucesion(6);
		printList(list);
		invertirArrayList(list);
		printList(list);
	}

	private static List<Estudiante> incisoD() {
		List<Estudiante> estudiantes = new ArrayList<>();
		estudiantes.add(new Estudiante("Vicente", "Garcia", "Calle 27, 2295", 1));
		estudiantes.add(new Estudiante("Maria", "Britez", "Calle 39, 1120", 2));
		estudiantes.add(new Estudiante("Juan", "Escudero", "Calle 426, 3756", 3));
		
		List<Estudiante> copy = new ArrayList<>();

		for (Estudiante e : estudiantes)
			copy.add(e);
		
		printList(estudiantes);
		printList(copy);
		
		copy.get(0).setNombre("Jose");
		
		printList(estudiantes);
		printList(copy);
		
		return estudiantes;
	}
	
	private static void printList(List<?> list) {
		System.out.println("----------------------");
		System.out.println("Lista: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + ": " + list.get(i));
		}
	}
	
	private static boolean esCapicua(ArrayList<Integer> list) {
		for (int i = 0; i < list.size() >> 1; i++) {
			if (list.get(i) == list.get(list.size() - 1 - i))
				continue;
			
			return false;
		}
		
		return true;
	}
	
	private static ArrayList<Integer> calcularSucesion(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(n);
		
		if (n % 2 == 0) {
			// Si es par n/2
			int i = n / 2;
			list.addAll(calcularSucesion(i));
		} else if (n % 2 != 0 && n != 1) {
			// Si es impar 3n + 1
			int i = 3*n + 1;
			list.addAll(calcularSucesion(i));
		}
		
		return list;
	}
	
	private static void invertirArrayList(ArrayList<Integer> lista) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = lista.size() - 1; i >= 0; i--) {
			list.add(lista.get(i));
		}
		
		for (int i = 0; i < list.size(); i++) {
			lista.set(i, list.get(i));
		}
	}
	
	private static int sumarLinkedList(LinkedList<Integer> list) {
		int ret = 0;
		for (int i : list) {
			ret += i;
		}
		return ret;
	}
	
	// TODO: Terminar
	private static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> retList = new ArrayList<>();
		
		return retList;
	}
}
