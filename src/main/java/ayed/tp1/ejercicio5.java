package ayed.tp1;

public class ejercicio5 {
	
	public static void main(String[] args) {
		int[] array = new int[]{12, 71, 7, 31, 89, 93, 53, 27, 98, 69};
		int[] results = calculate(array);
		printArray("Resultados return", results);
		
		int[] resultsReference = new int[3];
		calculate(array, resultsReference);
		printArray("Resultados referencia", resultsReference);
	}
	
	private static void printArray(String name, int[] array) {
		System.out.print(name + ": ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
	
	private static int[] calculate(int[] array) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int total = 0;
		
		for (int i = 0; i < array.length; i++) {
			int n = array[i];
			
			if (n < min)
				min = n;
			
			if (n > max)
				max = n;
			
			total += n;
		}
		
		return new int[]{min, max, total / array.length};
	}
	
	private static void calculate(int[] array, int[] results) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int total = 0;
		
		for (int i = 0; i < array.length; i++) {
			int n = array[i];
			
			if (n < min)
				min = n;
			
			if (n > max)
				max = n;
			
			total += n;
		}
		
		results[0] = min;
		results[1] = max;
		results[2] = total / array.length;
	}
}
