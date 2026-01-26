package Dao;

import Model.Alumno;
import Model.Grupo;

public interface AlumnoDao {
	public void insertarGrupo(Grupo g);
	public void insertarAlumno(Alumno a);
	public void mostrarAlumnos();
	public void modificarNombreAlumno(Alumno a);
	public void eliminarAlumnoPK(int pk);
	public void eliminarAlumnoCurso(Grupo g);
}
