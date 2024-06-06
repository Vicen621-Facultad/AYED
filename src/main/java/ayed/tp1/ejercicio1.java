package ayed.tp1;

public class ejercicio1 {
	
	public static void main(String[] args) {
		System.out.print("for: ");
		printBetweenFor(1, 4);
		System.out.println("");
		

		System.out.print("while: ");
		printBetweenWhile(1, 4);
		System.out.println("");
		
		System.out.print("rescursivo: ");
		printBetweenRecursive(1, 4);
	}
	
	private static void printBetweenFor(int a, int b) {
		for (int i = a; i <= b; i++) {
			System.out.print(i + " ");
		}
	}
	
	private static void printBetweenWhile(int a, int b) {
		int i = a;
		while (i <= b) {
			System.out.print(i + " ");
			i++;
		}
	}
	
	private static void printBetweenRecursive(int a, int b) {
		if (a > b)
			return;
		
		System.out.print(a++ + " ");
		printBetweenRecursive(a, b);
	}
}
