package ayed.tp1.ejercicio9;

import java.util.Scanner;
import java.util.Stack;

public class TestBalanceo {
	
	private static final Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) {
		System.out.print("Inserte el string a verificar: ");
		String s;
		try (Scanner scanner = new Scanner(System.in)) {
			s = scanner.next();
		}
		
		System.out.println("\""+ s + "\" esta balanceado? " + balanced(s));
	}
	
	private static boolean balanced(String s) {
		if (s.isEmpty())
			return true;
		
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			
			switch (c) {
				case '{', '(', '[' -> {
					stack.push(c);
					return balanced(s.substring(i + 1));
				}
				case ')' -> {
					Character other = stack.pop();
					if (other == '(') {
						return balanced(s.substring(i + 1));
					}
				}
				case '}' -> {
					Character other = stack.pop();
					if (other == '{') {
						return balanced(s.substring(i + 1));
					}
				}
				case ']' -> {
					Character other = stack.pop();
					if (other == '[') {
						return balanced(s.substring(i + 1));
					}
				}
			}
		}
		
		return false;
	}
}
