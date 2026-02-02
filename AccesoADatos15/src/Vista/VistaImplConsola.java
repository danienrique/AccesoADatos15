package Vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class VistaImplConsola implements IVista{
	private static Scanner sc = new Scanner(System.in);
	public VistaImplConsola() {
		
	}
	public void mostrarMenu() {
			System.out.println("\nMENU");
			System.out.println("1. Insertar grupo");
			System.out.println("2. Insertar alumno");
			System.out.println("3. Mostrar alumnos con su grupo");
			System.out.println("4. Exportar alumnos a TXT");
			System.out.println("5. Importar alumnos desde TXT");
			System.out.println("6. Modificar nombre alumno por PK");
			System.out.println("7. Eliminar alumno por PK");
			System.out.println("8. Eliminar alumnos por curso");
			System.out.println("9. Exportar grupos a JSON");
			System.out.println("10. Importar grupos desde JSON");
			System.out.println("0. Salir");
		}
	@Override
	public int pedirOpcion() {
		System.out.print("Opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
	}
	@Override
	public String pedirNombreAlumno() {
		// TODO Auto-generated method stub
		System.out.println("¿Cual es el nombre del alumno?");
		return sc.nextLine();
	}
	@Override
	public String pedirApellidos() {
		System.out.println("¿Cual es el apellido del alumno?");
		return sc.nextLine();
	}
	@Override
	public char pedirGenero() {
		char genero = ' ';
	    boolean valido = false;

	    do {
	        System.out.println("Introduce el género del alumno (M/F)");
	        String entrada = sc.nextLine().trim().toUpperCase(); 

	        if (!entrada.isEmpty() && (entrada.charAt(0) == 'M' || entrada.charAt(0) == 'F')) {
	            genero = entrada.charAt(0);
	            valido = true;
	        } else {
	            System.out.println("Error: Por favor, introduce solo 'M' o 'F'.");
	        }
	    } while (!valido);

	    return genero;
	}
	@Override
	public LocalDate pedirFecha() {
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/mm/dd");
	    LocalDate fechaValida = null;

	    while (fechaValida == null) {
	        try {
	            System.out.println("Introduce la fecha de nacimiento (aaaa/mm/dd):");
	            String entrada = sc.nextLine();
	            fechaValida = LocalDate.parse(entrada, formato);
	            
	        } catch (DateTimeParseException e) {
	            System.out.println("Formato incorrecto. Por favor, usa el formato día/mes/año (ej: 2000/10/05)");
	        }
	    }
	    
	    return fechaValida;
	}
	@Override
	public String pedirNombreGrupo() {
		// TODO Auto-generated method stub
		System.out.println("¿Cual es el nombre del grupo?");
		return sc.nextLine();
	}
	@Override
	public int pedirIdGrupo() {
		System.out.println("Introduce el ID del grupo:");
        int id = sc.nextInt();
        sc.nextLine();
        return id;
	}
	@Override
	public String pedirCiclo() {
		// TODO Auto-generated method stub
		System.out.println("¿Cual es el nombre del ciclo?");
		return sc.nextLine();
	}
	@Override
	public String pedirCurso() {
		// TODO Auto-generated method stub
		System.out.println("¿Cual es el nombre del curso?");
		return sc.nextLine();
	}
	@Override
	public int pedirNia() {
		System.out.println("¿Cuál es el NIA del alumno?");
        int nia = sc.nextInt();
        sc.nextLine();
        return nia;
	}
	@Override
	public void mostrarDatosAlumnoGrupo(ArrayList<String> aux) {
		// TODO Auto-generated method stub
		for(int i = 0; i<aux.size();i++) {
			System.out.println(aux.get(i));
		}
	}
}
