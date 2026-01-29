package Vista;

import java.time.LocalDate;
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
		// TODO Auto-generated method stub
		return sc.nextInt();
	}
	@Override
	public String pedirNombreAlumno() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String pedirApellidos() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public char pedirGenero() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public LocalDate pedirFecha() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String pedirNombreGrupo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int pedirIdGrupo() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String pedirCiclo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String pedirCurso() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int pedirNia() {
		// TODO Auto-generated method stub
		return 0;
	}
}
