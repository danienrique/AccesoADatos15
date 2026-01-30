package App;

import java.util.ArrayList;

import Model.Alumno;
import Model.Grupo;

public interface Conversor {
	void exportarAlumnos(ArrayList<Alumno> alm);
	void exportarGrupos(ArrayList<Grupo> grp);
	ArrayList<Alumno> importarAlumnos();
	ArrayList<Grupo> importarGrupos();
}
