package tp1.ejercicio3;

public class Test {

	public static void main(String[] args) {
		Estudiante[] estudiantes = new Estudiante[2];
		Profesor[] profesores = new Profesor[3];
		
		estudiantes[0] = new Estudiante("Vicente", "Garcia", "Calle 27, 2295", 1);
		estudiantes[1] = new Estudiante("Felipe", "Escudero", "Calle 426, 3756", 3);
		
		profesores[0] = new Profesor("Thomas", "Bertone", "Informatica", "FOD");
		profesores[1] = new Profesor("Tulio", "Semento", "Informatica", "Matematica 1");
		profesores[2] = new Profesor("Maria Luisa", "Britez", "Ingenieria", "Matematica A");
		
		for (int i = 0; i < estudiantes.length; i++) {
			System.out.println(estudiantes[i].tusDatos());
		}
		
		for (int i = 0; i < profesores.length; i++) {
			System.out.println(profesores[i].tusDatos());
		}
	}

}
