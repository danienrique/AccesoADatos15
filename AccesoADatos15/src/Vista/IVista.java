package Vista;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IVista {
	public void mostrarMenu();
	public int pedirOpcion();
	public int pedirNia();
	public String pedirNombreAlumno();
	public String pedirApellidos();
	public char pedirGenero();
	public LocalDate pedirFecha();
	public String pedirNombreGrupo();
	public int pedirIdGrupo();
	public String pedirCiclo();
	public String pedirCurso();
	public void mostrarDatosAlumnoGrupo(ArrayList<String> aux);
}
